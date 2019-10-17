package fenetre;

import metiers.Revue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
    private ComboBox<?> cbx_periodicite;

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
    void afficher(ActionEvent event) {
    	if (this.txt_titre.getText().isEmpty()) {
			this.lbl_erreurtitre.setVisible(true);
		}
    	else if(this.txt_description.getText().isEmpty())
    	{
			this.lbl_erreurdescription.setVisible(true);
    	}
    	else if(this.txt_tarif.getText().isEmpty())
    	{
			this.lbl_erreurtarif.setVisible(true);
    	}
    	else if(this.txt_description.getText().isEmpty())
    	{
			this.lbl_erreurperio.setVisible(true);
    	}
    }
	void supprimer()
	{
		this.lbl_affichage.setText("");
		this.cbx_periodicite.getSelectionModel().clearSelection();
		this.txt_description.clear();
		this.txt_titre.clear();
		this.txt_tarif.clear();
	}
	
}
