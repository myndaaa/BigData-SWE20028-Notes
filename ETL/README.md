# The ETL process

Launch the VM
```
~/scripts/analyst/toggle_services.sh
```

these two commands show the same thing as, when no directory is mentioned hadoop 
assumes its the home directory
```
cd $ADIR/exercises/data_ingest
hadoop fs -ls /user/training
hadoop fs -ls
```

creating dualcore directory
```
hadoop fs -mkdir /dualcore
```
Dualcore stores information about its employees, customers, products, and orders
in a MySQL database.

<br>
logging into mysql and observing

```

[training@localhost data_ingest]$ mysql --user=training --password=training dualcore
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 10
Server version: 5.1.61 Source distribution

Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> SHOW TABLES
    -> ;
+--------------------+
| Tables_in_dualcore |
+--------------------+
| customers          |
| employees          |
| order_details      |
| orders             |
| products           |
| suppliers          |
+--------------------+
6 rows in set (0.00 sec)

mysql> 

```

Review Structures

```

mysql> DESCRIBE employees;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| emp_id    | char(9)     | NO   | PRI | NULL    |       |
| fname     | varchar(15) | YES  |     | NULL    |       |
| lname     | varchar(20) | YES  |     | NULL    |       |
| address   | varchar(40) | YES  |     | NULL    |       |
| city      | varchar(30) | YES  |     | NULL    |       |
| state     | char(2)     | YES  |     | NULL    |       |
| zipcode   | char(5)     | YES  |     | NULL    |       |
| job_title | varchar(35) | YES  |     | NULL    |       |
| email     | varchar(25) | YES  |     | NULL    |       |
| active    | char(1)     | NO   |     | Y       |       |
| salary    | int(11)     | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
11 rows in set (0.00 sec)

mysql> Select emp_id, fname, lname, state, salary FROM employees LIMIT 10;
+-----------+---------+-----------+-------+--------+
| emp_id    | fname   | lname     | state | salary |
+-----------+---------+-----------+-------+--------+
| AA1130960 | Amy     | Alicea    | KY    |  22329 |
| AA1146303 | Anna    | Atkins    | CA    |  99645 |
| AA1154964 | Annie   | Albritton | WV    |  26717 |
| AA1352280 | Antoine | Aguirre   | AL    |  26078 |
| AA1411429 | Arthur  | Andersen  | MS    |  17486 |
| AA1418885 | Amanda  | Atkinson  | CA    |  22278 |
| AA1510726 | Ann     | Askew     | KY    |  17220 |
| AA1567042 | Anne    | Almonte   | CA    |  18566 |
| AA1609979 | Anthony | Allen     | PA    |  20575 |
| AA1636177 | Anthony | Aguilar   | CO    |  25262 |
+-----------+---------+-----------+-------+--------+
10 rows in set (0.01 sec)

mysql> quit
Bye
[training@localhost data_ingest]$ 

```

then we sqoop to import it to dualcore

```
sqoop import \
--connect jdbc:mysql://localhost/dualcore \
--username training --password training \
--fields-terminated-by '\t' \
--warehouse-dir /dualcore \
--table employees

```

repeat for other TABLES
```
sqoop import --connect jdbc:mysql://localhost/dualcore --username training --password training --fields-terminated-by '\t' --warehouse-dir /dualcore --table customers


sqoop import --connect jdbc:mysql://localhost/dualcore --username training --password training --fields-terminated-by '\t' --warehouse-dir /dualcore --table products


sqoop import --connect jdbc:mysql://localhost/dualcore --username training --password training --fields-terminated-by '\t' --warehouse-dir /dualcore --table orders

```

Next importing order_details
The command is
slightly different because this table only holds references to records in the
orders and products table, and lacks a primary key of its own. Consequently,
you will need to specify the --split-by option and instruct Sqoop to divide
the import work among map tasks based on values in the order_id field. An
alternative is to use the -m 1 option to force Sqoop to import all the data with a
single task, but this would significantly reduce performance.

```
sqoop import \
--connect jdbc:mysql://localhost/dualcore \
--username training --password training \
--fields-terminated-by '\t' \
--warehouse-dir /dualcore \
--table order_details \
--split-by=order_id
```

# Part 2 : Using pig for ETL 

**Working in the Grunt Shell**
```
# change directory
cd $ADIR/exercises/pig_etl


# extract sample data
head -n 25 $ADIR/data/ad_data1.txt > sample1.txt


# start grunt shell in local mode
pig -x local

```

**Loading and dumping data**
```
grunt> data = LOAD 'sample1.txt';  
grunt> DUMP data;

```

**Load First Two Columns as Character Data:**
```
grunt> first_2_columns = LOAD 'sample1.txt' AS (keyword:chararray, campaign_id:chararray);  
grunt> DUMP first_2_columns;

# describe schema
grunt> DESCRIBE first_2_columns;
grunt> DESCRIBE data;

# how to quit grunt shell

grunt> QUIT;

```