package com.pomtest

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object main1{

  val spark:SparkSession = SparkSession.builder().master("local[1]").appName("spring_read").getOrCreate()


  def readFile(){
    val df:DataFrame = spark.read.text("src/main/resources/data.txt")
//    df.printSchema()
//    df.show()

    df.foreach(row => println(row))
    df.write.mode(SaveMode.Overwrite).text("src/main/resources/data1.txt")
  }

}

object Main{
  def main(args: Array[String]): Unit = {
    main1.readFile()

  }
}
