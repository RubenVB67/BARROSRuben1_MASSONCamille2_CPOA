package controleur;

import java.net.URL;

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
import javafx.stage.Stage;
import metiers.Client;

public class VueClientControleur {
	
	public static Client memoire;
	
	public static Client memoirebis;

    @FXML
    private TableView<Client> tbl_client;
    
    @FXML
    private TableColumn<Client, Integer> col_id_client;

    @FXML
    private TableColumn<Client, String> col_nom;

    @FXML
    private TableColumn<Client, String> col_prenom;

    @FXML
    private TableColumn<Client, String> col_rue;

    @FXML
    private TableColumn<Client, String> col_voie;

    @FXML
    private TableColumn<Client, String> col_cp;

    @FXML
    private TableColumn<Client, String> col_ville;

    @FXML
    private TableColumn<Client, String> col_pays;

    @FXML
    private Button btn_creer_client;

    @FXML
    private Button btn_modifier_client;

    @FXML
    private Button btn_supp_client;

    @FXML
    private Button btn_return;
    
    @FXML
    private Button btn_abo;

    @FXML
    void affiche_Abo(ActionEvent event) {
    	if(tbl_client.getSelectionModel().getSelectedItem() != null) {
	    	this.memoirebis = tbl_client.getSelectionModel().getSelectedItem();
	    	
	    	try {
				Stage stage =(Stage) btn_abo.getScene().getWindow();
				stage.close(); 
				
				Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/VueAbonnement.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Liste des Abonnements de "+memoirebis.getPrenom()+" "+memoirebis.getNom());
				stage1.show();
	  		} catch (Exception e) {
	  			Alert alert=new Alert(Alert.AlertType.ERROR);
	            alert.initOwner(btn_supp_client.getScene().getWindow());
	            alert.setTitle("ERREUR");
	            alert.setHeaderText("erreur survenue :");
	            alert.setContentText(e.toString());
	            alert.showAndWait();
	  		}
    	} else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supp_client.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Client selectionne");
            alert.showAndWait();
		}
    }
    
	@FXML
    public void initialize() {
		memoirebis = null;
		
    	col_id_client.setCellValueFactory(new PropertyValueFactory<>("id_client"));
    	col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    	col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    	col_rue.setCellValueFactory(new PropertyValueFactory<>("no_rue"));
    	col_voie.setCellValueFactory(new PropertyValueFactory<>("voie"));
    	col_cp.setCellValueFactory(new PropertyValueFactory<>("code_postal"));
    	col_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
    	col_pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
    	
        
        this.tbl_client.setItems( this.getClient() );
        
    }

    @FXML
    void client_Supp(ActionEvent event) {
    	if(tbl_client.getSelectionModel().getSelectedItem() != null) {
	    	this.memoire = tbl_client.getSelectionModel().getSelectedItem();
	    	System.out.println(memoire); // test a supp
	    	
	    	AccueilControleur.dao.getClientDAO().delete(memoire);
	    	
	    	this.tbl_client.setItems(FXCollections.observableArrayList(AccueilControleur.dao.getClientDAO().findAll()));
	    	
    	} else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_supp_client.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Client selectionne");
            alert.showAndWait();
		}
    }

    @FXML
    void creerClient(ActionEvent event) {
    	this.memoire = null;
    	try {
			Stage stage =(Stage) btn_creer_client.getScene().getWindow();
	        stage.close(); 
			
	        Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/DetailClient.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Creer Client");
			stage1.show();
		} catch (Exception e) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_creer_client.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
		}
    }

    @FXML
    void modifierClient(ActionEvent event) {
    	if(tbl_client.getSelectionModel().getSelectedItem() != null) {
	    	this.memoire = tbl_client.getSelectionModel().getSelectedItem();
	    	System.out.println(memoire); // test a supp
	    	
	    	try {
				Stage stage =(Stage) btn_modifier_client.getScene().getWindow();
		        stage.close(); 
				
		        Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/DetailClient.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Modifier Client");
				stage1.show();
			} catch (Exception e) {
				Alert alert=new Alert(Alert.AlertType.ERROR);
	            alert.initOwner(btn_modifier_client.getScene().getWindow());
	            alert.setTitle("ERREUR");
	            alert.setHeaderText("erreur survenue :");
	            alert.setContentText(e.toString());
	            alert.showAndWait();
			}
    	} else {
    		Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_modifier_client.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("Aucun Client selectionne");
            alert.showAndWait();
		}
    }

    @FXML
    void retour_Accueil(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_return.getScene().getWindow();
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
            alert.initOwner(btn_supp_client.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
  		}
    }
    
    ObservableList<Client> getClient() {
    	ObservableList<Client> list = FXCollections.observableArrayList();
    	list.addAll(AccueilControleur.dao.getClientDAO().findAll());
    	
    	return list;
    }

}
