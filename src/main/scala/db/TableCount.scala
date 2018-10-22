package db

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

class TableCount {
  val conf = new SparkConf().setAppName("DB connect").setMaster("local");
  // Create a Scala Spark Context.
  val javaSparkContext = new JavaSparkContext(conf);
  val sqlContext = new SQLContext(javaSparkContext);

  var tableName: String = _

  def setTable(name: String) = {
    tableName = name;
  }

  def count(): Long = {
    val df = sqlContext.read.format("jdbc").options(Map(
      "url" -> "jdbc:mysql://localhost:3306/test",
      "driver" -> "com.mysql.cj.jdbc.Driver",
      "dbtable" -> tableName, // "user"
      "user" -> "test",
      "password" -> "test")).load()

    df.show()
    df.createOrReplaceTempView("temptable")

    val dbinfo = sqlContext.sql("SELECT * FROM temptable")
    println("DB columns are ")
    dbinfo.show()
    dbinfo.count()
  }
}
