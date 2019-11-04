package controleur;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metiers.Client;
import metiers.Periodicite;

public class DetailPeriodiciteControleur {

    @FXML
    private Button btn_retour;
    

    @FXML
    private TextField txt_libelle;

    @FXML
    private Label lbl_libelle;


    @FXML
    private Button btn_valider;

    @FXML
    private Label lbl_erreurlibelle;

    @FXML
    void retour(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_retour.getScene().getWindow();
			stage.close(); 
			
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/VuePeriodicite.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Toutes les Periodicite");
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
    public void initialize() {
    	
    	if(VuePeriodiciteControleur.per != null) {
    		txt_libelle.setText(VuePeriodiciteControleur.per.getLibelle());
    	}
    }

    @FXML
    void valider(ActionEvent event) {
boolean error = false;
    	
    	if (txt_libelle.getText().trim().equals("")) {
    		error = true;
    		lbl_erreurlibelle.setVisible(true);
    	}else {
    		lbl_erreurlibelle.setVisible(false);
    	}
    	
    	
    	if ( !error ) {
    		Periodicite perio = new Periodicite(
    								txt_libelle.getText().trim()
    								);
    		
    		if(VueClientControleur.memoire == null)
    			AccueilControleur.dao.getPeriodiciteDAO().create(perio);
    		else {
    			perio.setId( VueClientControleur.memoire.getId() );
    			AccueilControleur.dao.getPeriodiciteDAO().update(perio);
    		}
    		
    		try {
    			Stage stage =(Stage) btn_valider.getScene().getWindow();
    			stage.close(); 
    			
    			Stage stage1 = new Stage();
    			
    			URL fxmlURL = getClass().getResource("../fenetre/VuePeriodicite.fxml");
    			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    			Parent root = fxmlLoader.load();
    			Scene scene = new Scene(root);
    			
    			stage1.setScene(scene);
    			stage1.setTitle("Toutes les Periodicite");
    			stage1.show();
       		} catch (Exception e) {
       			Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.initOwner(btn_valider.getScene().getWindow());
                alert.setTitle("ERREUR");
                alert.setHeaderText("erreur survenue :");
                alert.setContentText(e.toString());
                alert.showAndWait();
       		}
		}
    }

}