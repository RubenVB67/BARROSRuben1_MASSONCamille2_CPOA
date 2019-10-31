package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DetailAbonnementControleur {

    @FXML
    private Pane pnl_detailabo;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_valider;

    @FXML
    private TextField lbl_idclient;

    @FXML
    private TextField lbl_idrevue;

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
    void Valider(ActionEvent event) {
    	lbl_idclient.setEditable(false);
    	lbl_idrevue.setEditable(false);
    	dtp_datedebut.setEditable(false);
    	dtp_datefin.setEditable(false);
    }

    @FXML
    void modifier(ActionEvent event) {
    	lbl_idclient.setEditable(true);
    	lbl_idrevue.setEditable(true);
    	dtp_datedebut.setEditable(true);
    	dtp_datefin.setEditable(true);
    }

    @FXML
    void retour(ActionEvent event) {
    	
    }

}