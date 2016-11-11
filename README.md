# SparkSQLHiveContextExample

This is a minimal example of Spark SQL using HiveContext - tested against MapR 5, with Hive 1.2.

This example creates a JavaSparkContext, then creates a HiveContext, then executes some queries to insert data into a new hive table.

# Building

```
mvn package
```
  
# Running

Assuming you're running Spark Standalone (modify `--master spark://<hostname>:<port>` for your environment):

```
/opt/mapr/spark/spark-1.5.2/bin/spark-submit \
    --class com.mapr.examples.SparkSQLHiveContextExample \
    target/SparkSQLExample-1.0-SNAPSHOT.jar \
    --master spark://my.cluster.com:7077
```
