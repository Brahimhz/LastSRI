package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EliminationEWRequette {

    File SlTxtFile;
    Scanner scanner;
    ArrayList<String> StopList;
    public  ArrayList<String> EmptyWordsEliminatedQ;

    public EliminationEWRequette(ArrayList<String> Requette) throws FileNotFoundException {

        SlTxtFile = new File("stoplist.txt");
        scanner = new Scanner(SlTxtFile);
        StopList = new ArrayList<>();

        while (scanner.hasNextLine())
            StopList.add(scanner.nextLine());

        EmptyWordsEliminatedQ = Requette;
            for (int i=0; i<EmptyWordsEliminatedQ.size(); i++)
            {
                String word = EmptyWordsEliminatedQ.get(i);
                if (StopList.contains(word))
                {
                    EmptyWordsEliminatedQ.remove(EmptyWordsEliminatedQ.get(i));
                    i--;
                }
            }


    }

}
