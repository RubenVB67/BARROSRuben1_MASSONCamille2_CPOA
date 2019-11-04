package controleur;

import java.net.URL;

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
    private ComboBox<?> cbb_id_client;

    @FXML
    private ComboBox<?> cbb_id_revue;

    @FXML
    public void initialize() {
    	
    	
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
