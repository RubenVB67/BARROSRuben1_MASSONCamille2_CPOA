package metiers;

import java.sql.*;
import java.time.*;

import connexion.Connexion;

public class Abonnement
{
	int id_client;
	int id_revue;
	String date_debut;
	String date_fin;
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_revue() {
		return id_revue;
	}
	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public Abonnement(int id_client, int id_revue, String date_debut, String date_fin) {
		super();
		this.id_client = id_client;
		this.id_revue = id_revue;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	
	public void Ajouter(int id_client,int id_revue,String date_debut,String date_fin ) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Abonnement(id_client,id_revue,date_debut,date_fin) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setInt(2,id_revue);
			requete.setInt(1,id_client);
			char x = '/';
            char y = '-';
            date_debut.trim();
            date_fin.trim();
            date_fin=date_fin.replace(x,y);
            date_debut=date_debut.replace(x,y);
			
			LocalDate date1 = LocalDate.parse(date_debut);
			LocalDate date2 = LocalDate.parse(date_fin);
			date2.compareTo(date1);
			
			requete.setDate(4,Date.valueOf(date1));
			requete.setDate(3,Date.valueOf(date2));
			requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Ajout effectue");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un probleme" + sqle.getMessage());
		}
	}
	//si modif marche pas methode val -> faire une fonction pour chaque champ
	public void Modifier(int id_client,int id_revue,String date_debut,String date_fin) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Abonnement SET date_debut,date_fin = ? WHERE id_client= ? AND id_revue= ?");
			requete.setInt(2,id_revue);
			requete.setInt(1,id_client);
			char x = '/';
            char y = '-';
            date_debut.trim();
            date_fin.trim();
            date_fin=date_fin.replace(x,y);
            date_debut=date_debut.replace(x,y);
			
			LocalDate date1 = LocalDate.parse(date_debut);
			LocalDate date2 = LocalDate.parse(date_fin);
			
			requete.setDate(4,Date.valueOf(date1));
			requete.setDate(3,Date.valueOf(date2));
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Modification effectue");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un probleme" + sqle.getMessage());
		}
	}
	
	public void Supprimer(int id_client,int id_revue) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Abonnement where id_client =? AND id_revue= ?");
			requete.setInt(2,id_revue);
			requete.setInt(1,id_client);
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Suppression effectue");
		} catch (SQLException sqle) {
			System.out.println("Il y'a un probleme" + sqle.getMessage());
		}
	}
}
