package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import metiers.Revue;

public class VueRevueControleur {

    @FXML
    private TableView<Revue> tbl_revue;

    @FXML
    private Button btn_abonnement;

    @FXML
    private Button btn_client;

    @FXML
    private Button btn_periodicite;

    @FXML
    private RadioButton rdb_sql;

    @FXML
    private RadioButton rdb_liste;

    @FXML
    void redirigerAbonnement(ActionEvent event) {

    }

    @FXML
    void redirigerClient(ActionEvent event) {

    }

    @FXML
    void redirigerPeriodicite(ActionEvent event) {

    }

}