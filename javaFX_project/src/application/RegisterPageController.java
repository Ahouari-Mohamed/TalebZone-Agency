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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterPageController {

    @FXML
    private TextField email;

    @FXML
    private TextField  prénom;
    
    @FXML
    private TextField  nom;

    @FXML
    private TextField num_telephone;

    @FXML
    private PasswordField mot_passe;

    @FXML
    private TextField visible_passe;
    
    @FXML
    private PasswordField répeter_passe;

    @FXML
    private CheckBox affiche_passe;
    
    @FXML
    private Button inscrire;

    @FXML
    void handleShowPassword(ActionEvent event) {
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
    void handleRegister(ActionEvent event) {
    	try {
    		if (validateAllInputs() && validatePasswordMatch()) {
    	    	// enregistrer les données premierement
    			Parent loginPage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));

                // Set window properties
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loginPage);
                stage.setScene(scene);
                stage.show();
                System.out.println("Account created successfully!");
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

    private boolean validatePhone() {
        String phoneVal = num_telephone.getText();
        boolean isValid = phoneVal.matches("^0[0-9]{9}$");
        updateFieldStyle(num_telephone, isValid);
        return isValid;
    }

    private boolean validateName() {
        String nomVal = nom.getText();
        boolean isValid = nomVal.length() >= 3 && nomVal.matches("^[a-zA-Z\\s]+$");
        updateFieldStyle(nom, isValid);
        return isValid;
    }
    
    private boolean validateFamilyName() {
        String prénomVal = prénom.getText();
        boolean isValid = prénomVal.length() >= 3 && prénomVal.matches("^[a-zA-Z\\s]+$");
        updateFieldStyle(prénom, isValid);
        return isValid;
    }

    private boolean validatePasscode() {
        String mot_passeVal = mot_passe.getText();
        boolean isValid = mot_passeVal.length() >= 6 && mot_passeVal.length() <= 20;
        updateFieldStyle(mot_passe, isValid);
        updateFieldStyle(visible_passe, isValid);
        return isValid;
    }

    private boolean validateAllInputs() {
        boolean isEmailValid = validateEmail();
        boolean isPhoneValid = validatePhone();
        boolean isNameValid = validateName();
        boolean isFamilyNameValid = validateFamilyName();
        boolean isPasscodeValid = validatePasscode();

        return isEmailValid && isPhoneValid && isNameValid && isPasscodeValid && isFamilyNameValid;
    }

    private void updateFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("-fx-background-color:  transparant; -fx-border-color: green; -fx-border-width:  0px 0px 2px 0px;");
        } else {
            field.setStyle("-fx-background-color:  transparant; -fx-border-color: red; -fx-border-width: 0px 0px 2px 0px;");
        }
    }
    
    private boolean validatePasswordMatch() {
        String password = mot_passe.getText();
        String repeatPassword = répeter_passe.getText();
        boolean isMatch = password.equals(repeatPassword);
        updateFieldStyle(répeter_passe, isMatch);
        return isMatch;
    }


}
