package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Handler implements RequestHandler<Map<String,String>, Void>{

    private final MongoClient mongoClient;

    public Handler() {
        mongoClient = MongoClients.create(System.getenv("MONGODB_ATLAS_URI"));
    }

    @Override
    public Void handleRequest(Map<String,String> event, Context context) {
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection collection = database.getCollection("movies");

        Bson filter = new BsonDocument();

        List<Document> results =new ArrayList<Document>();

        collection.find(filter).limit(5).into(results);
        // More logic here ...

        return null;
    }
}