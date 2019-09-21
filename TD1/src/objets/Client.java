package objets;
import java.sql.*;
import java.util.Scanner;

import connexion.Connexion;

public class Client implements Connexion
{
	int id_client;
	String nom;
	String prenom;
	int no_rue;
	String voie;
	int code_postal;
	String ville;
	String pays;
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNo_rue() {
		return no_rue;
	}
	public void setNo_rue(int no_rue) {
		this.no_rue = no_rue;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public int getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public Client(int id_client, String nom, String prenom, int no_rue, String voie, int code_postal, String ville,
			String pays) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}
	
	public void Ajouter(int id_client, String nom, String prenom, int no_rue, String voie, int code_postal, String ville,
			String pays) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Client(id_client,nom,prenom,no_rue,voie,code_postal,ville,pays) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(8,pays);
			requete.setString(7,ville);
			requete.setInt(6,code_postal);
			requete.setString(5,voie);
			requete.setInt(4,no_rue);
			requete.setString(3,prenom);
			requete.setString(2,nom);
			requete.setInt(1,id_client);
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
	public void Modifier(int id_client, String nom, String prenom, int no_rue, String voie, int code_postal, String ville,
			String pays) {
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Client SET nom,prenom,no_rue,voie,code_postal,ville,pays = ? WHERE id_client= ?");
			requete.setString(8,pays);
			requete.setString(7,ville);
			requete.setInt(6,code_postal);
			requete.setString(5,voie);
			requete.setInt(4,no_rue);
			requete.setString(3,prenom);
			requete.setString(2,nom);
			requete.setInt(1,id_client);
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
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client= ?");
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
