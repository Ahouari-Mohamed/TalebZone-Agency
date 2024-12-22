package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Pane root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

        // Set window properties
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
