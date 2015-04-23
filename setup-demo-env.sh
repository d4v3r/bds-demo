##!/bin/bash

NAMENODE=is1-245.fe.gopivotal.com
echo Setting up demo environment



if [ ! -d "retail_demo" ]; then
  unzip retail_demo.zip
fi

if [ ! -d "spring-xd-1.0.2.RELEASE" ]; then
  unzip spring-xd-1.0.2.RELEASE.zip
fi

hadoop fs -rm -r -skipTrash /retail_demo
hadoop fs -put retail_demo /

echo checking for files in HDFS
hdfs fsck /retail_demo

echo creating HAWQ tables
psql -f pivotal-samples/hawq/hawq_tables/create_hawq_tables.sql

echo loading HAWQ tables
pivotal-samples/hawq/hawq_tables/load_hawq_tables.sh

echo verifying table counts
pivotal-samples/hawq/hawq_tables/verify_load_hawq_tables.sh

echo create external HDFS tables
cat  pivotal-samples/hawq/pxf_tables/create_pxf_tables.sql | sed s/pivhdsne/$NAMENODE/ | psql

echo drop existing hbase tables - ignore errors
pivotal-samples/hawq/pxf_hbase_tables/load-hbase.sh

echo load hbase tables
pivotal-samples/hawq/pxf_hbase_tables/create_hbase_tables.pl

echo create hbase tables
pivotal-samples/hawq/pxf_hbase_tables/create_hbase_tables.pl


echo create external hbase tables
cat pivotal-samples/hawq/pxf_hbase_tables/create_pxf_hbase_tables.sql | sed s/pivhdsne/$NAMENODE/ | psql
