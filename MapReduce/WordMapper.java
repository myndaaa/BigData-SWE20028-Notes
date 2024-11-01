package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/* 
 * This class defines the map function for the MapReduce job.
 * It processes input key-value pairs and produces output key-value pairs.
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  /*
   * The map method is called for each line in the input file.
   * It takes a key of type LongWritable (the line number) and a value of type Text (the line itself).
   */
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    // I convert the Text object representing the line into a String.
    String line = value.toString();

    // I split the line into words using a regular expression that matches non-word characters.
    for (String word : line.split("\\W+")) {
      if (word.length() > 0) { // Check if the word is not empty.
        // I emit the word as the key and the integer 1 as the value for counting.
        context.write(new Text(word), new IntWritable(1));
      }
    }
  }
}
