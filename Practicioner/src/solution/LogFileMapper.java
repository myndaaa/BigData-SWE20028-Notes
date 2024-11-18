package solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogFileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public static List<String> months = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");

  /**
   * Example input line:
   * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
   *
   */
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String line = value.toString();
	  String[] data = line.trim().split("\\[\\d{2}/\\w{3}/");
	  if (data.length > 0){
		  String part_data = data[1];
		  String year = part_data.substring(0,4);
		  context.write(new Text(year), new IntWritable(1));
	  }
	  
	  
	  
	  
	  
	  
  }
}
