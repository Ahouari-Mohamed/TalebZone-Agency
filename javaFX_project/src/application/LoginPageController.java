package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField mot_passe;
    
    @FXML
    private TextField visible_passe;
    
    @FXML
    private CheckBox affiche_passe;

    @FXML
    private Button se_connecter;
    
    @FXML
    private Hyperlink oublier_mot_passe;
    
    @FXML
    private Hyperlink créer_compte;
    
    @FXML
    public void handleShowPassword(ActionEvent event) {
        if (affiche_passe.isSelected()) {
            // Show password
            visible_passe.setText(mot_passe.getText());
            visible_passe.setVisible(true);
            visible_passe.setManaged(true);
            mot_passe.setVisible(false);
            mot_passe.setManaged(false);
        } else {
            // Hide password
        	mot_passe.setText(visible_passe.getText());
        	mot_passe.setVisible(true);
        	mot_passe.setManaged(true);
            visible_passe.setVisible(false);
            visible_passe.setManaged(false);
        }
    }
    
    @FXML
    public void handleLogin(ActionEvent event) {
        try {
            Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(mainPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleForgotPassword(ActionEvent event) {
        try {
            Parent forgotPasswordPage = FXMLLoader.load(getClass().getResource("forgotPasswordPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(forgotPasswordPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void handleRegister(ActionEvent event) {
        try {
            Parent registerPage = FXMLLoader.load(getClass().getResource("registerPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(registerPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
