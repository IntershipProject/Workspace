
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;


public class MongoReader {
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;
	private static MongoClient mongoClient;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mongoClient = new MongoClient("localhost", 27017);
		database = mongoClient.getDatabase("testDB");
		collection = database.getCollection("myCollection");
		System.out.println(collection.find().first().toJson());
		System.exit(0);
		for (Document cur : collection.find()) {
		    System.out.println(cur.toJson());
		}

	}
	private static void createDoc(Document doc) {
		// TODO Auto-generated method stub
		doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

	}

}

