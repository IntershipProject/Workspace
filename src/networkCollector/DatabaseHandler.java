package networkCollector;

import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;


public class DatabaseHandler {

	private DB db;
	private MongoCollection dbCollection;
	private DBCollection coll;
	public DatabaseHandler() {
		MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("testDB");
            dbCollection=  db.getCollection("myCollection");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
	

	public void insertElement(String sourceIP, String destinationIP, String description, int sourcePort,
			int destinationPort) {
		Document dbObject = new Document();
		dbObject.put("Source IP", sourceIP);
		dbObject.put("Destination IP", destinationIP);
		dbObject.put("Description", description);
		dbObject.put("Source Port", sourcePort);
		dbObject.put("Destination Port", destinationPort);
		dbCollection.insertOne(dbObject);
		
	}
	public void findElement(String element){
		DBCursor cursor = coll.find();
        int i = 1;
			
        while (cursor.hasNext()) { 
        	System.out.println("++++++++++++++++++++++++++++++++++++++");
           System.out.println("Inserted Document: "+i); 
           System.out.println(cursor.next()); 
           System.out.println("++++++++++++++++++++++++++++++++++++++");
           i++;
        }
	}

}
