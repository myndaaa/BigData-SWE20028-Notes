DROP TABLE IF EXISTS employees;

CREATE EXTERNAL TABLE employees 
   (emp_id STRING, 
    fname STRING,
    lname STRING,
    address STRING,
    city STRING,
    state STRING,
    zipcode STRING,
    job_title STRING,
    email STRING,
    active STRING,
    salary INT)
   ROW FORMAT DELIMITED 
      FIELDS TERMINATED BY '\t'
      LOCATION '/dualcore/employees';
