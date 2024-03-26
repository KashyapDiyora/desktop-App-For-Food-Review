

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.controlsfx.control.Rating;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.UDPClient;


public class Controller2 {
    @FXML
    private Button btn2;
    @FXML
    private Rating rating1;
    @FXML
    private Rating rating2;
    @FXML
    private Rating rating3;
    @FXML
    private Rating rating4;
    @FXML
    private Rating rating5;
    @FXML
    private Rating rating6;
    @FXML
    private Rating rating7;
    @FXML
    private Rating rating8;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Label label4;
    @FXML
    Label label5;
    @FXML
    Label label6;
    @FXML
    Label label7;
    @FXML
    Label label8;

    public void submit(ActionEvent event) {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("dosha:" + rating1.getRating() + ",\n");
            writer.write("bhajiya:" + rating2.getRating() + ",\n");
            writer.write("gujarati thali:" + rating3.getRating() + ",\n");
            writer.write("vada pav:" + rating4.getRating() + ",\n");
            writer.write("manchurian:" + rating5.getRating() + ",\n");
            writer.write("paneer:" + rating6.getRating() + ",\n");
            writer.write("batter chicken:" + rating7.getRating() + ",\n");
            writer.write("pav bhaji:" + rating8.getRating() + ",\n");

           

            // Stage stage = (Stage) btn2.getScene().getWindow();
            // stage.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void readFileAndUpdateLabels() {
        File reader = new File("./extractedData.txt");
        try (Scanner sc = new Scanner(reader)) {
            String data = "";
            while (sc.hasNextLine()) {
                data = data + sc.nextLine();
            }

            String[] extractedStr = data.split(",");
            label1.setText(extractedStr[0]);
            label1.setText(extractedStr[1]);
            label1.setText(extractedStr[2]);
            label1.setText(extractedStr[3]);
            label1.setText(extractedStr[4]);
            label1.setText(extractedStr[5]);
            label1.setText(extractedStr[6]);
            label1.setText(extractedStr[7]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}