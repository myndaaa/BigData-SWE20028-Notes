package solution;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

public class YearPartitioner<K2, V2> extends Partitioner<Text, IntWritable> implements
    Configurable {

  private Configuration configuration;
  HashMap<String, Integer> years = new HashMap<String, Integer>();
  private String[] YearList = {"2009", "2010", "2011"};
  private String tg;
  private boolean found;
  private int tgv;
  
  

  /**
   * Set up the months hash map in the setConf method.
   */
  @Override
  public void setConf(Configuration configuration) {
    this.configuration = configuration;

    for (int y=0; y < YearList.length; y++){
    	years.put(YearList[y], y);
    }
  }

  /**
   * Implement the getConf method for the Configurable interface.
   */
  @Override
  public Configuration getConf() {
    return configuration;
  }

  /**
   * You must implement the getPartition method for a partitioner class.
   * This method receives the three-letter abbreviation for the month
   * as its value. (It is the output value from the mapper.)
   * It should return an integer representation of the month.
   * Note that January is represented as 0 rather than 1.
   * 
   * For this partitioner to work, the job configuration must have been
   * set so that there are exactly 12 reducers.
   */
  public int getPartition(Text key, IntWritable value, int numReduceTasks) {
    tg = key.toString();
    found = false;
    for (int y=0; y < YearList.length; y++){
    	if(tg.equals(YearList[y])){
    		found = true;
    		tgv = y;
    		break;
    		
    	}
    }
	  
	if (found) {
		return tgv;
	}
	else{
		return 0;
	
	}
	  
	  
	  
  }
}
