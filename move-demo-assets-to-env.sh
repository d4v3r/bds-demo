#!/bin/bash

HOST=10.68.104.246
USER=gpadmin

echo downloading retail_demo dataset
curl -O http://bds-demo.s3-website-us-east-1.amazonaws.com/retail_demo.zip > /dev/null

echo downloading spring xd
curl -O http://bds-demo.s3-website-us-east-1.amazonaws.com/spring-xd-1.0.2.RELEASE.zip > /dev/null

#scp -r retail_demo.zip spring-xd-1.0.2.RELEASE.zip setup-demo-env.sh hbase_path load-hbase.sh retail_demo pivotal-samples $USER@$HOST:~
