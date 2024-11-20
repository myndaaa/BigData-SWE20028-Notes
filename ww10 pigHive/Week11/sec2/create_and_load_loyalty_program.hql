CREATE TABLE loyalty_program
   (cust_id INT,
    fname STRING,
    lname STRING,
    email STRING,
    level STRING,
    phone MAP<STRING, STRING>,
    order_ids ARRAY<INT>,
    order_value STRUCT<min:INT, 
                       max:INT, 
                       avg:INT, 
                       total:INT>)       
   ROW FORMAT DELIMITED 
      FIELDS TERMINATED BY '|'
      COLLECTION ITEMS TERMINATED BY ',' 
      MAP KEYS TERMINATED BY ':';

-- load it with data from a local file
LOAD DATA LOCAL INPATH 'loyalty_data.txt' INTO TABLE loyalty_program
