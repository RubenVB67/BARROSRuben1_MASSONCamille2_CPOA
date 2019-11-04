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

public class DetailClientControleur {

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_valider;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_numeroderue;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_voie;

    @FXML
    private TextField txt_cp;

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_pays;

    @FXML
    private Label lbl_erreurnom;

    @FXML
    private Label lbl_erreurprenom;

    @FXML
    private Label lbl_erreurnumeroderue;

    @FXML
    private Label lbl_erreurvoie;

    @FXML
    private Label lbl_erreurcodepostal;

    @FXML
    private Label lbl_erreurville;

    @FXML
    private Label lbl_erreurpays;

    @FXML
    void retour(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_retour.getScene().getWindow();
			stage.close(); 
			
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/Vueclient.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Tous les Clients");
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
    	
    	if(VueClientControleur.memoire != null) {
    		txt_nom.setText(VueClientControleur.memoire.getNom());
    		txt_prenom.setText(VueClientControleur.memoire.getPrenom());
    		txt_numeroderue.setText(VueClientControleur.memoire.getNo_rue());
    		txt_voie.setText(VueClientControleur.memoire.getVoie());
    		txt_cp.setText(VueClientControleur.memoire.getCode_postal());
    		txt_ville.setText(VueClientControleur.memoire.getVille());
    		txt_pays.setText(VueClientControleur.memoire.getPays());
    	}
    }
    
    @FXML
    void valider(ActionEvent event) {
    	boolean error = false;
    	
    	if (txt_nom.getText().trim().equals("")) {
    		error = true;
    		lbl_erreurnom.setVisible(true);
    	}else {
    		lbl_erreurnom.setVisible(false);
    	}
    	
    	if(txt_prenom.getText().trim().equals("")){
    		error = true;
    		lbl_erreurprenom.setVisible(true);
    	}else {
    		lbl_erreurprenom.setVisible(false);
    	}
    	
    	if(txt_numeroderue.getText().trim().equals("")){
    		error = true;
    		lbl_erreurnumeroderue.setVisible(true);
    	}else {
    		lbl_erreurnumeroderue.setVisible(false);
    	}
    	
    	if(txt_voie.getText().trim().equals("")){
    		error = true;
    		lbl_erreurvoie.setVisible(true);
    	}else {
    		lbl_erreurvoie.setVisible(false);
    	}
    	
    	if(txt_cp.getText().trim().equals("")){
    		error = true;
    		lbl_erreurcodepostal.setVisible(true);
    	}else {
    		lbl_erreurcodepostal.setVisible(false);
    	}
    	
    	if(txt_ville.getText().trim().equals("")){
    		error = true;
    		lbl_erreurville.setVisible(true);
    	}else {
    		lbl_erreurville.setVisible(false);
    	}
    	
    	if(txt_pays.getText().trim().equals("")){
    		error = true;
    		lbl_erreurpays.setVisible(true);
    	}else {
    		lbl_erreurpays.setVisible(false);
    	}
    	
    	
    	if ( !error ) {
    		Client cli = new Client(
    								txt_nom.getText().trim(),
    								txt_prenom.getText().trim(),
    								txt_numeroderue.getText().trim(),
    								txt_voie.getText().trim(),
    								txt_cp.getText().trim(),
    								txt_ville.getText().trim(),
    								txt_pays.getText().trim()
    								);
    		
    		if(VueClientControleur.memoire == null)
    			AccueilControleur.dao.getClientDAO().create(cli);
    		else {
    			cli.setId( VueClientControleur.memoire.getId() );
    			AccueilControleur.dao.getClientDAO().update(cli);
    		}
    		
    		try {
    			Stage stage =(Stage) btn_valider.getScene().getWindow();
    			stage.close(); 
    			
    			Stage stage1 = new Stage();
    			
    			URL fxmlURL = getClass().getResource("../fenetre/Vueclient.fxml");
    			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    			Parent root = fxmlLoader.load();
    			Scene scene = new Scene(root);
    			
    			stage1.setScene(scene);
    			stage1.setTitle("Tous les Clients");
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
