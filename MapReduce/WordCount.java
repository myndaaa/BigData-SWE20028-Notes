package stubs;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

/* 
 * This class serves as the driver for the MapReduce job.
 * It sets up the configuration for the Word Count job, including input
 * and output formats, and specifies the mapper and reducer classes.
 */
public class WordCount {

  public static void main(String[] args) throws Exception {

    // Check if the correct number of command-line arguments are provided.
    if (args.length != 2) {
      System.out.printf("Usage: WordCount <input dir> <output dir>\n");
      System.exit(-1);
    }

    // I create a Job object to configure the job settings.
    Job job = new Job();

    // I specify the JAR file that contains the driver, mapper, and reducer classes.
    job.setJarByClass(WordCount.class);
    
    // I give the job a meaningful name that will appear in logs and reports.
    job.setJobName("Word Count");

    // I set the input and output paths for the job using the command-line arguments.
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    // I specify which classes will handle the mapping and reducing tasks.
    job.setMapperClass(WordMapper.class);
    job.setReducerClass(SumReducer.class);

    // I define the output key and value types for the job.
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    // I start the job and wait for it to complete. The method returns true if successful.
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1); // Exit with a success or failure code.
  }
}
