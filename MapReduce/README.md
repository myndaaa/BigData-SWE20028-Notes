# Map Reduce
hadoop is used to
launch MapReduce jobs. The code for a job is contained in a compiled JAR file.
Hadoop loads the JAR into HDFS and distributes it to the worker nodes, where the
individual tasks of the MapReduce job are executed<br>

*One simple example of a MapReduce job is to count the number of occurrences of each word in a file or set of files.*

<br>
Inside the **Wordcount directory** we have:
 - Wordcount.java
 - WordMapper.java
 - SumReducer.java
 
# Running java

```
$ hadoop classpath
```

Running hadoop classpath displays the classpath locations that Hadoop is configured to use. <br>
This classpath includes paths to Hadoop core libraries and dependencies that Java programs need 
to interact with Hadoop.<br>
Purpose: You need this classpath when compiling Java classes, so they can access the Hadoop API for running MapReduce tasks.
<br>
```
$ javac -classpath `hadoop classpath` stubs/*.java

```
javac: This is the Java compiler used to compile .java files into .class files.<br>
**-classpath \hadoop classpath`**: The **backticks** (`` ``) around 
hadoop classpath mean that the hadoop classpath command will execute first, 
and its output (the actual classpath) will be inserted into the javac command as the classpath argument.<br>
stubs/*.java: This specifies all .java files in the stubs directory. Each Java file will be compiled using the specified classpath.<br>

```
$ jar cvf wc.jar stubs/*.class

```
jar: This is the Java Archive Tool, used to create, view, and manage .jar files.<br>
cvf:<br>
c: Create a new archive.<br>
v: Verbose mode, which lists the files being added to the archive.<br>
f wc.jar: Specifies the name of the archive file, here wc.jar.<br>
stubs/*.class: Specifies all .class files in the stubs directory to include in the JAR file.<br>
Purpose: This command packages the compiled Java classes into a JAR file named wc.jar, which Hadoop can use to run the MapReduce job.
<br>
```
$ hadoop jar wc.jar stubs.WordCount shakespeare wordcounts

```
hadoop jar: This command runs a JAR file on Hadoop.<br>
wc.jar: The JAR file that contains the compiled classes for the job.<br>
stubs.WordCount: Specifies the class within the JAR whose main method will be invoked to start the job. In this case, WordCount in the stubs package.<br>
shakespeare: The HDFS directory containing the input data (the works of Shakespeare).<br>
wordcounts: The HDFS output directory where the MapReduce job’s results (word counts) will be stored.<br>
Purpose: This command submits the job to Hadoop to count the occurrences of each word in the shakespeare directory files. The results will be saved in the wordcounts directory in HDFS.<br>

```
hadoop jar wc.jar stubs.WordCount shakespeare wordcounts

```
hadoop jar: This is the Hadoop command to run a JAR file on the cluster.<br>
wc.jar: This is the JAR file containing the compiled MapReduce classes you created earlier.<br>
stubs.WordCount: This specifies the main class that will be executed within the JAR. Here, stubs.WordCount represents the full package and class name (the WordCount class inside the stubs package).<br>
shakespeare: This is the HDFS input directory, containing the files or dataset (like the Shakespeare text files) on which you want to run the MapReduce job.<br>
wordcounts: This is the HDFS output directory where the job results will be saved. The job will count the occurrences of each word in the input files and store the output in this directory.<br>


## Reviewing results
 - `hadoop fs -ls wordcounts`
 - This lists the output files for the job. (it ran with only one Reducer, so there should be one file, named part-r-00000, along with a _SUCCESS file and a _logs directory.
 - `hadoop fs -cat wordcounts/part-r-00000 | less`
 
 
#### to check on going jobs
```
 hadoop job -list

```
*this is deprecated*
instead use:
```
mapred job -list
```
#### to kill a job

```
hadoop job -kill <job_id>
```