package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	Pane root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));

    	// Set the icon for the stage
        Image icon = new Image(getClass().getResourceAsStream("Images/TZ_logo_min.png"));
        primaryStage.getIcons().add(icon);

        // Set window properties
        primaryStage.setTitle("TalebZone Agency");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
