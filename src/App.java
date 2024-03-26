import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }   

    @Override
    public void start(Stage primaryStage)  {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("./Scene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Food Review");
            primaryStage.setResizable(true);
            Image icon = new Image("./zomato.png");
            primaryStage.getIcons().add(icon);
            primaryStage.show();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
