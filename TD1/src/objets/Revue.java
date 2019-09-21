package objets;
import java.sql.*;
import java.util.Scanner;

import connexion.Connexion;

public class Revue implements Connexion 
{
	int id_revue;
	String titre;
	String description;
	int tarif_numero;
	String visuel;
	int id_periodicite;
	public int getId_revue() {
		return id_revue;
	}
	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTarif_numero() {
		return tarif_numero;
	}
	public void setTarif_numero(int tarif_numero) {
		this.tarif_numero = tarif_numero;
	}
	public String getVisuel() {
		return visuel;
	}
	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}
	public int getId_periodicite() {
		return id_periodicite;
	}
	public void setId_periodicite(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}
	public Revue(int id_revue, String titre, String description, int tarif_numero, String visuel, int id_periodicite) {
		super();
		this.id_revue = id_revue;
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero;
		this.visuel = visuel;
		this.id_periodicite = id_periodicite;
	}
	
	public void Ajouter(int id_revue, String titre, String description, int tarif_numero, String visuel, int id_periodicite) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Revue(id_revue,titre,description,tarif_numero,visuel,id_periodicite) values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setInt(6,id_periodicite);
			requete.setString(5,visuel);
			requete.setInt(4,id_revue);
			requete.setString(3,description);
			requete.setString(2,titre);
			requete.setInt(1,id_revue);
			requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Ajout effectué");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
		}
	}
	//si modif marche pas méthode val -> faire une fonction pour chaque champ
	public void Modifier(int id_revue,String titre, String description, int tarif_numero, String visuel, int id_periodicite) {
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Revue SET titre,description,tarif_numero,visuel,id_periodicite = ? WHERE id_revue= ?");
			requete.setInt(6,id_periodicite);
			requete.setString(5,visuel);
			requete.setInt(4,id_revue);
			requete.setString(3,description);
			requete.setString(2,titre);
			requete.setInt(1,id_revue);
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Modification effectué");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
		}
	}
	
	public void Supprimer(int id_revue) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue= ?");
			requete.setInt(1,id_revue);
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Suppression effectué");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
		}
	}
	
}
