package hints;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/* Counts the number of values associated with a key */

public class CountReducer extends Reducer<Text, Text, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    
	  /*
	   * TODO: implement
	   * Iterate over the values iterable and count the number of values in it.  
	   * Emit the key (unchanged) and an IntWritable containing the number of values.
	   */
  }
}
