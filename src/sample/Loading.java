package sample;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Loading {

    private Search search;

    @FXML
    private BorderPane borderLoading;

    @FXML
    private Label label;

    public void transfert(String text, int radioCheck) throws FileNotFoundException, InterruptedException {

                resultTransation(text,radioCheck);


    }

    private void resultTransation(String text, int radioCheck) {

        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(10000));
        fadeTransition.setNode(borderLoading);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished( (ActionEvent event ) -> {
            loadResult(text,radioCheck);
        });

        fadeTransition.play();
    }

    private void loadResult(String text, int radioCheck) {

        try {


            FXMLLoader loader=new FXMLLoader(getClass().getResource("Result.fxml"));

            Parent resultView=loader.load();

            long startTime = System.currentTimeMillis();
            search = new Search(text);

            Result result=loader.getController();
            result.showResult(text,radioCheck,search.copyTitles());

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            System.out.println(elapsedTime);


            Scene newScene = new Scene(resultView,1900,1000);

            Stage curStage =(Stage) borderLoading.getScene().getWindow();

            curStage.setScene(newScene);

            curStage.setTitle("Your Result");

            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            curStage.setX((primScreenBounds.getWidth() - curStage.getWidth()) / 2);
            curStage.setY((primScreenBounds.getHeight() - curStage.getHeight()) / 2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
