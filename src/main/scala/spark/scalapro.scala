package spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object scalapro extends App{

  val spark=SparkSession.builder().appName("spp").master("local[*]").getOrCreate()
  import spark.implicits._
  val df= spark.sparkContext.parallelize(Seq(("Databrick",2000),("spark",4000),("hadoop",5000))).toDF("word","count")
  df.withColumn("uniqueID",monotonicallyIncreasingId).show()


}
