package metiers;
import java.sql.*;

import connexion.Connexion;

public class Periodicite
{
	protected int id_periodicite;
	protected String libelle;
	
	public int getId() {
		return id_periodicite;
	}
	public void setId(int id_periodicite) {
		this.id_periodicite = id_periodicite;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Periodicite(int id_periodicite, String libelle) {
		super();
		this.id_periodicite = id_periodicite;
		this.libelle = libelle;
	}
	
	public void Ajouter(int id_periodicite,String libelle) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Periodicite(id_periodicite,libelle) values(?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(2,libelle);
			requete.setInt(1,id_periodicite);
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
	
	public void Modifier(int id_periodicite,String libelle) {
		try {
			
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite= ?");
			requete.setString(1,libelle);
			requete.setInt(2,id_periodicite);
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
	
	public void Supprimer(int id_periodicite) {
		try {
			Connexion c = new Connexion();
			Connection laConnexion = c.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite= ?");
			requete.setInt(1,id_periodicite);
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
