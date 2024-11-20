# Sequence

creating two MapReduce applications: one to convert text data to an uncompressed 
and then compressed SequenceFile, and another to read the compressed SequenceFile and
 output it back to a readable text file. 
 
1. Step 1: Check HDFS Block Count of the Access Log File
 Go to the Name Node Web UI in browser at `http://localhost:50070` .<br>
 Select Browse the filesystem.”<br>Find the file `/user/training/weblog/access_log` <br>
 
 
In HDFS, a file is split into blocks to enable distributed storage and processing.
 Each block represents a chunk of data that is stored across the cluster nodes. 
By default, the HDFS block size is often set to 128 MB, but this can vary based on the configuration.<br>


## Verify and Compare Outputs
### After running the jobs, use these commands to examine the file contents and compare sizes:
```
hadoop fs -ls uncompressedsf
hadoop fs -ls compressedsf
hadoop fs -ls compressedsftotext

```
### View content of files 
```
hadoop fs -cat uncompressedsf/part-m-00000
hadoop fs -cat compressedsf/part-m-00000
hadoop fs -cat compressedsftotext/part-m-00000

```
### using cli to do it

```
$ hadoop jar sequence.jar \
stubs.CreateUncompressedSequenceFile \
-Dmapred.output.compressed=true \
weblog outdir
```