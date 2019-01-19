package sample;

import BackEnd.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import static com.mongodb.client.model.Projections.*;

public class Search {

    private ArrayList<String> titleDocsToShow;

    public ArrayList<String> copyTitles()
    {
        titleDocsToShow = new ArrayList<>();
        for (Score score : docScores) {
            titleDocsToShow.add(score.title_doc);
        }
        return titleDocsToShow;
    }

    public ArrayList<Score> getDocScores() {
        return docScores;
    }

    private ArrayList<Score> docScores;

    public  Search(String Requette) throws FileNotFoundException {

        TokenizationRequette tokenizationRequette = new TokenizationRequette(Requette);
        EliminationEWRequette ewRequette = new EliminationEWRequette(tokenizationRequette.TokenizeRequet);

        NormalizationRequette normalizationRequette = new NormalizationRequette(ewRequette.EmptyWordsEliminatedQ);

        Appariement appariement=new Appariement(normalizationRequette.rootedQuery);

        ArrayList<Integer> id_doc_app=new ArrayList<>(appariement.id_doc_term);


        docScores= new ArrayList<>();

        for (int i=0;i<id_doc_app.size();i++){

            docScores.add(new Score(id_doc_app.get(i), tokenizationRequette.TokenizeRequet));
        }

        Collections.sort(docScores);


        MongodbConnection mdbc = new MongodbConnection("DocumentsCollection");
        for (Score score : docScores)
        {
            FindIterable<org.bson.Document> fid =  mdbc.collection.find(Filters.eq("DocumentNumber",Integer.toString(score.id_doc))).projection(fields(include("DocumentTitle"), excludeId()));

            for (org.bson.Document d : fid)
                score.title_doc =(String) d.get("DocumentTitle");
        }

        mdbc.mongoClient.close();
    }


}
