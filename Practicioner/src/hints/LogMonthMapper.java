package hints;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Example input line:
 * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
 *
 */
public class LogMonthMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    /*
     * TODO: Parse the input line
     *
     *   1. Split the input line into space-delimited fields.  The first
     *   field will be the IP address (e.g. 96.7.4.14), and the fourth will 
     *   be the date/time (e.g. 24/Apr/2011:04:20:11)
     *
     *   2. Split the date value into "/" delimited fields.  The second 
     *   field will be the month (e.g. Apr)
     */

      /*
       * TODO: Emit the the IP address as the key
       * and the month as the value.
       */

    }
}