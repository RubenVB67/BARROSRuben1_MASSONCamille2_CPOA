package controleur;

import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

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
import metiers.Client;

public class DetailClientControleur {

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
    void creerModele() {
    	Client cl = null;
		if (!champVide()) {
			if (champCorrecte()) {
				cl = new Client(this.txt_nom.getText().trim(), this.txt_prenom.getText().trim(),
						this.txt_numerorue.getText().trim(), this.txt_voie.getText().trim(),
						this.txt_codepostal.getText().trim(),this.txt_ville.getText().trim(),
						this.txt_pays.getText().trim());
				dao.getClientDAO().create(cl);
				this.lbl_affichage.setText(cl.toString());
				supprimer();
			}
		} else
			this.lbl_champsvides.setVisible(true);
	
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
	
	boolean champCorrecte() {
		//REGEX TROUVE SUR STACKOVERFLOW
		//PREND EN COMPTE BEAUCOUP DE CAS(INFINI, POSITIF ETC...)
		boolean reponse = true;
		if (!texteSeulement(this.txt_nom.getText())) {
			this.lbl_erreurnom.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurnom.setVisible(false);

		if (!texteSeulement(this.txt_prenom.getText())) {
			this.lbl_erreurprenom.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurprenom.setVisible(false);
		if (!texteSeulement(this.txt_voie.getText())) {
			this.lbl_erreurvoie.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurvoie.setVisible(false);
		if (!texteSeulement(this.txt_ville.getText())) {
			this.lbl_erreurville.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurville.setVisible(false);
		if (!texteSeulement(this.txt_pays.getText())) {
			this.lbl_erreurpays.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurpays.setVisible(false);

		//Check Double
		final String Nbseul = "^[0-9]*$";
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

		if (!Pattern.matches(fpRegex, this.txt_numerorue.getText())){
		    reponse=false;
		    this.lbl_erreurnumerorue.setVisible(true);}
		else
			this.lbl_erreurnumerorue.setVisible(false);
		if (!Pattern.matches(fpRegex, this.txt_codepostal.getText())){
		    reponse=false;
		    this.lbl_erreurcodepostal.setVisible(true);}
		else
			this.lbl_erreurcodepostal.setVisible(false);
		if (!Pattern.matches(fpRegex, this.txt_numerorue.getText())){
		    reponse=false;
		    this.lbl_erreurnumerorue.setVisible(true);}
		else
			this.lbl_erreurnumerorue.setVisible(false);
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
