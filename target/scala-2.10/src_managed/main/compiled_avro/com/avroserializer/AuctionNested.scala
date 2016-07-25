/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class AuctionNested(var auctionId: Int, var publisherId: Int, var revenue: Float, var publisherName: Publisher) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(1, 1, 1.0F, new Publisher)
  def get(field: Int): AnyRef = {
    field match {
      case pos if pos == 0 => {
        auctionId
      }.asInstanceOf[AnyRef]
      case pos if pos == 1 => {
        publisherId
      }.asInstanceOf[AnyRef]
      case pos if pos == 2 => {
        revenue
      }.asInstanceOf[AnyRef]
      case pos if pos == 3 => {
        publisherName
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field: Int, value: Any): Unit = {
    field match {
      case pos if pos == 0 => this.auctionId = {
        value
      }.asInstanceOf[Int]
      case pos if pos == 1 => this.publisherId = {
        value
      }.asInstanceOf[Int]
      case pos if pos == 2 => this.revenue = {
        value
      }.asInstanceOf[Float]
      case pos if pos == 3 => this.publisherName = {
        value
      }.asInstanceOf[Publisher]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = AuctionNested.SCHEMA$
}

object AuctionNested {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AuctionNested\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"auctionId\",\"type\":\"int\"},{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"revenue\",\"type\":\"float\"},{\"name\":\"publisherName\",\"type\":{\"type\":\"record\",\"name\":\"Publisher\",\"fields\":[{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"publisherName\",\"type\":\"string\"}]}}]}")
}