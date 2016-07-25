package com.avroserializer

import avrohugger._
import com.esotericsoftware.kryo.{Kryo, Serializer}
import com.esotericsoftware.kryo.io.{Input, Output}
import format._
import java.io.File
import java.io.IOException
import java.io.{BufferedOutputStream,FileOutputStream}
import org.apache.avro.mapred.AvroKey
import org.apache.avro.mapreduce.{ AvroJob, AvroKeyInputFormat,AvroKeyOutputFormat }
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.io.NullWritable
import org.apache.hadoop.io.compress.{CompressionCodec, DefaultCodec, GzipCodec}
import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.commons.io.FileUtils


// Original code : https://github.com/massie/spark-parquet-example
object SparkAvroExample {

  def main(args: Array[String]) {
    val nbOutliers = 5
    val nbTirages = 25
    val nbAuctions = 1000
    val nbPartitions = 1
    val x = List.fill(nbTirages)(nbAuctions)
    // x = 10000, 10000, ..., 10000

    val sparkConf = new SparkConf()
//      .setMaster("local")
      .setAppName("SparkAvroSerializer")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.eventLog.enabled", "true")
      .set("spark.eventLog.dir", "spark-events")
      
    val sc = new SparkContext(sparkConf)

    val results = x
        .map(na => usingAvro(sc,na,nbPartitions)) // fait les tirages
        .splitAt(nbOutliers)
        ._2 // Retire les premiers résultats (outliers)
    println("results w/ outliers: " + results)

    // Résultats par catégorie, triés
    val writingResults = results.foldLeft(List[Float]())( _ :+ _._1).sorted
    val readingResults = results.foldLeft(List[Float]())( _ :+ _._2).sorted
    val readingFilteredResults = results.foldLeft(List[Float]())( _ :+ _._3).sorted
    val readingFilteredColumnResults = results.foldLeft(List[Float]())( _ :+ _._4).sorted
    val dirSizeResults = results.foldLeft(List[Float]())( _ :+ _._5).sorted
    println("writingResults: " + writingResults)
    println("readingResults: " + readingResults)
    println("readingFilteredResults: " + readingFilteredResults)
    println("readingFilteredColumnResults: " + readingFilteredColumnResults)
    println("dirSizeResults: " + dirSizeResults)
    val writingSum = writingResults.foldLeft(0.0)(_ + _)
    val readingSum = readingResults.foldLeft(0.0)(_ + _)
    val readingFilteredSum = readingFilteredResults.foldLeft(0.0)(_ + _)
    val readingFilteredColumnSum = readingFilteredColumnResults.foldLeft(0.0)(_ + _)
    val dirSizeSum = dirSizeResults.foldLeft(0.0)(_ + _)

    val writingAvg = writingSum / (nbTirages-nbOutliers)
    val readingAvg = readingSum / (nbTirages-nbOutliers)
    val readingFilteredAvg = readingFilteredSum / (nbTirages-nbOutliers)
    val readingFilteredColumnAvg = readingFilteredColumnSum / (nbTirages-nbOutliers)
    val dirSizeAvg = dirSizeSum / (nbTirages-nbOutliers)
    val writingStd = computeStd(writingResults, writingAvg)
    val readingStd = computeStd(readingResults, readingAvg)
    val readingFilteredStd = computeStd(readingFilteredResults, readingFilteredAvg)
    val readingFilteredColumnStd = computeStd(readingFilteredColumnResults, readingFilteredColumnAvg)
    val dirSizeStd = computeStd(dirSizeResults, dirSizeAvg)

    println("writingAvg = " + writingAvg)
    println("writingStd = " + writingStd)
    println("readingAvg = " + readingAvg)
    println("readingStd = " + readingStd)
    println("readingFilteredAvg = " + readingFilteredAvg)
    println("readingFilteredStd = " + readingFilteredStd)
    println("readingFilteredColumnAvg = " + readingFilteredColumnAvg)
    println("readingFilteredColumnStd = " + readingFilteredColumnStd)
    println("dirSizeAvg = " + dirSizeAvg)
    println("dirSizeStd = " + dirSizeStd)

    val alpha = 0.90
    val quantileIndex = Math.round(alpha * (nbTirages - nbOutliers - 1))
    val writingQuantile = writingResults(quantileIndex.toInt)
    println("writingQuantile: " + writingQuantile)
    val readingQuantile = readingResults(quantileIndex.toInt)
    println("readingQuantile: " + readingQuantile)
    val readingFilteredQuantile = readingFilteredResults(quantileIndex.toInt)
    println("readingFilteredQuantile: " + readingFilteredQuantile)
    val readingFilteredColumnQuantile = readingFilteredColumnResults(quantileIndex.toInt)
    println("readingFilteredColumnQuantile: " + readingFilteredColumnQuantile)
    val dirSizeQuantile = dirSizeResults(quantileIndex.toInt)
    println("dirSizeQuantile: " + dirSizeQuantile)

    println("WRITING")
    println("READING")
    println("READING FILTERED")
    println("READING FILTERED BY COLUMN")
    println("HDFS DIRECTORY SIZE")

    println(writingAvg)
    println(readingAvg)
    println(readingFilteredAvg)
    println(readingFilteredColumnAvg)
    println(dirSizeAvg)
    println("")
    println(writingStd)
    println(readingStd)
    println(readingFilteredStd)
    println(readingFilteredColumnStd)
    println(dirSizeStd)
    println("")
    
    println(writingQuantile)
    //printToSpreadsheet(writingResults)
    println(readingQuantile)
    //printToSpreadsheet(readingResults)
    println(readingFilteredQuantile)
    //printToSpreadsheet(readingFilteredResults)
    println(readingFilteredColumnQuantile)
    //printToSpreadsheet(readingFilteredColumnResults)
    println(dirSizeQuantile)
    //printToSpreadsheet(dirSizeResults)

    println("THE END")
  }

  private def computeStd(vector: List[Float], mean: Double): Double = {
    val devs = vector.map(value => (value - mean) * (value - mean))
    Math.sqrt(devs.sum / vector.size)
  }

  private def printToSpreadsheet(listFloats: List[Float]) {
    println(listFloats.foldLeft("")( _ + _.toString + "\n"))
  }

  private def auctionPrinter(tuple: Tuple2[Void, Auction]) = {
    if (tuple._2 != null) println(tuple._1+" --- "+tuple._2)
  }

  def usingAvro(sc: SparkContext, nbAuctions: Int, nbPartitions: Int): Tuple5[Float,Float,Float, Float, Float] = {

    val outputDir = new File("outputrdddfile.bin").getAbsolutePath
    println(outputDir)

    println(nbAuctions + " auctions")
    val someAuctions = AuctionHandler.createAuctionSet(nbAuctions)

    val ones = List.fill(nbPartitions){1}
    val fakeRdd = sc.makeRDD(ones, nbPartitions) // 100 partitions
    val rddWithAuctions = fakeRdd.flatMap( 
        (_) => {
            AuctionHeavyHandler.createAuctionHeavySet(nbAuctions)
        }
    )
    val rddWithAuctionsAvrozied = rddWithAuctions.map { s => (new AvroKey(s), NullWritable.get) }
    println("partionned rdd created !!")

    val rdd = sc.makeRDD(someAuctions.map { s => (new AvroKey(s), NullWritable.get) } )   
    //val bigRdd = (1 to n) foreach (x => /* do something */)

    // Save the RDD to a Parquet file in our temporary output directory
    println("saving rdd...")
    val startWrite = System.currentTimeMillis()

    val job = new Job()
    AvroJob.setOutputKeySchema(job, AuctionHeavy.SCHEMA$)
    //FileOutputFormat.setOutputCompressorClass(job, classOf[GzipCodec] )
    rddWithAuctionsAvrozied.saveAsNewAPIHadoopFile(outputDir, // path
            classOf[AvroKey[AuctionHeavy]], // key
            classOf[NullWritable], // value
            classOf[AvroKeyOutputFormat[AuctionHeavy]], //outputformat
            job.getConfiguration)
    //println("output.close()...")
    //output.close()
    val writingTime = System.currentTimeMillis()-startWrite
    println("Ecriture : "+writingTime+"ms")

    val startRead = System.currentTimeMillis()
    AvroJob.setInputKeySchema(job, AuctionHeavy.SCHEMA$)
    val inputFile = sc.newAPIHadoopFile(outputDir,
            classOf[AvroKeyInputFormat[AuctionHeavy]], //outputformat
            classOf[AvroKey[AuctionHeavy]], // key
            classOf[NullWritable], // value
            job.getConfiguration)
    val countReading = inputFile.count()
    val readingTime = System.currentTimeMillis()-startRead
    println("Lecture : "+readingTime+"ms")
    //inputFile.foreach(println)

    val startReadPredicate = System.currentTimeMillis()
    AvroJob.setInputKeySchema(job, AuctionHeavy.SCHEMA$)
    val filteredFile = sc.newAPIHadoopFile(outputDir,
            classOf[AvroKeyInputFormat[AuctionHeavy]], //outputformat
            classOf[AvroKey[AuctionHeavy]], // key
            classOf[NullWritable], // value
            job.getConfiguration)
    val auctions = filteredFile map {elt => elt._1}
    val auctionsData = auctions.map(x => x.datum())
    val filteredAuctions = auctionsData.filter(x => x.get(1) == 13)
    val readPredCount = filteredAuctions.count()
    val readingAndFilteringTime = System.currentTimeMillis()-startReadPredicate
    println("Lecture filtrée : "+readingAndFilteringTime+"ms")

    // Read with filter by column
    val startReadByColumn = System.currentTimeMillis()
    AvroJob.setInputKeySchema(job, AuctionHeavy.SCHEMA$)
    val file = sc.newAPIHadoopFile(outputDir,
            classOf[AvroKeyInputFormat[AuctionHeavy]], //outputformat
            classOf[AvroKey[AuctionHeavy]], // key
            classOf[NullWritable], // value
            job.getConfiguration)
    val auctionsCol = file map {elt => elt._1}
    val auctionsDataCol = auctionsCol.map(x => x.datum())
    val filteredAuctionsCol = auctionsDataCol.map{case ah:AuctionHeavy => (ah.auctionId, ah.revenue, ah.publisherCEODogName) }
    val filteredCol = filteredAuctionsCol.count()
    val readByColumnTime = System.currentTimeMillis()-startReadByColumn
    println("Lecture filtrée par colonne: "+ readByColumnTime +"ms")

    val dirSize = getDirSize(new File(outputDir))
    println("dirSize: " + dirSize)
    println("Deleting output folder...")
    FileUtils.deleteDirectory(new File(outputDir))
    println("Done")
    new Tuple5(writingTime, readingTime, readingAndFilteringTime, readByColumnTime, dirSize)
  }

  def getDirSize(directory: File): Float = {
    val lengths = for (file <- directory.listFiles()) yield {
        if (file.isFile()) file.length()
        else getDirSize(file)
    }
    lengths.sum
  }
}

