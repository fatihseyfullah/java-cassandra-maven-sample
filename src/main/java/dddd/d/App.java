package dddd.d;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! This is Simple Java - Cassandra Sample" );
        Cluster cluster = Cluster.builder().addContactPoint("192.168.221.138").build();
    	Session session = cluster.connect("test");
    	System.out.println("connected to Cassandra 192.168.221.138");
    	
    	System.out.println("Save user fsk");
    	
    	PreparedStatement preparedStatement = session.prepare("insert into user (user_id,age,first,last) values (?,?,?,?)");
		
		BoundStatement boundStatement = preparedStatement.bind("fsk",30,"Fatih","Seyfullah");
		session.execute(boundStatement);
		
		System.out.println("Save user xyz");
		session.execute(preparedStatement.bind("xyz",22,"Ali","Öztürk"));
    	
		System.err.println("Getting all users");
    	ResultSet results = session.execute("SELECT * FROM user");
    	for (Row row : results) {
    		String f1 = row.getString("user_id"); 
    		int f2 = row.getInt("age"); 
    		String f3 = row.getString("first"); 
    		String f4 = row.getString("last"); 
    		System.err.println("print row. Expected result for first row= Row[fsk, 30, Fatih, Seyfullah] \n"+row.toString());
    		System.err.println("print columnDefinitons. Expexted result = Columns[user_id(varchar), age(ınt), first(varchar), last(varchar)]\n"+row.getColumnDefinitions().toString());
    		System.out.println("row f1:" + f1 + ", f2:" + f2 + ", f3:'" + f3 + "', f4:'" + f4 + "'");
    		
    		
    	}
    	
    	
            }
    
    
}
