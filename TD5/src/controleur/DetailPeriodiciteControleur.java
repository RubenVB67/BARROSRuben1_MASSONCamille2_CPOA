package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DetailPeriodiciteControleur {

    @FXML
    private Button btn_retour;

    @FXML
    private Label lbl_libelle;

    @FXML
    private TextField txt_idperiodicite;

    @FXML
    private Button btn_valider;

    @FXML
    private Label lbl_erreurlibelle;

    @FXML
    void retour(ActionEvent event) {
    	Stage stage = (Stage) btn_retour.getScene().getWindow();
        stage.close();
    }

    @FXML
    void valider(ActionEvent event) {
    	
    }

}