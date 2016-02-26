package com.mapr.examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;


public class SparkSQLHiveContextExample {
    public static void main(String[] args) throws Exception {
        SparkConf sparkConf = new SparkConf().setAppName("SparkSQLHiveContextExample");
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);

        HiveContext hiveContext = new org.apache.spark.sql.hive.HiveContext(ctx.sc());
        hiveContext.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)");
        hiveContext.sql("LOAD DATA LOCAL INPATH '/opt/mapr/hive/hive-1.2/examples/files/kv1.txt' INTO TABLE src");
        Row[] results = hiveContext.sql("FROM src SELECT key, value").collect();

        System.out.println(results.toString());
    }
}
