package sample;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton ;
    @FXML
    private GridPane gridpane;

    @FXML
    public void initialize()
    {
        searchButton.setDisable(true);
        searchButton.setDefaultButton(true);
        gridpane.setStyle("-fx-background-image: url('https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQxsasGQIwQNwjek3F1nSwlfx60g6XpOggnxw5dyQrtCL_0x8IW') ;");

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

    private void resultTransation() {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(3));
        fadeTransition.setNode(gridpane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished( (ActionEvent event ) -> {
             loadResult();
            });

        fadeTransition.play();
    }

    private void loadResult()
    {


            try {

                FXMLLoader loader=new FXMLLoader(getClass().getResource("Result.fxml"));

                Parent resultView=loader.load();

                Result result=loader.getController();
                result.showResult(searchText.getText());

                Scene newScene = new Scene(resultView,1500,600);

                Stage curStage =(Stage) gridpane.getScene().getWindow();

                curStage.setScene(newScene);

                curStage.setTitle("Your Result");




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

    @FXML
    public String showResult()
    {
        return searchText.getText();
    }

}
