package spark

import org.apache.spark.sql.SparkSession

object Spark02 {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().appName("spark-app").master("local[*]").getOrCreate()
    val data =  Array(12,13,56,45)
    val r1= spark.sparkContext.parallelize(data,2)
    val rtrans= r1.map(x=>x*10)
    rtrans.collect().mkString("")


  }
}
