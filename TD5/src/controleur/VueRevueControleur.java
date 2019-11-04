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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import metiers.Client;
import metiers.Periodicite;
import metiers.Revue;

public class VueRevueControleur {

	static Revue mem;
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
        col_revidrev.setCellValueFactory(new PropertyValueFactory<>("Id_revue"));
        col_revidperio.setCellValueFactory(new PropertyValueFactory<>("Id_periodicite"));
        col_titre.setCellValueFactory(new PropertyValueFactory<>("Titre"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        col_visuel.setCellValueFactory(new PropertyValueFactory<>("Visuel"));
        col_tarif.setCellValueFactory(new PropertyValueFactory<>("Tarif_numero"));
    	this.tbl_revue.setItems(FXCollections.observableArrayList(AccueilControleur.dao.getRevueDAO().findAll()));
    }

    @FXML
    void creerRevue(ActionEvent event) {
    	this.mem = null;
    	try {
			Stage stage =(Stage) btn_creer.getScene().getWindow();
	        stage.close(); 
			
	        Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/DetailRevue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Creer Revue");
			stage1.show();
		} catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_creer.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
		}
    }

    @FXML
    void modifierRevue(ActionEvent event) {
    	if(tbl_revue.getSelectionModel().getSelectedItem() != null) {
	    	this.mem = tbl_revue.getSelectionModel().getSelectedItem();
	    	System.out.println(mem); // test a supp
	    	
	    	try {
				Stage stage =(Stage) btn_modifier.getScene().getWindow();
		        stage.close(); 
				
		        Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/DetailRevue.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Modifier Revue");
				stage1.show();
			} catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
	            alert.initOwner(btn_modifier.getScene().getWindow());
	            alert.setTitle("ERREUR");
	            alert.setHeaderText("erreur survenue :");
	            alert.setContentText(e.toString());
	            alert.showAndWait();
			}
    	} else {
    		Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_modifier.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucune Revue selectionne");
            alert.showAndWait();
		}
    }

    @FXML
    void retourAccueil(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_retour.getScene().getWindow();
			stage.close(); 
			
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/Accueil.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Accueil");
			stage1.show();
  		} catch (Exception e) {
  			Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supprimer.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
  		}
    }

    @FXML
    void supprimerRevue(ActionEvent event) {
    	if(tbl_revue.getSelectionModel().getSelectedItem() != null) {
	    	this.mem = tbl_revue.getSelectionModel().getSelectedItem();
	    	System.out.println(mem); // test a supp
	    	
	    	AccueilControleur.dao.getRevueDAO().delete(mem);
	    	
	    	this.tbl_revue.setItems(FXCollections.observableArrayList(AccueilControleur.dao.getRevueDAO().findAll()));
	    	
    	} else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supprimer.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Revue selectionne");
            alert.showAndWait();
		}
	}
    ObservableList<Revue> getRevue() {
    	ObservableList<Revue> list = FXCollections.observableArrayList();
    	list.addAll(AccueilControleur.dao.getRevueDAO().findAll());
    
    	return list;
    }
}

