package BackEnd;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;

import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class BDD_Find {

    ArrayList<Integer> id_doc_pert;


    public BDD_Find(String term){

        Conexion_BDD conx=new Conexion_BDD();

        FindIterable<Document> docs= conx.collection.find(Filters.eq("term",term)).projection(fields(include("term","posting.id_doc", "posting.Poid"), excludeId()));

        id_doc_pert =new ArrayList<>();
        for (Document doc : docs) {
            ArrayList<Document> doc_post = (ArrayList<Document>) doc.get("posting");

            for (int i=0;i<doc_post.size();i++)
                id_doc_pert .add ((int) doc_post.get(i).get("id_doc"));
        }

        conx.mongoClient.close();
    }

}



