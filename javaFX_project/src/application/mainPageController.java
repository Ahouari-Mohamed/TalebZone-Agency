package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    private Button propertiesBtn;
    
    @FXML
    private VBox pnlProperties;
    
    @FXML
    private GridPane gridPane;

    @FXML
    private ChoiceBox<String> triMode;

    @FXML
    private ChoiceBox<String> triOption;

    @FXML
    private ChoiceBox<String> triVille;

    @FXML
    private Button triChercher;
    
    @FXML
    private HBox paginationBox;

    @FXML
    private Button settingsBtn;
    
    @FXML
    private ScrollPane pnlSettings;

    @FXML
    private Button reservationsBtn;

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
        
	    // loadHouseOffersFromDatabase();  // Load all offers into memory
        addTestHouseOffers();
        displayOffers(houseOffers);               // Display the first page
        updatePagination(houseOffers); 
        
        // Initialize ChoiceBox components
        initializeChoiceBoxes();
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

    private List<HouseOffer> houseOffers = new ArrayList<>(); // Store all offers
    private int currentPage = 0;                              // Current page index
    private final int itemsPerPage = 6;                      // Offers per page (2 rows * 3 columns)

    //private void loadHouseOffersFromDatabase() {
    //}

    private void addTestHouseOffers() {
    	 // Add sample house offers with image byte arrays
        houseOffers.add(new HouseOffer(
            "Agadir", 3, 2, "Maison", 5, 12000.0
        ));
        houseOffers.add(new HouseOffer(
            "Marrakech", 4, 3, "Villa", 6, 25000.0
        ));
        houseOffers.add(new HouseOffer(
            "Casablanca", 2, 1, "Appartement", 2,8000.0
        ));
        houseOffers.add(new HouseOffer(
            "Rabat", 3, 3, "Appartement", 4, 15000.0
        ));
        houseOffers.add(new HouseOffer(
            "Fes", 5, 4, "Villa", 8, 35000.0
        ));
        houseOffers.add(new HouseOffer(
            "Tangier", 2, 2, "Maison", 3, 10000.0
        ));
        houseOffers.add(new HouseOffer(
                "Tangier", 2, 2, "Maison", 3, 10000.0
            ));
        houseOffers.add(new HouseOffer(
                "Tangier", 2, 2, "Maison", 3, 10000.0
            ));
        houseOffers.add(new HouseOffer(
                "Tangier", 2, 2, "Maison", 3, 10000.0
            ));
    }
    
    private void displayOffers(List<HouseOffer> houseOffers) {
	    gridPane.getChildren().clear(); // Clear previous content

        int startIndex = currentPage * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, houseOffers.size());

        int row = 0, col = 0;
        for (int i = startIndex; i < endIndex; i++) {
            HouseOffer offer = houseOffers.get(i);

            try {
                // Load the FXML template for a single offer
                FXMLLoader loader = new FXMLLoader(getClass().getResource("houseOfferTemplate.fxml"));
                Node houseOfferNode = loader.load();

                // Populate the FXML template with data
                ((Text) houseOfferNode.lookup("#prix")).setText(String.valueOf(offer.getPrix()));
                ((Text) houseOfferNode.lookup("#ville")).setText(offer.getVille());
                ((Text) houseOfferNode.lookup("#nbrChambres")).setText(String.valueOf(offer.getNbrChambres()));
                ((Text) houseOfferNode.lookup("#nbrEtudiantsDésirer")).setText(String.valueOf(offer.getNombreEtudiantsDésirer()));
                ((Text) houseOfferNode.lookup("#nbrPlacesDispo")).setText(String.valueOf(offer.getNbrPlacesDispo()));
                
                
                // Set the image from the getImage() method (returns the principal image)
                //ImageView imageView = (ImageView) houseOfferNode.lookup("#image");
                //imageView.setImage(offer.getImage()); // This will use the getImage() method to get the principal image


                // Add the node to the grid
                gridPane.add(houseOfferNode, col, row);
                GridPane.setHalignment(houseOfferNode, HPos.CENTER); // Horizontally center the node
                GridPane.setValignment(houseOfferNode, VPos.CENTER); // Vertically center the node

                // Update column and row indices
                col++;
                if (col == 3) {
                    col = 0;
                    row++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updatePagination(List<HouseOffer> houseOffers) {
        paginationBox.getChildren().clear(); // Clear previous pagination controls

        int totalPages = (int) Math.ceil((double) houseOffers.size() / itemsPerPage);

        // Add "Prev" button
        Button prevButton = new Button("Prev");
        prevButton.setDisable(currentPage == 0); // Disable on the first page
        prevButton.setOnAction(e -> changePage(currentPage - 1, houseOffers));
        paginationBox.getChildren().add(prevButton);

        // Add "Next" button
        Button nextButton = new Button("Next");
        nextButton.setDisable(currentPage == totalPages - 1); // Disable on the last page
        nextButton.setOnAction(e -> changePage(currentPage + 1, houseOffers));
        paginationBox.getChildren().add(nextButton);
    }

    private void changePage(int pageIndex, List<HouseOffer> houseOffers) {
        currentPage = pageIndex;
        displayOffers(houseOffers);    // Refresh offers on the selected page
        updatePagination(houseOffers); // Update pagination controls
    }
    
    private void initializeChoiceBoxes() {
        // Populate triVille with Moroccan cities sorted alphabetically
    	List<String> villes = List.of(
	        "Aucune", "Agadir", "Casablanca", "Fès", "Marrakech", "Rabat", "Tanger"
	    );
	    villes.stream()
	        .sorted()
	        .map(ville -> ville) // Names in French, unchanged
	        .forEach(ville -> triVille.getItems().add(ville));

        // Populate triMode with sorting modes
        triMode.getItems().addAll("Croissant", "Décroissant");

        // Populate triOption with sorting options
        triOption.getItems().addAll("Prix", "Nombre Chambres", "Nombre Etudiants");
    }
    
    @FXML
    void onTriCherche(ActionEvent event) {
        // Get selected values from the ChoiceBoxes
        String selectedVille = (String) triVille.getValue();
        String selectedMode = (String) triMode.getValue();
        String selectedOption = (String) triOption.getValue();

        // Filter offers by city if a city is selected
        List<HouseOffer> filteredOffers = houseOffers;
        if (selectedVille != null && !selectedVille.equalsIgnoreCase("Aucune")) {
            filteredOffers = filteredOffers.stream()
                .filter(offer -> offer.getVille().equalsIgnoreCase(selectedVille))
                .toList();
        }

        // Sort offers based on the selected option and mode
        if (selectedOption != null && selectedMode != null) {
            filteredOffers = switch (selectedOption) {
                case "Prix" -> filteredOffers.stream()
                    .sorted((o1, o2) -> selectedMode.equals("Croissant")
                            ? Double.compare(o1.getPrix(), o2.getPrix())
                            : Double.compare(o2.getPrix(), o1.getPrix()))
                    .toList();
                case "Nombre Chambres" -> filteredOffers.stream()
                    .sorted((o1, o2) -> selectedMode.equals("Croissant")
                            ? Integer.compare(o1.getNbrChambres(), o2.getNbrChambres())
                            : Integer.compare(o2.getNbrChambres(), o1.getNbrChambres()))
                    .toList();
                case "Nombre Etudiants" -> filteredOffers.stream()
                    .sorted((o1, o2) -> selectedMode.equals("Croissant")
                            ? Integer.compare(o1.getNombreEtudiantsDésirer(), o2.getNombreEtudiantsDésirer())
                            : Integer.compare(o2.getNombreEtudiantsDésirer(), o1.getNombreEtudiantsDésirer()))
                    .toList();
                default -> filteredOffers;
            };
        }

        currentPage = 0;
        displayOffers(filteredOffers);
        updatePagination(filteredOffers);
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
    
    @FXML
    void handleSignOut(ActionEvent event) {
        System.out.println("Sign-out button clicked!");
    }
}