package controleur;

import java.net.URL;
import java.util.List;

import daofactory.Connexion;
import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.RevueIDAO;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import metiers.Periodicite;
import metiers.Revue;

public class VueRevueControleur {

    @FXML
    private TableView<Revue> tbl_revue;
    
    @FXML
    private TableColumn<Revue,Integer> col_revidrev;

    @FXML
    private TableColumn<Revue, Integer> col_revidperio;

    @FXML
    private TableColumn<Revue, String> col_titre;

    @FXML
    private TableColumn<Revue, String> col_description;

    @FXML
    private TableColumn<Revue, String> col_visuel;

    @FXML
    private TableColumn<Revue, Double> col_tarif;

    @FXML
    private Button btn_creer;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_supprimer;

    @FXML
    private Button btn_retour;
    
    @FXML
    private Label lbl_perio;
    
    @FXML
    private Label lbl_aucunchamp;
    
    public boolean creer = false;
    private DAOFactory daof;
    private RevueIDAO rev;
    
    public void initialize() {
		this.daof = DAOFactory.getDAOFactory(Persistance.Liste);
		rev = this.daof.getRevueDAO();
        col_revidrev.setCellValueFactory(new PropertyValueFactory<>("Id_revue"));
        col_revidperio.setCellValueFactory(new PropertyValueFactory<>("Id_periodicite"));
        col_titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        col_visuel.setCellValueFactory(new PropertyValueFactory<>("Visuel"));
        col_tarif.setCellValueFactory(new PropertyValueFactory<>("Tarif_numero"));
		tbl_revue.setItems(FXCollections.observableArrayList(rev.findAll()));
    }

    @FXML
    void creerRevue(ActionEvent event) {
    	creer = true;
    	try {
			URL fxmlURL = getClass().getResource("/fenetre/DetailRevue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Création d'une revue");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void modifierRevue(ActionEvent event) {
    	creer = false;
    		try {
    			URL fxmlURL = getClass().getResource("/fenetre/DetailRevue.fxml");
    			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    			Parent root = fxmlLoader.load();
    			Stage stage = new Stage();
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.setTitle("Modification d'une revue");
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
    void supprimerRevue(ActionEvent event) {
    	try {
			URL fxmlURL = getClass().getResource("/fenetre/Supprimer.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Suppression d'une revue");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

