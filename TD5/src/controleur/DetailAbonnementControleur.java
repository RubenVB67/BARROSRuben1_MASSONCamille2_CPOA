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
    private TextField txt_idclient;

    @FXML
    private TextField txt_idrevue;

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
    void modifier(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML
    void valider(ActionEvent event) {

    }

}