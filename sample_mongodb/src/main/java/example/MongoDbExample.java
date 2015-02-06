package example;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.net.UnknownHostException;
import java.util.Set;

public class MongoDbExample {

	public static void main(final String[] args) throws UnknownHostException {
		final DB db = Mongo.connect(new DBAddress("localhost"));
		final Set<String> collectionNames = db.getCollectionNames();
		collectionNames.forEach(System.err::println);
		final DBCollection collection = db.getCollection("test");
		System.err.println("count: " + collection.count());
		final BasicDBObject doc = new BasicDBObject("name", "MongoDB").
			append("type", "database").
			append("count", 1).
			append("info", new BasicDBObject("x", 203).append("y", 102));
		collection.insert(doc);
		System.err.println("count: " + collection.count());
	}
}
