/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class AuctionHeavy(var auctionId: Int, var publisherId: Int, var revenue: Float, var publisherName: String, var publisherCEOName: String, var publisherCEODogName: String, var publisherCEODogVetName: String, var publisherCEODogVetWifeName: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(1, 1, 1.0F, "", "", "", "", "")
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
      case pos if pos == 4 => {
        publisherCEOName
      }.asInstanceOf[AnyRef]
      case pos if pos == 5 => {
        publisherCEODogName
      }.asInstanceOf[AnyRef]
      case pos if pos == 6 => {
        publisherCEODogVetName
      }.asInstanceOf[AnyRef]
      case pos if pos == 7 => {
        publisherCEODogVetWifeName
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
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 4 => this.publisherCEOName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 5 => this.publisherCEODogName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 6 => this.publisherCEODogVetName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 7 => this.publisherCEODogVetWifeName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = AuctionHeavy.SCHEMA$
}

object AuctionHeavy {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AuctionHeavy\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"auctionId\",\"type\":\"int\"},{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"revenue\",\"type\":\"float\"},{\"name\":\"publisherName\",\"type\":\"string\"},{\"name\":\"publisherCEOName\",\"type\":\"string\"},{\"name\":\"publisherCEODogName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetWifeName\",\"type\":\"string\"}]}")
}