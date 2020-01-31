package spark

import org.apache.spark.sql.SparkSession

object spark_streaming_kafka {

  def main(args: Array[String]): Unit = {
     val spark=SparkSession.builder().master("local[*]").appName("spark-streaming").getOrCreate()
     val df=spark.readStream
       .format("kafka")
       .option("kafka.bootstrap.servers","localhost:9092")
       .option("subscribe","work")
       .option("startingOffsets","earliest")
       .load()

    df.printSchema()
  }

}
