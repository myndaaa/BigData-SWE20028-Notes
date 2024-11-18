# Use Sqoop to import data from a MySQL
The goal is to use Sqoop to import data from a MySQL database into Hadoop, specifically the tables movie and movierating from the movielens database. This data will be used for analysis in future labs.

1. Log into MySQL:
```
mysql --user=training --password=training movielens

```

2. Examine the structure of the movie table:
```
DESCRIBE movie;
SELECT * FROM movie LIMIT 5;

```
![](sql1.png)
3. Examine the structure of the movierating table:
```
DESCRIBE movierating;
SELECT * FROM movierating LIMIT 5;

```
![](sql2.png)

4. Exit by `quit`

## Sqoop commands

```
sqoop help
```
List of available databases
```
sqoop list-databases \
--connect jdbc:mysql://localhost \
--username training --password training
```
List tables in the movielens database:
```
sqoop list-tables \
--connect jdbc:mysql://localhost/movielens \
--username training --password training

```

Import Tables into Hadoop Using Sqoop
```
sqoop import \
--connect jdbc:mysql://localhost/movielens \
--username training --password training \
--fields-terminated-by '\t' --table movie

```

Verify the import worked:
```
hadoop fs -ls movie
hadoop fs -tail movie/part-m-00000

```

similarly importing `movierating`
```
sqoop import \
--connect jdbc:mysql://localhost/movielens \
--username training --password training \
--fields-terminated-by '\t' --table movierating


hadoop fs -ls movierating
hadoop fs -tail movierating/part-m-00000
```
