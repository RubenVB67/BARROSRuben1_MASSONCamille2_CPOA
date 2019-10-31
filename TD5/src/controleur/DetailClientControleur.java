package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void valider(ActionEvent event) {

    }

}
