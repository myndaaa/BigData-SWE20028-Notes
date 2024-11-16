** 1. What is ToolRunner? **
- ToolRunner is a utility in Hadoop that simplifies the process of running MapReduce jobs by managing the command-line arguments, configuration, and job execution for you.
- It acts as a wrapper around the MapReduce driver (the main program that launches the job), so instead of manually setting up and executing a Hadoop job, we can use ToolRunner to handle the execution flow more easily.

** 2. What is a Driver? **
- The driver is the main program that sets up and runs the MapReduce job. It’s where we define things like the input files, output directories, and the MapReduce job configuration (like Mapper and Reducer).
- More simply, driver is the "controller" that directs the flow of the job, from reading the data to processing it and finally saving the results.


The ToolRunner in Hadoop MapReduce job is a utility class that 
simplifies the execution of Hadoop jobs by providing a mechanism for
 running Hadoop tools (like MapReduce jobs) in a consistent way.
 Here's a brief overview of what happened in AvgWordLength project,
 with a focus on the role of ToolRunner:<br>
**What the ToolRunner Did**<br>

1. Job Configuration:

   - ToolRunner.run(conf, new AvgWordLength(), args) initializes the AvgWordLength class, which contains the logic for your MapReduce job. It passes the configuration (conf) and the command-line arguments (args) into the AvgWordLength class.

2. Job Execution:

   - ToolRunner takes care of setting up the environment to run the job, parsing the arguments, and invoking the run() method of the AvgWordLength class.
   - The job processes data from HDFS (in your case, the Shakespeare text files) and calculates the average word length across all the input text.
3. Validation of Arguments:

   - The run() method in the AvgWordLength class validates the number of command-line arguments passed to the program (it requires two arguments: input directory and output directory).
4. Job Configuration Setup:

   - Inside the run() method, the job is configured, such as specifying the input and output paths, setting the mapper and reducer classes, and defining the output formats.
5. Mapper and Reducer Execution:

   - The Mapper (LetterMapper) processes input data (Shakespeare text) by breaking it into words and calculating their lengths.
   - The Reducer (AverageReducer) aggregates the word lengths and computes the average word length across all the records.
6. Completion and Exit:
   - Once the job finishes, ToolRunner handles the final result and returns the appropriate exit code (0 for success, 1 for failure).