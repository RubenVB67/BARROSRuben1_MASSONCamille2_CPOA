package daomysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daofactory.Connexion;
import daoobjects.AbonnementIDAO;
import metiers.Abonnement;

public class MySQLAbonnement implements AbonnementIDAO{
	private static MySQLAbonnement instance;

	private MySQLAbonnement() {}

	public static MySQLAbonnement getInstance() {

		if (instance == null) {
			instance = new MySQLAbonnement();
		}
		return instance;
	}

	@Override
	public ArrayList<Abonnement> findAll() {
		ArrayList<Abonnement> listeAbonnement = new ArrayList<>();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT id_client,id_revue,date_debut,date_fin FROM Abonnement");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				listeAbonnement.add(new Abonnement(
						res.getInt("id_client"),
						res.getInt("id_revue"),
						res.getDate("date_debut").toLocalDate(),
						res.getDate("date_fin").toLocalDate()
						));
			}
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return listeAbonnement;
	}

	@Override
	public boolean create(Abonnement abo) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Abonnement( id_client,  id_revue,  date_debut,  date_fin) VALUES(?,?,?,?)");
			requete.setInt(1, abo.getId_client());
			requete.setInt(2, abo.getId_revue());
			requete.setDate(3, Date.valueOf(abo.getDate_debut()));
			requete.setDate(4, Date.valueOf(abo.getDate_fin()));
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Abonnement abo) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Abonnement SET date_debut=?,date_fin=? WHERE id_client=? AND id_revue= ?");
			requete.setDate(1, Date.valueOf(abo.getDate_debut()));
			requete.setDate(2, Date.valueOf(abo.getDate_fin()));
			requete.setInt(3, abo.getId_client());
			requete.setInt(4, abo.getId_revue());
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Abonnement abo) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("DELETE FROM Abonnement WHERE id_client=? AND id_revue=?");
			requete.setInt(1, abo.getId_client());
			requete.setInt(2, abo.getId_revue());
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
		}
	}

	
	@Override
	public Abonnement getById(int id) {
		return null; // on la neutralise elle ne sert a rien car on a 2 PK dans cette table
	}

	public Abonnement getById(int id_c, int id_r) {
		Abonnement Abonnement = new Abonnement();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("SELECT date_debut,date_fin FROM Abonnement WHERE id_client=? AND id_revue=?");
			requete.setInt(1,id_c);
			requete.setInt(2,id_r);
			ResultSet res = requete.executeQuery();
			res.next();
			Abonnement =new Abonnement(
					id_c,
					id_r,
					res.getDate("date_debut").toLocalDate(),
					res.getDate("date_fin").toLocalDate()
					);
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return Abonnement;
	}

	
//---------------------------------- a faire plus tard -------------------------------------------------------------
	

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
