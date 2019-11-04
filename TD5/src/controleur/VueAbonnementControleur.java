package controleur;

import java.net.URL;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metiers.Abonnement;

public class VueAbonnementControleur {
	
	public static Abonnement memoire;

    @FXML
    private TableView<Abonnement> tbl_abonnement;
    
    @FXML
    private TableColumn<Abonnement, Integer> col_id_client;

    @FXML
    private TableColumn<Abonnement, Integer> col_id_revue;

    @FXML
    private TableColumn<Abonnement, LocalDate> col_d_deb;

    @FXML
    private TableColumn<Abonnement, LocalDate> col_d_fin;
    
    @FXML
    private Button btn_creer_abo;

    @FXML
    private Button btn_modifier_abo;

    @FXML
    private Button btn_supp_abo;

    @FXML
    private Button btn_retour;

    @FXML
    private CheckBox chk_encours;
    
    @FXML
    public void initialize() {
    	col_id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
    	col_id_revue.setCellValueFactory(new PropertyValueFactory<>("id_revue"));
    	col_d_deb.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
    	col_d_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
    	
    	this.tbl_abonnement.setItems( this.getAbonnement() );
    }

    @FXML
    void aboEnCours(ActionEvent event) {
    	this.tbl_abonnement.setItems( this.getAbonnement() );
    }

    @FXML
    void creerAbo(ActionEvent event) {
    	this.memoire = null;
    	try {
			Stage stage =(Stage) btn_creer_abo.getScene().getWindow();
	        stage.close(); 
			
	        Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/DetailAbonnement.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Creer Abonnement");
			stage1.show();
		} catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_creer_abo.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
		}
    }

    @FXML
    void modifierAbo(ActionEvent event) {
    	if(tbl_abonnement.getSelectionModel().getSelectedItem() != null) {
	    	this.memoire = tbl_abonnement.getSelectionModel().getSelectedItem();
	    	System.out.println(memoire); // test a supp
	    	
	    	try {
				Stage stage =(Stage) btn_modifier_abo.getScene().getWindow();
		        stage.close(); 
				
		        Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/DetailAbonnement.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Modifier Abonnement");
				stage1.show();
			} catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
	            alert.initOwner(btn_modifier_abo.getScene().getWindow());
	            alert.setTitle("ERREUR");
	            alert.setHeaderText("erreur survenue :");
	            alert.setContentText(e.toString());
	            alert.showAndWait();
			}
    	} else {
    		Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_modifier_abo.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Abonnement selectionne");
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
  			e.printStackTrace();
  		}
    }

    @FXML
    void suppAbo(ActionEvent event) {
    	if(tbl_abonnement.getSelectionModel().getSelectedItem() != null) {
	    	this.memoire = tbl_abonnement.getSelectionModel().getSelectedItem();
	    	System.out.println(memoire); // test a supp
	    	
	    	AccueilControleur.dao.getAbonnementDAO().delete(memoire);
	    	
	    	this.tbl_abonnement.setItems( this.getAbonnement() );
	    	
    	} else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supp_abo.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Abonnement selectionne");
            alert.showAndWait();
		}
    }
    
    ObservableList<Abonnement> getAbonnement() {
    	ObservableList<Abonnement> list = FXCollections.observableArrayList();
    	if (chk_encours.isSelected())
    		list.addAll(AccueilControleur.dao.getAbonnementDAO().enCours());
    	else
        	list.addAll(AccueilControleur.dao.getAbonnementDAO().findAll());

    	return list;
    }

}
