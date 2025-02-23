import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBConnection {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "LibraryDB";

    public static MongoDatabase connect() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
