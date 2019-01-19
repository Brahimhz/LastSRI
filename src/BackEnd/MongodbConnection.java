package BackEnd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongodbConnection {
    public MongoClientURI connectionString;
    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection<Document> collection;

    public MongodbConnection(String collectionName)
    {
        connectionString = new MongoClientURI("mongodb://localhost:27017");
        mongoClient = new MongoClient(connectionString);

        database = mongoClient.getDatabase("search_engine");
        collection = database.getCollection(collectionName);

        //collection.drop();

    }
}
