/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class AuctionHeavyNested(var auctionNested: AuctionNested, var publisherName: PublisherHeavy, var extraString1: String, var extraString2: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(new AuctionNested, new PublisherHeavy, "", "")
  def get(field: Int): AnyRef = {
    field match {
      case pos if pos == 0 => {
        auctionNested
      }.asInstanceOf[AnyRef]
      case pos if pos == 1 => {
        publisherName
      }.asInstanceOf[AnyRef]
      case pos if pos == 2 => {
        extraString1
      }.asInstanceOf[AnyRef]
      case pos if pos == 3 => {
        extraString2
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field: Int, value: Any): Unit = {
    field match {
      case pos if pos == 0 => this.auctionNested = {
        value
      }.asInstanceOf[AuctionNested]
      case pos if pos == 1 => this.publisherName = {
        value
      }.asInstanceOf[PublisherHeavy]
      case pos if pos == 2 => this.extraString1 = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 3 => this.extraString2 = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = AuctionHeavyNested.SCHEMA$
}

object AuctionHeavyNested {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AuctionHeavyNested\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"auctionNested\",\"type\":{\"type\":\"record\",\"name\":\"AuctionNested\",\"fields\":[{\"name\":\"auctionId\",\"type\":\"int\"},{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"revenue\",\"type\":\"float\"},{\"name\":\"publisherName\",\"type\":{\"type\":\"record\",\"name\":\"Publisher\",\"fields\":[{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"publisherName\",\"type\":\"string\"}]}}]}},{\"name\":\"publisherName\",\"type\":{\"type\":\"record\",\"name\":\"PublisherHeavy\",\"fields\":[{\"name\":\"publisher\",\"type\":\"Publisher\"},{\"name\":\"extraInfo\",\"type\":{\"type\":\"record\",\"name\":\"PublisherExtraInfo\",\"fields\":[{\"name\":\"publisherCEOName\",\"type\":\"string\"},{\"name\":\"publisherCEODogName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetWifeName\",\"type\":\"string\"}]}},{\"name\":\"extraString1\",\"type\":\"string\"},{\"name\":\"extraString2\",\"type\":\"string\"}]}},{\"name\":\"extraString1\",\"type\":\"string\"},{\"name\":\"extraString2\",\"type\":\"string\"}]}")
}