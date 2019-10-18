package fenetre;

import metiers.Periodicite;
import metiers.Revue;

import java.util.regex.Pattern;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.PeriodiciteIDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RevueControleur{

	@FXML
    private VBox vbx_gestionrevues;

    @FXML
    private GridPane grp_saisierevue;

    @FXML
    private Label lbl_titre;

    @FXML
    private Label lbl_description;

    @FXML
    private Label lbl_tarif;

    @FXML
    private Label lbl_eurosaunumero;

    @FXML
    private Label lbl_periodicite;

    @FXML
    private TextField txt_titre;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_tarif;

    @FXML
    private ComboBox<Periodicite> cbx_periodicite;

    @FXML
    private FlowPane flp_bouton;

    @FXML
    private Button btn_creer;

    @FXML
    private FlowPane flp_affich;

    @FXML
    private Label lbl_affichage;
    
    @FXML
    private Label lbl_erreurtitre;

    @FXML
    private Label lbl_erreurdescription;

    @FXML
    private Label lbl_erreurtarif;

    @FXML
    private Label lbl_erreurperio;
    
    @FXML
    private Label lbl_champsvides;
    
    @FXML
    private RadioButton rdb_sql;

    @FXML
    private RadioButton rdb_liste;
    
    private PeriodiciteIDAO periodao;
    private DAOFactory dao;

    @FXML
	private void initialize() {
		this.dao = DAOFactory.getDAOFactory(Persistance.Liste);
		periodao = this.dao.getPeriodiciteDAO();
		this.cbx_periodicite.setItems(FXCollections.observableArrayList(periodao.findAll()));
	}

	@FXML
	void supprimer() {
		this.lbl_champsvides.setVisible(false);
		this.lbl_erreurdescription.setVisible(false);
		this.lbl_erreurperio.setVisible(false);
		this.lbl_erreurtarif.setVisible(false);
		this.lbl_erreurtitre.setVisible(false);
		this.lbl_affichage.setText("");
		this.cbx_periodicite.getSelectionModel().clearSelection();
		this.txt_description.clear();
		this.txt_tarif.clear();
		this.txt_titre.clear();
		
		periodao = this.dao.getPeriodiciteDAO();
	}

	@FXML
	void afficher() {
		Revue rev = null;
		if (!champVide()) {
			if (champCorrecte()) {
				rev = new Revue(this.txt_titre.getText().trim(), this.txt_description.getText().trim(),
						Double.valueOf(this.txt_tarif.getText().trim()), this.txt_titre.getText().trim() + ".jpg",
						this.cbx_periodicite.getSelectionModel().getSelectedItem().getId());
				dao.getRevueDAO().create(rev);
				this.lbl_affichage.setText(rev.toString());
				supprimer();
			}
		} else
			this.lbl_champsvides.setVisible(true);
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
		return this.txt_description.getText().isEmpty() || this.txt_tarif.getText().isEmpty()
				|| this.txt_titre.getText().isEmpty();
	}

	boolean champCorrecte() {
		//REGEX TROUVE SUR STACKOVERFLOW
		//PREND EN COMPTE BEAUCOUP DE CAS(INFINI, POSITIF ETC...)
		boolean reponse = true;
		if (!texteSeulement(this.txt_titre.getText())) {
			this.lbl_erreurtitre.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurtitre.setVisible(false);

		if (!texteSeulement(this.txt_description.getText())) {
			this.lbl_erreurdescription.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurdescription.setVisible(false);

		//Check Double
		final String Digits     = "(\\p{Digit}+)";
		final String HexDigits  = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally 
		// signed decimal integer.
		final String Exp        = "[eE][+-]?"+Digits;
		final String fpRegex    =
		    ("[\\x00-\\x20]*"+ // Optional leading "whitespace"
		    "[+-]?(" +         // Optional sign character
		    "NaN|" +           // "NaN" string
		    "Infinity|" +      // "Infinity" string
		    // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		    "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		    // . Digits ExponentPart_opt FloatTypeSuffix_opt
		    "(\\.("+Digits+")("+Exp+")?)|"+

		    // Hexadecimal strings
		    "((" +
		    // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "(\\.)?)|" +

		    // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		    ")[pP][+-]?" + Digits + "))" +
		    "[fFdD]?))" +
		    "[\\x00-\\x20]*");// Optional trailing "whitespace"

		if (!Pattern.matches(fpRegex, this.txt_tarif.getText())){
		    reponse=false;
		    this.lbl_erreurtarif.setVisible(true);}
		else
			this.lbl_erreurtarif.setVisible(false);
		
		if (this.cbx_periodicite.getSelectionModel().getSelectedIndex() == -1) {
			this.lbl_erreurperio.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurperio.setVisible(false);
		return reponse;
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
