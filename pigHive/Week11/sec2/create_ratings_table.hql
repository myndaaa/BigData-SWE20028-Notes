DROP TABLE IF EXISTS ratings;

CREATE TABLE ratings 
   (posted TIMESTAMP, 
    cust_id INT,
    prod_id INT,
    rating TINYINT,
    message STRING)       
   ROW FORMAT DELIMITED 
      FIELDS TERMINATED BY '\t';
