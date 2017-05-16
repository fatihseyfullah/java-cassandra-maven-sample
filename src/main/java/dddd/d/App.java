package dddd.d;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! This is Simple Java - Cassandra Sample" );
        Cluster cluster = Cluster.builder().addContactPoint("192.168.221.138").build();
    	Session session = cluster.connect("test");
    	System.out.println("connected to Cassandra 192.168.221.138");
    	
    	ResultSet results = session.execute("SELECT * FROM user");
    	for (Row row : results) {
    		String f1 = row.getString("user_id"); 
    		int f2 = row.getInt("age"); 
    		String f3 = row.getString("first"); 
    		String f4 = row.getString("last"); 
    		System.err.println(row.toString());
    		System.err.println(row.getColumnDefinitions().toString());
    		System.out.println("row f1:" + f1 + ", f2:" + f2 + ", f3:'" + f3 + "', f4:'" + f4 + "'");
    	}
    	
    	
            }
    
    
}
