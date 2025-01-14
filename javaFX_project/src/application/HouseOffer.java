package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class HouseOffer {
    private byte[] imagePrincipale; // Image as a byte array
    private List<byte[]> images; // List of images as byte arrays
    private final String ville;
    private String adresseSpecifique;
    private final String genreDésirer;  // "Male", "Female"
    private final int nombreEtudiantsDésirer;
    private final int nbrChambres;
    private int nbrPlacesDispo;
    private final double prix;

    // Constructor with multiple images as byte arrays
    public HouseOffer(String ville, int nbrChambres, int nbrPlacesDispo, 
                      String genreDesirer, int nombreEtudiants, double prix) {
        this.ville = ville;
        this.nbrChambres = nbrChambres;
        this.genreDésirer = genreDesirer;
        this.nombreEtudiantsDésirer = nombreEtudiants;
        this.nbrPlacesDispo = nbrPlacesDispo;
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public String getVille() {
        return ville;
    }

    public String getAdresseSpecifique() {
        return adresseSpecifique;
    }

    public int getNbrChambres() {
        return nbrChambres;
    }

    public String getGenreDesirer() {
        return genreDésirer;
    }

    public int getNombreEtudiantsDésirer() {
        return nombreEtudiantsDésirer;
    }
    
    public int getNbrPlacesDispo() {
        return nbrPlacesDispo;
    }
    
    public void setNbrPlacesDispo(int nbrPlacesDispo) {
    	this.nbrPlacesDispo = nbrPlacesDispo;
    }

    public Image getImage() {
        // Convert byte array to Image
        return new Image(new java.io.ByteArrayInputStream(imagePrincipale));
    }
    
    public List<Image> getImages() {
        //  convert the list of byte arrays to a list of Image objects
        List<Image> imageList = new ArrayList<>();
        for (byte[] imageData : images) {
            imageList.add(new Image(new java.io.ByteArrayInputStream(imageData)));
        }
        return imageList;
    }
}
