#!/bin/bash

HOST=10.68.104.246
USER=gpadmin

scp -r setup-demo-env.sh load-hbase.sh retail_demo pivotal-samples $USER@$HOST:~
#scp -r retail_demo $USER@$HOST:~
#scp -r pivotal_samples $USER@$HOST:~
