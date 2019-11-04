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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import metiers.Abonnement;
import metiers.Client;
import metiers.Revue;

public class DetailAbonnementControleur {

    @FXML
    private Pane pnl_detailabo;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_valider;

    @FXML
    private Label lbl_erreuridclient;

    @FXML
    private Label lbl_erreuridrevue;

    @FXML
    private Label lbl_erreurdatedebut;

    @FXML
    private Label lbl_erreurdatefin;

    @FXML
    private DatePicker dtp_datedebut;

    @FXML
    private DatePicker dtp_datefin;

    @FXML
    private ComboBox<Client> cbb_id_client;

    @FXML
    private ComboBox<Revue> cbb_id_revue;

    @FXML
    public void initialize() {
    	
    	cbb_id_client.setItems( getClient() );
    	cbb_id_revue.setItems( getRevue() );
    	
    	if(VueAbonnementControleur.memoire != null) {
    		cbb_id_client.setDisable(true);
    		cbb_id_revue.setDisable(true);
    		
    		cbb_id_client.setValue( AccueilControleur.dao.getClientDAO().getById(
    				VueAbonnementControleur.memoire.getId_client()) );
    		cbb_id_revue.setValue( AccueilControleur.dao.getRevueDAO().getById(
    				VueAbonnementControleur.memoire.getId_revue()) );
    		dtp_datedebut.setValue( VueAbonnementControleur.memoire.getDate_debut() );
    		dtp_datefin.setValue( VueAbonnementControleur.memoire.getDate_fin() );
    	}
    	
    }
    
    @FXML
    void retour(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_retour.getScene().getWindow();
			stage.close(); 
			
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/VueAbonnement.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Tous les Abonnements");
			stage1.show();
   		} catch (Exception e) {
   			Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.initOwner(btn_retour.getScene().getWindow());
            alert.setTitle("ERREUR");
            alert.setHeaderText("erreur survenue :");
            alert.setContentText(e.toString());
            alert.showAndWait();
   		}
    }

    @FXML
    void valider(ActionEvent event) {
    	boolean error = false;
    	
    	if(cbb_id_client.getValue() == null){
    		error = true;
    		lbl_erreuridclient.setVisible(true);
    	}else {
    		lbl_erreuridclient.setVisible(false);
    	}
    	
    	if(cbb_id_revue.getValue() == null){
    		error = true;
    		lbl_erreuridrevue.setVisible(true);
    	}else {
    		lbl_erreuridrevue.setVisible(false);
    	}
    	
    	if(dtp_datedebut.getValue() == null){
    		error = true;
    		lbl_erreurdatedebut.setVisible(true);
    	}else {
    		lbl_erreurdatedebut.setVisible(false);
    	}
    	
    	if(dtp_datefin.getValue() == null){
    		error = true;
    		lbl_erreurdatefin.setVisible(true);
    	}else {
    		lbl_erreurdatefin.setVisible(false);
    	}
    	
    	if ( !error ) {
    		Abonnement abo = new Abonnement(
    				cbb_id_client.getValue().getId(),
    				cbb_id_revue.getValue().getId_revue(),
    				dtp_datedebut.getValue(),
    				dtp_datefin.getValue()
					);
    		
    		if (VueAbonnementControleur.memoire == null) {
				AccueilControleur.dao.getAbonnementDAO().create(abo);
			} else {
				AccueilControleur.dao.getAbonnementDAO().update(abo);
			}
    		
	    	try {
				Stage stage =(Stage) btn_retour.getScene().getWindow();
				stage.close(); 
				
				Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/VueAbonnement.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("Tous les Abonnements");
				stage1.show();
	   		} catch (Exception e) {
	   			Alert alert=new Alert(Alert.AlertType.ERROR);
	            alert.initOwner(btn_retour.getScene().getWindow());
	            alert.setTitle("ERREUR");
	            alert.setHeaderText("erreur survenue :");
	            alert.setContentText(e.toString());
	            alert.showAndWait();
	   		}
    	}
    }
 
    ObservableList<Client> getClient() {
    	ObservableList<Client> list = FXCollections.observableArrayList();
        list.addAll(AccueilControleur.dao.getClientDAO().findAll());

    	return list;
    }
    
    ObservableList<Revue> getRevue() {
    	ObservableList<Revue> list = FXCollections.observableArrayList();
        list.addAll(AccueilControleur.dao.getRevueDAO().findAll());

    	return list;
    }

}
