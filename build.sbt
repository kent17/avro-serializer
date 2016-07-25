name := "SparkAvroSerializer"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.codehaus.jackson" % "jackson-core-asl" % "1.6.1"
libraryDependencies += "org.scala-tools.testing" % "specs_2.8.0" % "1.6.5" % "test"
libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.10.5"
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.4.1" % "provided"
libraryDependencies += "com.esotericsoftware" % "kryo-shaded" % "3.0.3"

libraryDependencies += "org.apache.avro" % "avro" % "1.7.7"
libraryDependencies += "org.apache.avro" % "avro-mapred" % "1.7.7" classifier "hadoop2"
//libraryDependencies += "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3"
//libraryDependencies += "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"
libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"

libraryDependencies += "com.julianpeeters" %% "avrohugger-core" % "0.5.2"
libraryDependencies += "com.julianpeeters" %% "avrohugger-core" % "0.5.2"

//seq( sbtavrohugger.SbtAvrohugger.avroSettings : _*)
seq( sbtavrohugger.SbtAvrohugger.specificAvroSettings : _*)