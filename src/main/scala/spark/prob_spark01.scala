package spark

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions._

object prob_spark01 extends App {

  val spark=SparkSession.builder().master("local[*]").appName("spark-problems").getOrCreate()
  val data=Seq(Row(1,"Gopi"),Row(2,"chaithanya"),Row(3,"ravi"))
  val schema=StructType(List(StructField("Id",IntegerType,true),
    StructField("name",StringType,true)))
  val df=spark.createDataFrame(spark.sparkContext.parallelize(data),schema)
   df.printSchema()
  val newDf=df.select(df.columns.map(c => col(c).cast(StringType)):_*)
  newDf.printSchema()
  newDf.show()

}
