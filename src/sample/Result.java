package sample;

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Result implements Initializable {

    @FXML
    private TextField searchText,docNo;
    @FXML
    private Button searchButton ;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ListView docList;
    @FXML
    private TextArea title,abst;
    @FXML
    private VBox showDetails;

    private List<Document> documents,searchDoc=null;

    @FXML
    public void onButtonClicked()
    {
        System.out.println("Result : " + searchText.getText() );

           /* try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        searchText.clear();
        searchButton.setDisable(true);
        searchButton.setDefaultButton(true);

    }

    @FXML
    public void noSpace ()
    {
        String text = searchText.getText() ;
        Boolean disableSearchButton = text.isEmpty() || text.trim().isEmpty();
        searchButton.setDisable(disableSearchButton);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        searchButton.setDisable(true);
        searchButton.setDefaultButton(true);
        borderPane.setStyle("-fx-background-image: url('file:image/back2.png') ;");
        docList.setStyle("-fx-background-image: url('file:image/back2.png') ;");



    }



    private boolean pushList(String text, int ii) {

        Document Doc1=new Document
                ("88000001",
                 "The binding of acetaldehyde to the active site of ribonuclease: alterations in catalytic activity and effects of phosphate",
                 "Ribonuclease A was reacted with [1-13C,1,2-14C]acetaldehyde and sodium cyanoborohydride in the presence or absence of 0.2 M phosphate. After several hours of incubation at 4 degrees C (pH 7.4) stable acetaldehyde-RNase adducts were formed, and the extent of their formation was similar regardless of the presence of phosphate. Although the total amount of covalent binding was comparable in the absence or presence of phosphate, this active site ligand prevented the inhibition of enzymatic activity seen in its absence. This protective action of phosphate diminished with progressive ethylation of RNase, indicating that the reversible association of phosphate with the active site lysyl residue was overcome by the irreversible process of reductive ethylation. Modified RNase was analysed using 13C proton decoupled NMR spectroscopy. Peaks arising from the covalent binding of enriched acetaldehyde to free amino groups in the absence of phosphate were as follows: NH2-terminal alpha amino group, 47.3 ppm; bulk ethylation at epsilon amino groups of nonessential lysyl residues, 43.0 ppm; and the epsilon amino group of lysine-41 at the active site, 47.4 ppm. In the spectrum of RNase ethylated in the presence of phosphate, the peak at 47.4 ppm was absent. When RNase was selectively premethylated in the presence of phosphate, to block all but the active site lysyl residues and then ethylated in its absence, the signal at 43.0 ppm was greatly diminished, and that arising from the active site lysyl residue at 47.4 ppm was enhanced. These results indicate that phosphate specifically protected the active site lysine from reaction with acetaldehyde, and that modification of this lysine by acetaldehyde adduct formation resulted in inhibition of catalytic activity.");


        Document Doc2=new Document(
                "88000002",
                "Reductions in breath ethanol readings in normal male volunteers following mouth rinsing with water at differing temperatures.",
                "Blood ethanol concentrations were measured sequentially, over a period of hours, using a Lion AE-D2 alcolmeter, in 12 healthy male subjects given oral ethanol 0.5 g/kg body wt. Readings were taken before and after rinsing the mouth with water at varying temperatures. Mouth rinsing resulted in a reduction in the alcolmeter readings at all water temperatures tested. The magnitude of the reduction was greater after rinsing with water at lower temperatures. This effect occurs because rinsing cools the mouth and dilutes retained saliva. This finding should be taken into account whenever breath analysis is used to estimate blood ethanol concentrations in experimental situations.");


        Document Doc3=new Document(
                "88000003",
                "Does the blockade of opioid receptors influence the development of ethanol dependence?",
                "We have tested whether the opioid antagonists naloxone (2 mg/kg), naltrexone (2 mg/kg) and diprenorphine (0.2 mg/kg), and the agonist morphine (4-8 mg/kg) given subcutaneously (10 min before ethanol for 7 days) modify the ethanol withdrawal syndrome (audiogenic seizures) following chronic ethanol intoxication in rats. We found that naloxone, naltrexone and diprenorphine modified the ethanol withdrawal syndrome. These findings do not rule out the possibility of a biochemical link between the action of ethanol and opiates at the level of opioid receptors.");


        Document Doc4=new Document(
                "88000006",
                "Drinkwatchers--description of subjects and evaluation of laboratory markers of heavy drinking.",
                "Clinical examination and measurement of MCV and GGT were carried out on 124 self-referred 'healthy' Drinkwatchers, all of whom had consumed at least 80 g alcohol/day for more than 2 years. The majority (66.1%) were in social classes II and III. Sixty-three subjects (54.1%) had a raised MCV, GGT or hepatomegaly. A raised MCV was significantly more likely to occur in men. Forty-five subjects (36.3%) had an enlarged liver of whom 17 had a normal MCV and GGT. This study shows that MCV and GGT are poor screening tests for excessive alcohol consumption in 'healthy' subjects but, if used at all, MCV appears to be more sensitive in women and GGT in men. Neither test is an adequate substitute for a careful history and full clinical examination.");


        Document Doc5=new Document(
                "88000007",
                "Platelet affinity for serotonin is increased in alcoholics and former alcoholics: a biological marker for dependence?",
                "The kinetics of 3H serotonin platelet uptake were studied in alcoholics and former alcoholics to see whether differences found between alcohol-preferring and non-preferring rats could be reproduced in man. Three groups of patients were studied: 10 dependent alcoholics on admission for treatment; 10 dependent alcoholics after 20 days of treatment; 8 former dependent alcoholics, abstinent for 1-11 years. Controls were non-alcoholics, matched for age and sex. The Km for 3H serotonin uptake in platelets was lower in patients from all three groups compared to 15 controls. This phenomenon could be congenital or induced by the previous excessive intake of alcohol. We believe that this increased platelet affinity for serotonin, in the absence of cirrhosis of the liver and/or depression could be a marker for alcohol dependence, enabling the therapeutic effort to be focussed on these patients.");


        Document Doc6=new Document(
                "88000008",
                "- Clonidine in alcohol withdrawal: a pilot study of differential symptom responses following i.v. clonidine.",
                "The effects of an i.v. bolus of clonidine (1.5 mg/kg) on withdrawal symptoms were studied in 7 male alcoholics, and compared with 7 normal controls. Clonidine reduced both subjective and objective measures of withdrawal but this only reached significance for scores of depression and muscle tension. In comparison with controls alcoholics in withdrawal showed reduced sedative effects of clonidine.");

        documents=new ArrayList<>();
        documents.add(Doc1);
        documents.add(Doc2);
        documents.add(Doc3);
        documents.add(Doc4);
        documents.add(Doc5);
        documents.add(Doc6);

        searchDoc=new ArrayList<>();

        for(int i=0;i<5;i++)
            {
               if(searchWord(documents.get(i),text,ii)==true)
               {
                   System.out.println("\n TRUE \n");
                   searchDoc.add(documents.get(i));
               }


            }

            if (searchDoc!=null)
            {
                docList.setVisible(true);
            }

         docList.getItems().setAll(searchDoc);


        return true;
    }

    private boolean searchWord(Document document, String text, int ii) {

        String[] arrT=document.getTitle().split(" ");
        String[] arrA=document.getAbstract().split(" ");
        String[] arrTxt=text.split(" ");
        String arrN=document.getDocNo().trim();
        if(ii==2)
        {
            if(arrN.equals(text))
            return true;
        }
        else{
        for (int i=0;i<(arrTxt.length);i++)
        {

                for(int j=0;j<(arrT.length);j++)
                {
                    if(arrT[j].equals(arrTxt[i]))
                    {
                            return true;
                    }
                }
                for(int k=0;k<(arrA.length);k++)
                {
                    if(arrA[k].equals(arrTxt[i]))
                    {
                        return true;
                    }
                }
        }
        }

        return false;
    }

    public void showResult(String text, int i) {

        searchText.setText(text);
        docList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        pushList(text,i);
    }

    @FXML
    public void selectList()
    {


        Document document= (Document) docList.getSelectionModel().getSelectedItem();

        docNo.setText(document.getDocNo());
        title.setText(document.getTitle());
        abst.setText(document.getAbstract());

        showDetails.setVisible(true);
        new FadeInUp(showDetails).play();


    }


}
