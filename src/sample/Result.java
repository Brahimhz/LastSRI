package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Result implements Initializable {

    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton ;
    @FXML
    private BorderPane borderPane;



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
        borderPane.setStyle("-fx-background-image: url('https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQxsasGQIwQNwjek3F1nSwlfx60g6XpOggnxw5dyQrtCL_0x8IW') ;");

    }

    public void showResult(String text) {
        searchText.setText(text);
    }
}
