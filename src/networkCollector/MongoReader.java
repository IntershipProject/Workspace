package networkCollector;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Arrays;

public class MongoReader {
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;
	private static MongoClient mongoClient;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mongoClient = new MongoClient("localhost", 27017);
		database = mongoClient.getDatabase("testDB");
		collection = database.getCollection("myCollection");

		//
		System.out.println(collection.find().first().getString("Source IP"));

		//
		for (Document cur : collection.find()) {
			System.out.println(cur);
			System.exit(0);
		}

	}
}
