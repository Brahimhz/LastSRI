package BackEnd;

import java.util.ArrayList;
import java.util.HashSet;

public class Appariement {


    public HashSet<Integer> id_doc_term;


    public Appariement(ArrayList<String> Requet){

        ArrayList<BDD_Find> term_inf=new ArrayList<>();

        for (int i=0;i<Requet.size();i++){

            BDD_Find f =new BDD_Find(Requet.get(i));
            term_inf.add(f);

        }

        id_doc_term=new HashSet<>();

        for (int i=0;i<term_inf.size();i++){

            for (int j=0;j<term_inf.get(i).id_doc_pert.size();j++){
                id_doc_term.add(term_inf.get(i).id_doc_pert.get(j));
            }

        }

    }
}
