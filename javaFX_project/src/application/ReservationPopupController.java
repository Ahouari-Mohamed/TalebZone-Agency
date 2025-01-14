package application;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ReservationPopupController {

    @FXML
    private TextField cin;

    @FXML
    private TextField nom;

    @FXML
    private TextField prénom;

    @FXML
    private ChoiceBox<String> gendre;

    @FXML
    private TextField adresse;

    @FXML
    private TextField num_telephone;

    @FXML
    private Button inscrire;

    private houseOfferTemplateController mainController; // Reference to the main controller

    // Setter to inject the main controller
    public void setMainController(houseOfferTemplateController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        // Initialize the gender choice box
        gendre.getItems().addAll("Male", "Female");
        gendre.setValue("Male");
    }

    @FXML
    void onSubmit(ActionEvent event) {
        if (validateAllInputs()) {
            // Create a reservation object with the collected data
            Reservation reservation = new Reservation(
                cin.getText(),
                nom.getText(),
                prénom.getText(),
                gendre.getValue(),
                adresse.getText(),
                num_telephone.getText()
            );

            // Pass the reservation data back to the main controller
            if (mainController != null) {
                mainController.saveReservation(reservation);
            }

            // Close the popup
            inscrire.getScene().getWindow().hide();
        }
    }

    private boolean validateCIN() {
        String cinVal = cin.getText();
        boolean isValid = cinVal.length() >= 7 && cinVal.matches("^(?=.*[A-Z])(?=.*\\d)[A-Z0-9]+$");
        updateFieldStyle(cin, isValid);
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

    private boolean validateGender() {
        boolean isValid = gendre.getValue() != null;
        if (!isValid) {
            gendre.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 0px 0px 2px 0px;");
        } else {
            gendre.setStyle("-fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 0px 0px 2px 0px;");
        }
        return isValid;
    }

    private boolean validateAdresse() {
        String adresseVal = adresse.getText();
        boolean isValid = adresseVal.length() >= 5;
        updateFieldStyle(adresse, isValid);
        return isValid;
    }

    private boolean validatePhone() {
        String phoneVal = num_telephone.getText();
        boolean isValid = phoneVal.matches("^0[0-9]{9}$");
        updateFieldStyle(num_telephone, isValid);
        return isValid;
    }

    private boolean validateAllInputs() {
        boolean isCINValid = validateCIN();
        boolean isNameValid = validateName();
        boolean isFNameValid = validateFamilyName();
        boolean isGenderValid = validateGender();
        boolean isAdresseValid = validateAdresse();
        boolean isPhoneValid = validatePhone();

        return isCINValid && isNameValid && isFNameValid && isGenderValid && isAdresseValid && isPhoneValid;
    }

    private void updateFieldStyle(TextField field, boolean isValid) {
        if (isValid) {
            field.setStyle("-fx-background-color: transparent; -fx-border-color: green; -fx-border-width: 0px 0px 2px 0px;");
        } else {
            field.setStyle("-fx-background-color: transparent; -fx-border-color: red; -fx-border-width: 0px 0px 2px 0px;");
        }
    }

    // Inner class for the reservation details
    public static class Reservation {
        private String cin;
        private String name;
        private String familyName;
        private String gender;
        private String address;
        private String phone;

        public Reservation(String cin, String name, String familyName, String gender, String address, String phone) {
            this.cin = cin;
            this.name = name;
            this.familyName = familyName;
            this.gender = gender;
            this.address = address;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "CIN: " + cin + ", Name: " + name + ", Family Name: " + familyName + 
                   ", Gender: " + gender + ", Address: " + address + ", Phone: " + phone;
        }
    }
}
