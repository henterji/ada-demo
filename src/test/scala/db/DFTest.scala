package db

import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SQLContext;

object DFTest {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setAppName("DB connect").setMaster("local");
    // Create a Scala Spark Context.
    val javaSparkContext = new JavaSparkContext(conf);
    val sqlContext = new SQLContext(javaSparkContext);

    val df = sqlContext.read.format("jdbc").options(Map(
      "url" -> "jdbc:mysql://localhost:3306/test",
      "driver" -> "com.mysql.cj.jdbc.Driver",
      "dbtable" -> "user",
      "user" -> "test",
      "password" -> "test")).load()

    df.show();
    df.createOrReplaceTempView("temptable")

    val dbinfo = sqlContext.sql("SELECT ID, NAME, AGE FROM temptable");
    println("DB columns are ");
    dbinfo.show();
  }
}
