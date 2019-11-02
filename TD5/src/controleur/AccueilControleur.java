package controleur;


import java.net.URL;

import daofactory.DAOFactory;
import daofactory.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AccueilControleur {
	
	public static DAOFactory dao;

    @FXML
    private RadioButton rdb_mysql;

    @FXML
    private ToggleGroup mode;

    @FXML
    private RadioButton rdb_liste;

    @FXML
    private Button btn_abo;

    @FXML
    private Button btn_client;

    @FXML
    private Button btn_periodicite;

    @FXML
    private Button btn_revue;
  

    @FXML
    void modeListe(ActionEvent event) {
    	dao = DAOFactory.getDAOFactory(Persistance.Liste);

    }

    @FXML
    void modeSQL(ActionEvent event) {
    	dao = DAOFactory.getDAOFactory(Persistance.Mysql);
    }

    @FXML
    void redirigerAbonnement(ActionEvent event) {
    	if(rdb_mysql.isSelected() || rdb_liste.isSelected()) {
    		try {
    			Stage stage =(Stage) btn_abo.getScene().getWindow();
    	        stage.close(); 
    			
    	        Stage stage1 = new Stage();
				
				URL fxmlURL = getClass().getResource("../fenetre/VueAbonnement.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent root = fxmlLoader.load();
				Scene scene = new Scene(root);
				
				stage1.setScene(scene);
				stage1.setTitle("lol");
				stage1.show();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void redirigerClient(ActionEvent event) {
    	if(rdb_mysql.isSelected() || rdb_liste.isSelected()) {
    		try {
				 Stage stage1 = new Stage();
				
				 URL fxmlURL = getClass().getResource("../fenetre/Vueclient.fxml");
				 FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				 Parent root = fxmlLoader.load();
				 Scene scene = new Scene(root);
				
				 stage1.setScene(scene);
				 stage1.setTitle("lol");
				 stage1.show();
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   		}
    	}
    }

    @FXML
    void redirigerPeriodicite(ActionEvent event) {
    	if(rdb_mysql.isSelected() || rdb_liste.isSelected()) {
    		try {
				 Stage stage1 = new Stage();
				
				 URL fxmlURL = getClass().getResource("../fenetre/VuePeriodicite.fxml");
				 FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				 Parent root = fxmlLoader.load();
				 Scene scene = new Scene(root);
				
				 stage1.setScene(scene);
				 stage1.setTitle("lol");
				 stage1.show();
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   		}
    	}
    }

    @FXML
    void redirigerRevue(ActionEvent event) {
    	if(rdb_mysql.isSelected() || rdb_liste.isSelected()) {
    		try {
				 Stage stage1 = new Stage();
				
				 URL fxmlURL = getClass().getResource("../fenetre/VueRevue.fxml");
				 FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				 Parent root = fxmlLoader.load();
				 Scene scene = new Scene(root);
				
				 stage1.setScene(scene);
				 stage1.setTitle("lol");
				 stage1.show();
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   		}
    	}
    }

}
