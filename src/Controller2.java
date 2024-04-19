import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.controlsfx.control.Rating;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;

    @FXML
    public void submit(ActionEvent event) {
        
        // Get the ratings data from UI
        String data = String.format("%f,%f,%f,%f,%f,%f,%f,%f",
                rating1.getRating(), rating2.getRating(), rating3.getRating(),
                rating4.getRating(), rating5.getRating(), rating6.getRating(),
                rating7.getRating(), rating8.getRating());

        // Create and start a new thread to perform the network operation
        Thread thread = new Thread(() -> {
            try {
                // Perform the network operation
                UDPClient udpClient = new UDPClient();
                String clientData = udpClient.udpClient(data);

                // Update UI on the JavaFX Application Thread
                Platform.runLater(() -> {
                    try {
                        // Update labels with received data
                        String[] extractedArr = clientData.split(",");
                        if (extractedArr.length >= 8) {
                            label1.setText(extractedArr[0]);
                            label2.setText(extractedArr[1]);
                            label3.setText(extractedArr[2]);
                            label4.setText(extractedArr[3]);
                            label5.setText(extractedArr[4]);
                            label6.setText(extractedArr[5]);
                            label7.setText(extractedArr[6]);
                            label8.setText(extractedArr[7]);
                        } else {
                            System.err.println("Received data is incomplete.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (SocketException | UnknownHostException e) {
                e.printStackTrace();
                // Handle exceptions, e.g., display error message to the user
            } catch (IOException e) {
                e.printStackTrace();
                // Handle IO exceptions, e.g., display error message to the user
            }
        });

        // Start the thread
        thread.start();
    }
}