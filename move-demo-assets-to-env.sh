#!/bin/bash

HOST=10.68.104.246
USER=gpadmin


if [ ! -f retail_demo.zip ]; then
  echo retail_demo.zip file does not exist
  echo downloading retail_demo.zip dataset
  curl -O http://bds-demo.s3-website-us-east-1.amazonaws.com/retail_demo.zip > /dev/null
else
  echo retail_demo.zip already downloaded
fi

if [ ! -f spring-xd-1.0.2.RELEASE.zip ]; then
  echo spring-xd-1.0.2.RELEASE.zip file does not exist
  echo downloading spring-xd-1.0.2.RELEASE.zip
  curl -O http://bds-demo.s3-website-us-east-1.amazonaws.com/spring-xd-1.0.2.RELEASE.zip > /dev/null
else
  echo spring-xd-1.0.2.RELEASE.zip already downloaded
fi

scp -r retail_demo.zip spring-xd-1.0.2.RELEASE.zip setup-demo-env.sh hbase_path load-hbase.sh retail_demo pivotal-samples $USER@$HOST:~
