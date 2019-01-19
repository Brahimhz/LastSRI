package BackEnd;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.HashMap;

public class Score implements Comparable<Score> {


    double score;
    public int id_doc;
    public String title_doc;

    public Score(int id_doc, ArrayList<String> requet ){

        HashMap<String,Double> poids_et_terme_document =Poids_ET_Terme_Document(id_doc);

        HashMap<String,Integer> poids_et_terme_Requet=Poids_ET_Terme_Requet(requet);

        ArrayList<String>terme_en_commun=Terme_en_commun(poids_et_terme_document,requet);

        double prodiut_scalaire=0;

        for (String str : terme_en_commun){

            prodiut_scalaire += ( Poid_Chaque_Terme_Document(str,poids_et_terme_document) * Poid_Chaque_Terme_Requet(str,poids_et_terme_Requet));

        }

        this.id_doc = id_doc;
        this.score=  2*prodiut_scalaire / (Somme_Poids_Carre_Document(poids_et_terme_document) + Somme_Poids_Carre_Requet(poids_et_terme_Requet)) ;

    }

    /*******************************************************************************************************************/
    public HashMap<String,Double> Poids_ET_Terme_Document (int id_doc){

        Conexion_BDD conx=new Conexion_BDD();
        HashMap<String,Double> poid_terme_document=new HashMap<>();
        DBObject statusQuery=new BasicDBObject("id_doc",id_doc ); ;
        DBObject fields = new BasicDBObject("$elemMatch", statusQuery);
        DBObject query = new BasicDBObject("posting",fields);
        FindIterable<Document> findIterable = conx.collection.find((Bson) query);

        for (Document doc : findIterable) {
            ArrayList<Document> doc_post = (ArrayList<Document>) doc.get("posting");
            for (int i=0;i<doc_post.size();i++) {
                if(doc_post.get(i).get("id_doc").equals(id_doc))
                    poid_terme_document.put( (String) doc.get("term") ,    ((Double) doc_post.get(i).get("Poid"))    );
            }
        }

        return poid_terme_document;
    }

    /********************************************************************************************************************/
    private ArrayList<String> Terme_en_commun(HashMap<String,Double> terme_doc,ArrayList<String> termr_requet){

        ArrayList<String> terme_en_commun = new ArrayList<String>(terme_doc.keySet());
        terme_en_commun.retainAll(termr_requet);

        return terme_en_commun;
    }

    /************************************************************************************************************************/

/*********************************************************************************/
    private double Somme_Poids_Carre_Document(HashMap<String,Double> terme_doc){

        double sum = 0;
        ArrayList<Double> Poid_terme =new ArrayList<>(terme_doc.values());
        for(double d : Poid_terme)
            sum += Math.pow(d ,2);
        return sum;
    }

/***********************************************************************************************/

    private HashMap<String,Integer> Poids_ET_Terme_Requet(ArrayList<String> requet){

        HashMap<String,Integer> poid_requet=new HashMap<>();

        for(String r : requet) {
            if (poid_requet.containsKey(r))
                 poid_requet.replace(r,poid_requet.get(r)+1);
            else
                poid_requet.put(r,1);
        }

        return poid_requet;
    }
/************************************************************************************/
    private double Somme_Poids_Carre_Requet(HashMap<String,Integer> poids_requet){

        double sum=0;
        ArrayList<Integer> Poid_terme =new ArrayList<>(poids_requet.values());

        for(int d : Poid_terme)
            sum += d;

        return sum;
    }
/******************************************************************************************************/
    private double Poid_Chaque_Terme_Requet(String terme_comun,HashMap<String,Integer>poid_terme_requet ){
        return poid_terme_requet.get(terme_comun);
    }

    private double Poid_Chaque_Terme_Document(String terme_comun,HashMap<String,Double>poid_terme_document ){
        return poid_terme_document.get(terme_comun);
    }


    @Override
    public int compareTo(Score o) {

        int compare= Double.compare(o.score,score);
        return compare;
    }
}
