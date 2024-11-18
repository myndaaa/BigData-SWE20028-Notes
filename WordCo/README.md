This lab involves creating a Word Co-occurrence application using Hadoop MapReduce, where the task is to count how often two 
consecutive words appear together in a text.

1. SumReducer (Reducer)<br>
The SumReducer aggregates the counts for each word pair:<br>

	- Input: Each key will be a word pair (e.g., "word1,word2"), and the associated value is the count for that pair.
	- Processing: The reducer iterates over the values for a given word pair, summing them up.
	- Output: The final output will be a word pair and its total count of occurrences.
	

2. WordCoMapper (Mapper)<br>
The WordCoMapper processes the input lines of text:<br>

	- Input: The key is the offset of the line, and the value is the line of text.
	- Processing:
		- Converts the line to lowercase.
		- Splits the line into words using a regular expression (split("\\W+")).
		- For each pair of consecutive words, the mapper emits a key-value pair where the key is the word pair in the form of "word1,word2", and the value is 1.
	- Output: Each consecutive word pair and a count of 1 is emitted.
	

3. WordCo (Driver Class)<br>
The WordCo class sets up and runs the MapReduce job:<br>

	- Job Configuration:
		- Specifies input and output directories from the command line.
		- Sets the WordCoMapper and SumReducer as the mapper and reducer classes.
		- Specifies the output key and value classes (Text for word pairs, IntWritable for counts).
	- Execution: The job is executed with ToolRunner.run(), which sets up the job configuration and handles the command-line arguments.