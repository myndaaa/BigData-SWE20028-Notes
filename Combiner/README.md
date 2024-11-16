# Enhancing the WordCount program by adding a Combiner.

**A Combiner** is a mini-reducer that runs on the Map side 
and helps reduce the amount of intermediate data transferred 
from the Mapper to the Reducer. The purpose is to optimize the data 
flow in MapReduce jobs, especially when the computation is associative and 
commutative, as is the case with word counting.

### WordMapper.java

This class is responsible for splitting input text into words and emitting a key-value 
pair for each word with a value of 1 (count of that word).

### SumReducer.java (same as previous labs)

 This is the Reducer class that processes the results of the Mapper 
 (the word-count pairs) and sums the values for each word.
 
 
 ## WordCountDriver.java
 This is the driver class that configures the job, sets the Mapper, Reducer, Combiner, 
 and input/output paths. It is responsible for running the job.
 
 ## Running this
 navigate 
 ```
 cd ~/workspace/wordcount/src
 ```
 compile to class
 ```
 javac -classpath `hadoop classpath` stubs/*.java
 ```
 create jar file
 ```
 jar cvf combiner.jar stubs/*.class
 ```
 run the job
 ```
 hadoop jar combiner.jar stubs.WordCountDriver shakespeare wordcounts
 ```
 
 ## Combiner: Purpose and Benefits
1. Combiner: A Combiner is a local, partial reducer that operates on the output of the Mapper. It reduces the volume of intermediate data sent from the Mapper to the Reducer by performing local aggregation.

 - The Combiner is often the same class as the Reducer (in this case, SumReducer), but it operates on the Mapper's output locally on each Mapper node before the data is shuffled to the Reducer.
 - Why use a Combiner?: When the operation is associative and commutative (like summing or counting), the order in which operations are performed does not matter. This makes it possible to combine intermediate results before they are sent to the Reducer, which reduces network I/O and speeds up the job.

2. Example of Efficiency: Without a Combiner:

 - Mappers emit the word count 1 for each word they find. These pairs are sent to the Reducer over the network, which will sum them.
 - With a Combiner: Each Mapper will first sum counts for words locally. For example, if a Mapper sees 3 occurrences of "hello", it will emit hello -> 3, reducing the amount of data sent to the Reducer.

3. Important Note: The use of a Combiner is optional. It is beneficial only for operations like counting or summing that are associative and commutative. Not all jobs can use a Combiner (e.g., for non-commutative operations like sorting, a Combiner wouldn't make sense).

## Difference from Previous Labs
 - In earlier labs, the process involved just a Mapper and a Reducer. The Mapper emitted key-value pairs, 
 and the Reducer aggregated those pairs by key.
 
 - The Combiner operates as a mini-reducer that runs on each Mapper node, reducing the amount of intermediate data that needs to be transferred to the Reducer. This can result in performance improvements for 
 large datasets because less data is shuffled across the network.
