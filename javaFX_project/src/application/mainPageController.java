package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class mainPageController {

	@FXML
    private Button addClientBtn;

    @FXML
    private Button addUserBtn;

    @FXML
    private Button clientsBtn;

    @FXML
    private VBox gh;

    @FXML
    private Button homeBtn;

    @FXML
    private ScrollPane pnlClients;

    @FXML
    private ScrollPane pnlHome;

    @FXML
    private ScrollPane pnlReservations;

    @FXML
    private ScrollPane pnlProperties;

    @FXML
    private ScrollPane pnlSettings;

    @FXML
    private Button propertiesBtn;

    @FXML
    private Button reservationsBtn;

    @FXML
    private Button settingsBtn;

    @FXML
    private Button signoutBtn;

    @FXML
    private Button srchRentBtn;

    private Button activeButton;

    @FXML
    public void initialize() {
        // Set home page as the default active pane
        pnlHome.setVisible(true);
        pnlProperties.setVisible(false);
        pnlClients.setVisible(false);
        pnlReservations.setVisible(false);
        pnlSettings.setVisible(false);

        // Set the home button as the active button
        activeButton = homeBtn;
        activeButton.getStyleClass().add("active");
    }

    @FXML
    void handleClicks(ActionEvent event) {
        // Hide all panes
        pnlHome.setVisible(false);
        pnlProperties.setVisible(false);
        pnlClients.setVisible(false);
        pnlReservations.setVisible(false);
        pnlSettings.setVisible(false);

        // Reset active button style
        if (activeButton != null) {
            activeButton.getStyleClass().remove("active");
        }

        // Handle button click and activate the relevant pane
        if (event.getSource() == homeBtn) {
            pnlHome.setVisible(true);
            activeButton = homeBtn;
        } else if (event.getSource() == propertiesBtn) {
            pnlProperties.setVisible(true);
            activeButton = propertiesBtn;
        } else if (event.getSource() == clientsBtn) {
            pnlClients.setVisible(true);
            activeButton = clientsBtn;
        } else if (event.getSource() == reservationsBtn) {
        	pnlReservations.setVisible(true);
            activeButton = reservationsBtn;
        } else if (event.getSource() == settingsBtn) {
        	pnlSettings.setVisible(true);
            activeButton = settingsBtn;
        }

        // Add active style to the clicked button
        if (activeButton != null) {
            activeButton.getStyleClass().add("active");
        }
    }

    @FXML
    void handleSignOut(ActionEvent event) {
        System.out.println("Sign-out button clicked!");
    }

    @FXML
    void OnAddClientClicked(ActionEvent event) {

    }

    @FXML
    void OnAddUserClicked(ActionEvent event) {

    }

    @FXML
    void OnSearchRentClicked(ActionEvent event) {

    }
}