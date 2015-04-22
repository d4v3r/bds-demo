zcat retail_demo/customers_dim/customers_dim.tsv.gz | psql -c "COPY retail_demo.customers_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/categories_dim/categories_dim.tsv.gz | psql -c "COPY retail_demo.categories_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/order_lineitems/order_lineitems.tsv.gz | psql -c "COPY retail_demo.order_lineitems_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/orders/orders.tsv.gz | psql -c "COPY retail_demo.orders_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/customer_addresses_dim/customer_addresses_dim.tsv.gz | psql -c "COPY retail_demo.customer_addresses_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/email_addresses_dim/email_addresses_dim.tsv.gz | psql -c "COPY retail_demo.email_addresses_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/products_dim/products_dim.tsv.gz | psql -c "COPY retail_demo.products_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/payment_methods/payment_methods.tsv.gz | psql -c "COPY retail_demo.payment_methods_hawq FROM STDIN DELIMITER E'\t' NULL E'';"

zcat retail_demo/date_dim/date_dim.tsv.gz | psql -c "COPY retail_demo.date_dim_hawq FROM STDIN DELIMITER E'\t' NULL E'';"
