package example;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoDbExample {

    public static void main(String[] args) throws UnknownHostException {
        DB db = Mongo.connect(new DBAddress("localhost"));
        final Set<String> collectionNames = db.getCollectionNames();
        for (String c : collectionNames) {
            System.err.println(c);
        }
        final DBCollection collection = db.getCollection("test");
        System.err.println("count: " + collection.count());
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));
        collection.insert(doc);
        System.err.println("count: " + collection.count());
    }
}
