package controleur;

import java.net.URL;
import java.util.regex.Pattern;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.PeriodiciteIDAO;
import daoobjects.RevueIDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metiers.Client;
import metiers.Periodicite;
import metiers.Revue;

public class DetailRevueControleur {

    @FXML
    private Label lbl_tarif;

    @FXML
    private Label lbl_visuel;

    @FXML
    private Label lbl_description;

    @FXML
    private Label lbl_titre;

    @FXML
    private TextField txt_tarif;

    @FXML
    private TextField txt_visuel;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_titre;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_valider;

    @FXML
    private Label lbl_erreurtitre;

    @FXML
    private Label lbl_erreurdescription;

    @FXML
    private Label lbl_erreurvisuel;

    @FXML
    private Label lbl_erreurtarif;

    @FXML
    private Label lbl_erreurperio;


    @FXML
    private ComboBox<Periodicite> cbb_perio;
    
    private DAOFactory daof;
    private RevueIDAO rev;
    private PeriodiciteIDAO perio;
    
    @FXML
    public void initialize() {
    	
    	if(VueRevueControleur.mem != null) {
    		txt_titre.setText(VueRevueControleur.mem.getTitre());
    		txt_description.setText(VueRevueControleur.mem.getDescription());
    		txt_visuel.setText(VueRevueControleur.mem.getVisuel());
    		this.cbb_perio.setItems(FXCollections.observableArrayList(perio.findAll()));
    	}
    }
    
    @FXML
    void retour(ActionEvent event) {
    	try {
			Stage stage =(Stage) btn_retour.getScene().getWindow();
			stage.close(); 
			
			Stage stage1 = new Stage();
			
			URL fxmlURL = getClass().getResource("../fenetre/VueRevue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			
			stage1.setScene(scene);
			stage1.setTitle("Toutes les revues");
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
    void valider(ActionEvent valider) {
    	boolean error = false;
    	
    	if (txt_titre.getText().trim().equals("")) {
    		error = true;
    		lbl_erreurtitre.setVisible(true);
    	}else {
    		lbl_erreurtitre.setVisible(false);
    	}
    	
    	if(txt_description.getText().trim().equals("")){
    		error = true;
    		lbl_erreurdescription.setVisible(true);
    	}else {
    		lbl_erreurdescription.setVisible(false);
    	}
    	
    	if(txt_visuel.getText().trim().equals("")){
    		error = true;
    		lbl_erreurvisuel.setVisible(true);
    	}else {
    		lbl_erreurvisuel.setVisible(false);
    	}
    	
    	if(txt_tarif.getText().trim().equals("")){
    		error = true;
    		lbl_erreurtarif.setVisible(true);
    	}else {
    		lbl_erreurtarif.setVisible(false);
    	}
    	
    	
    	if ( !error ) {
    		Revue rev = new Revue(
    								txt_titre.getText().trim(),
    								txt_description.getText().trim(),
    								txt_visuel.getText().trim(),
    								txt_tarif.getText().trim()
    								);
    		
    		if(VueRevueControleur.mem == null)
    			AccueilControleur.dao.getRevueDAO().create(rev);
    		else {
    			rev.setId_revue( VueRevueControleur.mem.getId_revue() );
    			AccueilControleur.dao.getRevueDAO().update(rev);
    		}
    		
    		try {
    			Stage stage =(Stage) btn_valider.getScene().getWindow();
    			stage.close(); 
    			
    			Stage stage1 = new Stage();
    			
    			URL fxmlURL = getClass().getResource("../fenetre/VueRevue.fxml");
    			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    			Parent root = fxmlLoader.load();
    			Scene scene = new Scene(root);
    			
    			stage1.setScene(scene);
    			stage1.setTitle("Tous les Revues");
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

