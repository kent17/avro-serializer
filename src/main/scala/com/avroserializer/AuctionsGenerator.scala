package com.avroserializer


object AuctionHandler{
  def randomAuction(): Auction = {
    val r = scala.util.Random
    new Auction(
      r.nextInt(100),
      r.nextInt(10000),
      r.nextFloat()*500
      )
  }

  def createAuctionSet(n: Long) : List[Auction] = {
    addAuctionSet(n, Nil)
  }

  def addAuctionSet(n: Long, l: List[Auction]) : List[Auction] = {
    if(n==0) l
    else addAuctionSet(n-1, randomAuction() :: l)
  }
}


object AuctionHeavyHandler{
  def randomAuctionHeavy(): AuctionHeavy = {
    val r = scala.util.Random
    new AuctionHeavy(
      r.nextInt(100),
      r.nextInt(10000),
      r.nextFloat()*500,
      randomString(250),
      "azeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeazeaze" + r.nextInt(10),
      "escargotescargotescargotescargotescargotescargotescargotescargotescargotescargotescargotescargotescargot" + r.nextInt(10),
      "saladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesaladesalade" + r.nextInt(10),
      "stringstringstring" + r.nextInt(10)
      )
  }

  def createAuctionHeavySet(n: Long) : List[AuctionHeavy] = {
    addAuctionHeavySet(n, Nil)
  }

  def addAuctionHeavySet(n: Long, l: List[AuctionHeavy]) : List[AuctionHeavy] = {
    if(n==0) l
    else addAuctionHeavySet(n-1, randomAuctionHeavy() :: l)
  }

  def randomStringRecursive(n: Int): List[Char] = {
    n match {
      case 1 => List(scala.util.Random.nextPrintableChar)
      case _ => List(scala.util.Random.nextPrintableChar) ++ randomStringRecursive(n-1)
    }
  }

  def randomString(n: Int): String = {
    randomStringRecursive(n).mkString
  }
}

object AuctionNestedHandler{
  def randomAuctionHeavy(): AuctionNested = {
    val r = scala.util.Random
    new AuctionNested(
      r.nextInt(100),
      r.nextInt(10000),
      r.nextFloat()*500,
      new Publisher(
          r.nextInt(10000),
          randomString(50)
        )
      )
  }

  def createAuctionNestedSet(n: Long) : List[AuctionNested] = {
    addAuctionNestedSet(n, Nil)
  }

  def addAuctionNestedSet(n: Long, l: List[AuctionNested]) : List[AuctionNested] = {
    if(n==0) l
    else addAuctionNestedSet(n-1, randomAuctionHeavy() :: l)
  }

  def randomStringRecursive(n: Int): List[Char] = {
    n match {
      case 1 => List(scala.util.Random.nextPrintableChar)
      case _ => List(scala.util.Random.nextPrintableChar) ++ randomStringRecursive(n-1)
    }
  }

  def randomString(n: Int): String = {
    randomStringRecursive(n).mkString
  }
}

object AuctionHeavyNestedHandler{
  def randomAuctionHeavyNested(): AuctionHeavyNested = {
    val r = scala.util.Random
    new AuctionHeavyNested(
      new AuctionNested(
        r.nextInt(100),
        r.nextInt(10000),
        r.nextFloat()*500,
        new Publisher(
          r.nextInt(10000),
          randomString(50)
          )
        ),
      new PublisherHeavy(
        new Publisher(
          r.nextInt(10000),
          randomString(50)
          ),
        new PublisherExtraInfo (
          randomString(120),
          randomString(120),
          randomString(120),
          randomString(120)
          ),
        randomString(120),
        randomString(150)
      ),
      randomString(120),
      randomString(150)
      )
  }

  def createAuctionHeavyNestedSet(n: Long) : List[AuctionHeavyNested] = {
    addAuctionHeavyNestedSet(n, Nil)
  }

  def addAuctionHeavyNestedSet(n: Long, l: List[AuctionHeavyNested]) : List[AuctionHeavyNested] = {
    if(n==0) l
    else addAuctionHeavyNestedSet(n-1, randomAuctionHeavyNested() :: l)
  }

  def randomStringRecursive(n: Int): List[Char] = {
    n match {
      case 1 => List(scala.util.Random.nextPrintableChar)
      case _ => List(scala.util.Random.nextPrintableChar) ++ randomStringRecursive(n-1)
    }
  }

  def randomString(n: Int): String = {
    randomStringRecursive(n).mkString
  }
}

