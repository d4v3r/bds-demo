##!/bin/bash

NAMENODE=is1-245.fe.gopivotal.com
echo Setting up demo environment

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

# HBASE import not working now
#echo create external hbase tables
#cat pivotal-samples/hawq/pxf_hbase_tables/create_pxf_hbase_tables.sql | sed s/pivhdsne/$NAMENODE/ | psql
