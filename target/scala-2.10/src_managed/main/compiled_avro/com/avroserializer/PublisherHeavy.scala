/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class PublisherHeavy(var publisher: Publisher, var extraInfo: PublisherExtraInfo, var extraString1: String, var extraString2: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(new Publisher, new PublisherExtraInfo, "", "")
  def get(field: Int): AnyRef = {
    field match {
      case pos if pos == 0 => {
        publisher
      }.asInstanceOf[AnyRef]
      case pos if pos == 1 => {
        extraInfo
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
      case pos if pos == 0 => this.publisher = {
        value
      }.asInstanceOf[Publisher]
      case pos if pos == 1 => this.extraInfo = {
        value
      }.asInstanceOf[PublisherExtraInfo]
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
  def getSchema: org.apache.avro.Schema = PublisherHeavy.SCHEMA$
}

object PublisherHeavy {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PublisherHeavy\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"publisher\",\"type\":{\"type\":\"record\",\"name\":\"Publisher\",\"fields\":[{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"publisherName\",\"type\":\"string\"}]}},{\"name\":\"extraInfo\",\"type\":{\"type\":\"record\",\"name\":\"PublisherExtraInfo\",\"fields\":[{\"name\":\"publisherCEOName\",\"type\":\"string\"},{\"name\":\"publisherCEODogName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetWifeName\",\"type\":\"string\"}]}},{\"name\":\"extraString1\",\"type\":\"string\"},{\"name\":\"extraString2\",\"type\":\"string\"}]}")
}