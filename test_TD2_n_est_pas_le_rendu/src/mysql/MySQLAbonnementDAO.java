package mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connexion.Connexion;
import metierDAO.IAbonnementDAO;
import metiers.Abonnement;

public class MySQLAbonnementDAO  implements IAbonnementDAO{

	private static MySQLAbonnementDAO instance = null;
	
	private MySQLAbonnementDAO(){
		// singleton
	}
	
	public static MySQLAbonnementDAO getInstance(){
		if (instance == null){
			instance = new MySQLAbonnementDAO();
		}
		return instance;
	}
	
	
	
	
	@Override
	public Abonnement getById(int id) {
		return null;
	}
	public Abonnement getById(int id_client, int id_revue) {
		return null;	//faux mais a finir par la suite
	}

	@Override
	public boolean create(Abonnement abo) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Abonnement(id_client,id_revue,date_debut,date_fin) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setInt(2,abo.getId_revue());
			requete.setInt(1,abo.getId_client());
			
			char x = '/';
            char y = '-';
            String date_debut = abo.getDate_debut().trim();
            String date_fin = abo.getDate_fin().trim();
            date_fin=date_fin.replace(x,y);
            date_debut=date_debut.replace(x,y);
			
            Date date1 = Date.valueOf(date_debut);
            Date date2 = Date.valueOf(date_fin);
            
			if((date2.compareTo(date1))>0)
			{
				requete.setDate(4,date1);
				requete.setDate(3,date2);
				requete.executeUpdate();
				ResultSet res = requete.getGeneratedKeys();
				if (res != null)
					res.close();
				if (requete != null)
					requete.close();
				if (laConnexion != null)
					laConnexion.close();
				System.out.println("Ajout effectue");
				return true;
			}
			else{
				System.out.println("Date incoherente");
				return false;
			}
		} catch (SQLException sqle) {
			System.out.println("Il y'a un probleme" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Abonnement abo) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Abonnement SET date_debut,date_fin = ? WHERE id_client= ? AND id_revue= ?");
			requete.setInt(2,abo.getId_revue());
			requete.setInt(1,abo.getId_client());
			
			char x = '/';
            char y = '-';
            String date_debut = abo.getDate_debut().trim();
            String date_fin = abo.getDate_fin().trim();
            date_fin=date_fin.replace(x,y);
            date_debut=date_debut.replace(x,y);
			
            Date date1 = Date.valueOf(date_debut);
            Date date2 = Date.valueOf(date_fin);
            
			if((date2.compareTo(date1))>0)
			{
				requete.setDate(4,date1);
				requete.setDate(3,date2);
				requete.executeUpdate();
				ResultSet res = requete.getGeneratedKeys();
				if (res != null)
					res.close();
				if (requete != null)
					requete.close();
				if (laConnexion != null)
					laConnexion.close();
				System.out.println("Ajout effectue");
				return true;
			}
			else{
				System.out.println("Date incoherente");
				return false;
			}
		} catch (SQLException sqle) {
			System.out.println("Il y'a un probleme" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Abonnement abo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Abonnement> getByClient(int id_client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByRevue(int id_revue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByDebut(String date_debut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByFin(String date_fin) {
		// TODO Auto-generated method stub
		return null;
	}

}
