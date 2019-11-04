package controleur;

import java.util.regex.Pattern;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.PeriodiciteIDAO;
import daoobjects.RevueIDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metiers.Periodicite;

public class DetailRevueControleur {

    @FXML
    private Label lbl_tarif;

    @FXML
    private Label lbl_visuel;

    @FXML
    private Label lbl_description;

    @FXML
    private Label lbl_titre;

    @FXML
    private TextField txt_tarif;

    @FXML
    private TextField txt_visuel;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_titre;

    @FXML
    private Button btn_retour;

    @FXML
    private Button btn_valider;

    @FXML
    private Label lbl_erreurtitre;

    @FXML
    private Label lbl_erreurdescription;

    @FXML
    private Label lbl_erreurvisuel;

    @FXML
    private Label lbl_erreurtarif;

    @FXML
    private Label lbl_erreurperio;


    @FXML
    private ComboBox<Periodicite> cbb_perio;
    
    private DAOFactory daof;
    private RevueIDAO rev;
    private PeriodiciteIDAO perio;
    @FXML
    void retour(ActionEvent event) {
    	Stage stage = (Stage) btn_retour.getScene().getWindow();
        stage.close();
    }

    @FXML
    void valider(ActionEvent valider) {
    	VueRevueControleur vrc = new VueRevueControleur();
    	if(vrc.creer == true) {
    		this.daof = DAOFactory.getDAOFactory(Persistance.Liste);
    		perio = this.daof.getPeriodiciteDAO();
        	this.cbb_perio.setItems(FXCollections.observableArrayList(perio.findAll()));
        	txt_titre.setDisable(true);
        	txt_description.setDisable(false);
        	txt_tarif.setDisable(false);
        	txt_tarif.setDisable(false);
        	cbb_perio.setDisable(false);
    	}
    	else {
    		this.daof = DAOFactory.getDAOFactory(Persistance.Liste);
    		perio = this.daof.getPeriodiciteDAO();
        	this.cbb_perio.setItems(FXCollections.observableArrayList(perio.findAll()));
    	}
    }
    boolean texteSeulement(String texte) {
    	texte = texte.replace("é", "e");
		texte = texte.replace("ô", "o");
		texte = texte.replace("ï", "i");
		texte = texte.replace("'", "");
		texte = texte.replace(",", "");
		if (!texte.matches("[a-zA-z\\s]*"))
			return false;
		else
			return true;
    }
    
    boolean chiffreSeulement(String chiffre) {
		if (!chiffre.matches("^[1-9]\\d*$"))
			return false;
		else
			return true;
    }
    
	boolean champCorrect() {
		//REGEX pour trouver si c'est un double
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
			
		if (!texteSeulement(this.txt_visuel.getText())) {
			this.lbl_erreurvisuel.setVisible(true);
			reponse = false;
		} else
			this.lbl_erreurvisuel.setVisible(false);
		
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
				if (this.cbb_perio.getSelectionModel().getSelectedIndex() == -1) {
					this.lbl_erreurperio.setVisible(true);
					reponse = false;
				} else
					this.lbl_erreurperio.setVisible(false);

		return reponse;
	}

}

