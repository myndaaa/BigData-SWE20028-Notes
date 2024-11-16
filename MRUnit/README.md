# 1.WordMapper.java
This class is responsible for the Map phase of the MapReduce 
program. It reads input lines and breaks them into words, outputting each 
word with the value 1 (indicating a single occurrence).
- Input: A line of text (from a file in Hadoop).
- Process: The map method splits the line into words and outputs a key-value pair for each word. For example, the line "cat cat dog" will produce (cat, 1), (cat, 1), and (dog, 1).
- Output: A list of key-value pairs for each word.

# 2.SumReducer.java
This class is responsible for the Reduce phase of the MapReduce program.
 It receives the words and their associated counts and then sums 
 up the counts for each word.

- Input: For each word, the reducer receives a list of IntWritable values, where each value represents a count for that word (e.g., two 1 values for the word "cat").
- Process: The reducer sums up the counts for each word (e.g., cat 1 1 becomes cat 2).
- Output: A key-value pair where the key is the word, and the value is the sum of its occurrences.

# 3.TestWordCount.java
This class contains unit tests for the WordMapper and SumReducer classes using MRUnit, 
which is a testing framework for MapReduce programs.

### MapDriver, ReduceDriver, MapReduceDriver
These are the test harnesses for testing the Map, Reduce, and MapReduce workflow respectively.
- MapDriver is used to test the mapper.
- ReduceDriver is used to test the reducer.
- MapReduceDriver is used to test the entire MapReduce process.

**Test Setup (@Before method)**:<br>
Purpose: This method initializes the test harnesses before each test is run. 
The WordMapper and SumReducer instances are passed to the respective drivers for testing.

**Test for Mapper (testMapper method):**<br>
Input: A single line "cat cat dog".
Expected Output: The mapper should output (cat, 1), (cat, 1), and (dog, 1).
Purpose: This test checks if the WordMapper produces the correct key-value pairs 
for the given input.

**Test for Reducer (testReducer method):**<br>
Input: A list of values [1, 1] for the key "cat".
Expected Output: The reducer should output "cat 2", as the count for "cat" is the sum of its occurrences.
Purpose: This test ensures the SumReducer correctly sums up the counts for each word.

**Test for MapReduce (testMapReduce method):** <br>
Input: The same input "cat cat dog".
Expected Output: The final output after both the mapper and reducer should be "cat 2" and "dog 1".
Purpose: This test checks the entire MapReduce flow, ensuring that the mapper and reducer work together to
 produce the correct output.
 
---

The three classes — **WordMapper, SumReducer, and TestWordCount** — are part of a 
simple Word Count program using Hadoop MapReduce. 
The mapper splits lines of text into words and emits them with a count of 1, 
while the reducer aggregates these counts. The unit tests ensure the correctness of 
the mapper, reducer, 
and the entire MapReduce job.