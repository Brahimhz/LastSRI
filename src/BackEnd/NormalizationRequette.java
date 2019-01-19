package BackEnd;

import java.util.ArrayList;

public class NormalizationRequette {

    public ArrayList<String> rootedQuery;
    Stemmer racinisation;

    public NormalizationRequette(ArrayList<String> Query)
    {
        rootedQuery = Query;

            for (int i=0; i<rootedQuery.size(); i++)
            {
                racinisation = new Stemmer(rootedQuery.get(i));
                rootedQuery.set(i, racinisation.term);
            }

    }
}
