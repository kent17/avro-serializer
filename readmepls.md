Il y a 2 fichiers build.sbt :
/build.sbt
/project/build.sbt => plugins

sbt
clean
avro:generate-specific
compile
package

/Users/quentin/Dev/spark-1.4.1-bin-hadoop2.6/bin/spark-submit --master local[*] --class "com.avroserializer.SparkAvroExample" target/scala-2.10/sparkavroserializer_2.10-1.0.jar


/Users/quentin/Dev/spark-1.4.1-bin-hadoop2.6/bin/spark-submit --master local[*] --class "com.avroserializer.SparkAvroExample" --driver-java-options "-XX:+PrintGCDetails -XX:+PrintGCTimeStamps" target/scala-2.10/sparkavroserializer_2.10-1.0.jar


/Users/quentin/Dev/spark-1.4.1-bin-hadoop2.6/bin/spark-submit \
  --class "com.avroserializer.SparkAvroExample" \
  --master spark://Quentins-MacBook-Pro.local:7077 \
  target/scala-2.10/sparkavroserializer_2.10-1.0.jar

/Users/quentin/Dev/spark-1.4.1-bin-hadoop2.6/sbin/start-all.sh
