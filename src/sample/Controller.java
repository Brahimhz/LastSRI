package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;


import java.io.IOException;
import java.util.ArrayList;

public class Controller {


    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton ;
    @FXML
    private GridPane gridpane;
    @FXML
    private RadioButton word;
    @FXML
    private RadioButton docNo;

    private Result result;


    @FXML
    public void initialize()
    {

        searchButton.setDisable(true);
        searchButton.setDefaultButton(true);
        gridpane.setStyle("-fx-background-image: url('file:image/back2.png') ;");
        radioCheck();

    }

    @FXML
    public void onButtonClicked()
        {
            System.out.println("Result : " + searchText.getText() );

           /* try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }*/


            searchButton.setDisable(true);
            searchButton.setDefaultButton(true);

            resultTransation();
        }

    public void resultTransation() {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(2));
        fadeTransition.setNode(gridpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished( (ActionEvent event ) -> {
             loadResult();
            });

        fadeTransition.play();
    }

    public void loadResult()
    {


            try {


                FXMLLoader loader=new FXMLLoader(getClass().getResource("Result.fxml"));

                Parent resultView=loader.load();

                Result result=loader.getController();
                result.showResult(searchText.getText(),radioCheck());


                Scene newScene = new Scene(resultView,1500,600);

                Stage curStage =(Stage) gridpane.getScene().getWindow();

                curStage.setScene(newScene);

                curStage.setTitle("Your Result");

                Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                curStage.setX((primScreenBounds.getWidth() - curStage.getWidth()) / 2);
                curStage.setY((primScreenBounds.getHeight() - curStage.getHeight()) / 2);


            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    @FXML
    public void noSpace ()
    {
        String text = searchText.getText() ;
        Boolean disableSearchButton = text.isEmpty() || text.trim().isEmpty();
        searchButton.setDisable(disableSearchButton);
    }

    public int radioCheck()
    {
            if(docNo.isSelected())
            {return 2;}
            else
            {return 1;}
    }
 }

