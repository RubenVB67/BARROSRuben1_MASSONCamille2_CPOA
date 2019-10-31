package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import metiers.Periodicite;

public class VuePeriodiciteControleur {

    @FXML
    private Pane pnl_center;

    @FXML
    private TableView<Periodicite> tbl_periodicite;

    @FXML
    private Pane pnl_top;

    @FXML
    private RadioButton rdb_sql;

    @FXML
    private RadioButton rdb_liste;

    @FXML
    private Button btn_client;

    @FXML
    private Button btn_abonnement;

    @FXML
    private Button btn_revue;

    @FXML
    void redirigerAbonnement(ActionEvent event) {

    }

    @FXML
    void redirigerClient(ActionEvent event) {

    }

    @FXML
    void redirigerRevue(ActionEvent event) {

    }

}