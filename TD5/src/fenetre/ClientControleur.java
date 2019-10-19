package fenetre;

import java.awt.event.ActionEvent;

import daofactory.DAOFactory;
import daofactory.Persistance;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ClientControleur {

	@FXML
    private GridPane grp_saisieclient;

    @FXML
    private Label lbl_nom;

    @FXML
    private Label lbl_prenom;

    @FXML
    private Label lbl_norue;

    @FXML
    private Label lbl_voie;

    @FXML
    private Label lbl_codepostal;

    @FXML
    private Label lbl_ville;

    @FXML
    private Label lbl_pays;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_numerorue;

    @FXML
    private TextField txt_voie;

    @FXML
    private TextField txt_codepostal;

    @FXML
    private TextField txt_ville;

    @FXML
    private TextField txt_pays;

    @FXML
    private Label lbl_erreurnom;

    @FXML
    private Label lbl_erreurprenom;

    @FXML
    private Label lbl_erreurnumerorue;

    @FXML
    private Label lbl_erreurvoie;

    @FXML
    private Label lbl_erreurcodepostal;

    @FXML
    private Label lbl_erreurville;

    @FXML
    private Label lbl_erreurpays;

    @FXML
    private Label lbl_champsvides;

    @FXML
    private FlowPane flp_bouton;

    @FXML
    private Button btn_creer;

    @FXML
    private FlowPane flw_affich;

    @FXML
    private RadioButton rdb_mysql;

    @FXML
    private RadioButton rdb_liste;

    @FXML
    private Label lbl_affichage;

    private DAOFactory dao;
  
    @FXML
    void creerModele(ActionEvent event) {

    }
    

    @FXML
	private void initialize() {
		this.dao = DAOFactory.getDAOFactory(Persistance.Liste);
	}
    void supprimer()
    {
    	this.lbl_champsvides.setVisible(false);
		this.lbl_erreurnom.setVisible(false);
		this.lbl_erreurprenom.setVisible(false);
		this.lbl_erreurnumerorue.setVisible(false);
		this.lbl_erreurvoie.setVisible(false);
		this.lbl_erreurcodepostal.setVisible(false);
		this.lbl_erreurville.setVisible(false);
		this.lbl_erreurpays.setVisible(false);
		this.lbl_affichage.setText("");
		
		this.txt_nom.clear();
		this.txt_prenom.clear();
		this.txt_numerorue.clear();
		this.txt_voie.clear();
		this.txt_codepostal.clear();
		this.txt_ville.clear();
		this.txt_pays.clear();
    }
    
    boolean texteSeulement(String texte) {
		texte = texte.replace("é", "e");
		texte = texte.replace("ô", "o");
		texte = texte.replace("ï", "i");
		if (!texte.matches("[a-zA-z\\s]*"))
			return false;
		else
			return true;
	}

	// Renvois vrai si il y a un élément vide
	boolean champVide() {
		return this.txt_nom.getText().isEmpty() || this.txt_prenom.getText().isEmpty()
				|| this.txt_numerorue.getText().isEmpty() || this.txt_voie.getText().isEmpty() || this.txt_codepostal.getText().isEmpty()
				|| this.txt_ville.getText().isEmpty() || this.txt_pays.getText().isEmpty();
	}
    
    @FXML
	void Liste() {
		this.dao = DAOFactory.getDAOFactory(Persistance.Liste);
		supprimer();
	}

	@FXML
	void SQL() {
		this.dao = DAOFactory.getDAOFactory(Persistance.Mysql);
		supprimer();
	}

}
