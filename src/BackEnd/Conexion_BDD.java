package BackEnd;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Conexion_BDD {
    MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
    MongoClient mongoClient = new MongoClient(connectionString);

    MongoDatabase database = mongoClient.getDatabase("search_engine");
    MongoCollection<Document> collection = database.getCollection("DOCS");

}
