package sample;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
         Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("What Do You Search ?");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        primaryStage.setResizable(false);

        new FadeIn(root).play();

     }


    public static void main(String[] args) {
        launch(args);




    }
}
