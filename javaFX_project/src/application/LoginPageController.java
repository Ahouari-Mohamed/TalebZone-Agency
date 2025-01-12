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
import javafx.scene.image.Image;
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
        	if (validateAllInputs()) {
	            Parent mainPage = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
	            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	            Scene scene = new Scene(mainPage);
	            stage.setScene(scene);
	            stage.show();
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean validateEmail() {
        String emailVal = email.getText();
        boolean isValid = emailVal.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        updateFieldStyle(email, isValid);
        return isValid;
    }
    
    private boolean validatePasscode() {
        String mot_passeVal = mot_passe.getText();
        
        if (mot_passeVal == null || mot_passeVal.trim().isEmpty()) {
        	updateFieldStyle(mot_passe, false);
            updateFieldStyle(visible_passe, false);
            return false;
        }
        return true;
    }
    
    private boolean validateAllInputs() {
        boolean isEmailValid = validateEmail();
        boolean isPasscodeValid = validatePasscode();

        return isEmailValid && isPasscodeValid;
    }
    
    private void updateFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("-fx-background-color:  transparant; -fx-border-color: green; -fx-border-width:  0px 0px 2px 0px;");
        } else {
            field.setStyle("-fx-background-color:  transparant; -fx-border-color: red; -fx-border-width: 0px 0px 2px 0px;");
        }
    }

    @FXML
    public void handleForgotPassword(ActionEvent event) {
        try {
            Parent forgotPasswordPage = FXMLLoader.load(getClass().getResource("forgotPasswordPage.fxml"));
            
            // Set window properties
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

            // Set window properties
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(registerPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
