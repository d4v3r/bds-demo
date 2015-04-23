#!/bin/bash

source hbase_path

#need $HADOOP_OPTS for stack.name and stack.version
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv $HADOOP_OPTS -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,cf1:category_id,cf1:price,cf1:product_name products_dim /retail_demo/products_dim
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv $HADOOP_OPTS -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,cf1:email_address email_addresses_dim /retail_demo/email_addresses_dim
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv $HADOOP_OPTS -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,cf1:customer_id,cf1:valid_from_timestamp,cf1:valid_to_timestamp,cf1:house_number,cf1:street_name,cf1:appt_suite_no,cf1:city,cf1:state_code,cf1:zip_code,cf1:zip_plus_four,cf1:country,cf1:phone_number customer_addresses_dim /retail_demo/customer_addresses_dim
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv $HADOOP_OPTS -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,cf1:first_name,cf1:last_name,cf1:gender customers_dim /retail_demo/customers_dim
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv $HADOOP_OPTS -Dimporttsv.skip.bad.lines=false -Dimporttsv.columns=HBASE_ROW_KEY,cf1:customer_id,cf1:store_id,cf1:order_datetime,cf1:ship_completion_datetime,cf1:return_datetime,cf1:refund_datetime,cf1:payment_method_code,cf1:total_tax_amount,cf1:total_paid_amount,cf1:total_item_quantity,cf1:total_discount_amount,cf1:coupon_code,cf1:coupon_amount,cf1:order_canceled_flag,cf1:has_returned_items_flag,cf1:has_returned_items_flag,cf1:has_returned_items_flag,cf1:fraud_code,cf1:fraud_resolution_code,cf1:billing_address_line1,cf1:billing_address_line2,cf1:billing_address_city,cf1:billing_address_state,cf1:billing_address_postal_code,cf1:billing_address_country,cf1:billing_phone_number,cf1:customer_name,cf1:customer_email_address,cf1:ordering_session_id,cf1:website_url orders /retail_demo/orders/orders.tsv.gz
