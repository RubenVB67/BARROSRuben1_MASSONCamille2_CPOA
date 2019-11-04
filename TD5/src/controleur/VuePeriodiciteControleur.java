package controleur;

import java.net.URL;

import daofactory.DAOFactory;
import daoobjects.PeriodiciteIDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import metiers.Periodicite;
import metiers.Revue;

public class VuePeriodiciteControleur {
	
	static Periodicite per;

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

    public void initialize() {
        col_perioidperio.setCellValueFactory(new PropertyValueFactory<>("id_periodicite"));
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    	this.tbl_periodicite.setItems(FXCollections.observableArrayList(AccueilControleur.dao.getPeriodiciteDAO().findAll()));
    }
    
    @FXML
    void creerPeriodicite(ActionEvent event) {
    	this.per = null;
    	try {
			Stage stage =(Stage) btn_creer.getScene().getWindow();
	        stage.close(); 
			
	        Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/DetailPeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Creer Periodicite");
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
    void modifierPeriodicite(ActionEvent event) {
    	if(tbl_periodicite.getSelectionModel().getSelectedItem() != null) {
	    	this.per = tbl_periodicite.getSelectionModel().getSelectedItem();
	    	System.out.println(per); // test a supp
	    	
	    	try {
				Stage stage =(Stage) btn_modifier.getScene().getWindow();
		        stage.close(); 
				
		        Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/DetailPeriodicite.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Modifier Periodicite");
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
            alert.setHeaderText("Aucune Periodicite selectionne");
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
    void supprimerPeriodicite(ActionEvent event) {
    	if(tbl_periodicite.getSelectionModel().getSelectedItem() != null) {
	    	this.per = tbl_periodicite.getSelectionModel().getSelectedItem();
	    	System.out.println(per); // test a supp
	    	
	    	AccueilControleur.dao.getPeriodiciteDAO().delete(per);
	    	
	    	this.tbl_periodicite.setItems(FXCollections.observableArrayList(AccueilControleur.dao.getPeriodiciteDAO().findAll()));
	    	
    	} else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supprimer.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Periodicite selectionne");
            alert.showAndWait();
		}
    }
    ObservableList<Periodicite> getPeriodicite() {
    	ObservableList<Periodicite> list = FXCollections.observableArrayList();
    	list.addAll(AccueilControleur.dao.getPeriodiciteDAO().findAll());
    
    	return list;
    }

}