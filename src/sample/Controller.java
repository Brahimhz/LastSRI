package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField searchText;
    @FXML
    private Button searchButton ;

    @FXML
    public void initialize()
    {
        searchButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked()
        {
            System.out.println("Result : " + searchText.getText() );

            try {
                Thread.sleep(10000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            searchText.clear();
        }

    @FXML
    public void noSpace ()
    {
        String text = searchText.getText() ;
        Boolean disableSearchButton = text.isEmpty() || text.trim().isEmpty();
        searchButton.setDisable(disableSearchButton);
    }
}
