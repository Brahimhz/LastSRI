package BackEnd;


class Stemmer {

    String term;

    public Stemmer(String requet_)
    {
        if ((requet_.endsWith("sses"))) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 4);
            requet_=requet_+ "es";

        }
        if (requet_.endsWith("ies")) {
            int l = requet_.length();
            requet_.substring(0, l - 3);
            requet_=requet_ + "i";
        }
        if (requet_.endsWith("s")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 1);
        }
        if (requet_.endsWith("ed")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 2);
            int m = calcul_m(requet_);

            if (m == 0) requet_=requet_ + "ed";
        }
        if (requet_.endsWith("ing")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 3);
            if (calcul_m(requet_) == 0) requet_=requet_ + "ing";
        }
        if (requet_.endsWith("y")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 1);
            requet_=requet_ + "i";
        }
        if (requet_.endsWith("ational")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 7);
            if (calcul_m(requet_) == 0) requet_=requet_ + "ational";
            else requet_=requet_+ "ate";
        }
        if (requet_.endsWith("tional")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 6);
            if (calcul_m(requet_) == 0) requet_=requet_+ "tional";
            else requet_=requet_ + "tion";
        }
        if (requet_.endsWith("izer")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 4);
            if (calcul_m(requet_) == 0) requet_=requet_ + "izer";
            else requet_=requet_+ "ize";
        }
        if (requet_.endsWith("alize")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 5);
            if (calcul_m(requet_) == 0) requet_=requet_+ "alize" ;
            else requet_=requet_ + "al" ;
        }
        if (requet_.endsWith("ize")) {
            int l = requet_.length();
            requet_=requet_.substring(0, l - 3);

            if ((calcul_m(requet_) == 0) || (calcul_m(requet_) == 1))
                requet_=requet_ + "ize" ;
        }

        term = requet_;


    }




    public int calcul_m(String mot) {

        int size = 0;
        for (int i = 0; i < mot.length() - 1; i++) {

            if (test_vowel(mot.charAt(i))) {

                if (!test_vowel(mot.charAt(i + 1)) && !test_numbre(mot.charAt(i + 1))) {
                    size++;
                }

            }

        }


        return size;
    }

    public boolean test_vowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        else
            return false;

    }

    public boolean test_numbre(char ch) {

        if (ch == '0' || ch == '1' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9')
            return true;
        else
            return false;


    }
}