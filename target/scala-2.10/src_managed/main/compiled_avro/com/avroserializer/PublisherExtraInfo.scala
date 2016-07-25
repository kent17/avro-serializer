/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class PublisherExtraInfo(var publisherCEOName: String, var publisherCEODogName: String, var publisherCEODogVetName: String, var publisherCEODogVetWifeName: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this("", "", "", "")
  def get(field: Int): AnyRef = {
    field match {
      case pos if pos == 0 => {
        publisherCEOName
      }.asInstanceOf[AnyRef]
      case pos if pos == 1 => {
        publisherCEODogName
      }.asInstanceOf[AnyRef]
      case pos if pos == 2 => {
        publisherCEODogVetName
      }.asInstanceOf[AnyRef]
      case pos if pos == 3 => {
        publisherCEODogVetWifeName
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field: Int, value: Any): Unit = {
    field match {
      case pos if pos == 0 => this.publisherCEOName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 1 => this.publisherCEODogName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 2 => this.publisherCEODogVetName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case pos if pos == 3 => this.publisherCEODogVetWifeName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = PublisherExtraInfo.SCHEMA$
}

object PublisherExtraInfo {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PublisherExtraInfo\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"publisherCEOName\",\"type\":\"string\"},{\"name\":\"publisherCEODogName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetName\",\"type\":\"string\"},{\"name\":\"publisherCEODogVetWifeName\",\"type\":\"string\"}]}")
}