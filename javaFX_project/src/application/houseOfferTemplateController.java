package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class houseOfferTemplateController {

    @FXML
    private Button btn_réserver;

    @FXML
    private ImageView icon_femenine;

    @FXML
    private ImageView icon_masculin;

    @FXML
    private ImageView image;

    @FXML
    private Text nbrChambres;

    @FXML
    private Text nbrEtudiantsDésirer;

    @FXML
    private Text nbrPlacesDispo;

    @FXML
    private Text prix;

    @FXML
    private Text ville;

    @FXML
    void onReserve(ActionEvent event) {
        try {
            // Load the FXML for the popup
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reservationPopup.fxml"));
            Parent popupRoot = loader.load();
            
            // Get the controller of the popup
            ReservationPopupController popupController = loader.getController();
            popupController.setMainController(this);

            // Create and configure the popup stage
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Réservation Details");
            popupStage.setScene(new Scene(popupRoot));
            popupStage.setResizable(false);
            popupStage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("Images/TZ_logo_min.png")));

            // Show the popup and wait
            popupStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Placeholder for saving the reservation
    public void saveReservation(ReservationPopupController.Reservation reservation) {
        System.out.println("Saving reservation...");
        System.out.println("House details: " + ville.getText() + ", " + prix.getText());
        System.out.println("Reservation details: " + reservation);

        // oussama stocker f database ola dir wa7d class reservation generale ogm3 fiha kolchi
    }

}
