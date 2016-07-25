/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class Auction(var auctionId: Int, var publisherId: Int, var revenue: Float) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(1, 1, 1.0F)
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
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = Auction.SCHEMA$
}

object Auction {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Auction\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"auctionId\",\"type\":\"int\"},{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"revenue\",\"type\":\"float\"}]}")
}