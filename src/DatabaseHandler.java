
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;

import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;


public class DatabaseHandler {

	private DB db;
	private DBCollection dbCollection;

	public DatabaseHandler() {
		MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("census");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
	

	public void insertElement(String sourceIP, String destinationIP, String description, int sourcePort,
			int destinationPort) {
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("Source IP", sourceIP);
		dbObject.put("Destination IP", destinationIP);
		dbObject.put("Description", description);
		dbObject.put("Source Port", sourcePort);
		dbObject.put("Destination Port", destinationPort);
		dbCollection.insert(dbObject);
		
	}
	public void findElement(String element){
		dbCollection.getCollection(element);
	}

}
