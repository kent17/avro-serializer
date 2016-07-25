/** MACHINE-GENERATED FROM AVRO SCHEMA. DO NOT EDIT DIRECTLY */
package com.avroserializer

case class Publisher(var publisherId: Int, var publisherName: String) extends org.apache.avro.specific.SpecificRecordBase {
  def this() = this(1, "")
  def get(field: Int): AnyRef = {
    field match {
      case pos if pos == 0 => {
        publisherId
      }.asInstanceOf[AnyRef]
      case pos if pos == 1 => {
        publisherName
      }.asInstanceOf[AnyRef]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
  }
  def put(field: Int, value: Any): Unit = {
    field match {
      case pos if pos == 0 => this.publisherId = {
        value
      }.asInstanceOf[Int]
      case pos if pos == 1 => this.publisherName = {
        value match {
          case (value: org.apache.avro.util.Utf8) => value.toString
          case _ => value
        }
      }.asInstanceOf[String]
      case _ => new org.apache.avro.AvroRuntimeException("Bad index")
    }
    ()
  }
  def getSchema: org.apache.avro.Schema = Publisher.SCHEMA$
}

object Publisher {
  val SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Publisher\",\"namespace\":\"com.avroserializer\",\"fields\":[{\"name\":\"publisherId\",\"type\":\"int\"},{\"name\":\"publisherName\",\"type\":\"string\"}]}")
}