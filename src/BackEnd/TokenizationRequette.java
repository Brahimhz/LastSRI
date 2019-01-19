package BackEnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TokenizationRequette {

    public  ArrayList<String> TokenizeRequet;

    public TokenizationRequette(String TokenizeRequet)
    {

        String delimiters = "\\s+[^a-z]+[0-9]+[^a-z]+\\s+|\\s+|[^a-z0-9-']";


            TokenizeRequet = TokenizeRequet.toLowerCase();

            String[]req=TokenizeRequet.split(delimiters);

            for (int i = 0; i < req.length; i++) {

                req[i]=req[i].replaceAll("^-+|-+$|^'+|'+$|^[0-9+.0-9+]$", "");
                req[i]=req[i].replaceAll("^[0-9]+-[0-9]+$","");
                req[i]=req[i].replaceAll("^[0-9]+$","");

            }

            req = Arrays.asList(req).stream().filter(str1 -> !str1.isEmpty()).collect(Collectors.toList()).toArray(new String[0]);

            this.TokenizeRequet = new ArrayList<>(Arrays.asList(req));

    }

}
