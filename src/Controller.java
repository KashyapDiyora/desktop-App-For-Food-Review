

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class Controller {

    @FXML
    Button btn1;

    public void switchScene2(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("./Scene2.fxml"));
        Stage window = (Stage) btn1.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    }

