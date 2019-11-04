package controleur;

import java.net.URL;

import daofactory.DAOFactory;
import daoobjects.PeriodiciteIDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import metiers.Periodicite;

public class VuePeriodiciteControleur {

    @FXML
    private Pane pnl_center;

    @FXML
    private TableView<Periodicite> tbl_periodicite;

    @FXML
    private TableColumn<Periodicite, Integer> col_perioidperio;

    @FXML
    private TableColumn<Periodicite, String> col_libelle;

    @FXML
    private Button btn_supprimer;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_creer;

    @FXML
    private Button btn_retour;
    
    public boolean creer = false;
    private DAOFactory daof;
    private PeriodiciteIDAO perio; 

    @FXML
    void creerPeriodicite(ActionEvent event) {
    	creer = true;
    	try {
			URL fxmlURL = getClass().getResource("/fenetre/DetailPeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Création d'une periodicité");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void modifierPeriodicite(ActionEvent event) {
    	creer = false;
    	try {
			URL fxmlURL = getClass().getResource("/fenetre/DetailPeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Modification d'une periodicité");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void retourAccueil(ActionEvent event) {
    	Stage stage = (Stage) btn_retour.getScene().getWindow();
        stage.close();
    }

    @FXML
    void supprimerPeriodicite(ActionEvent event) {
    	try {
			URL fxmlURL = getClass().getResource("/fenetre/Supprimer.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Suppression d'une periodicité");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}