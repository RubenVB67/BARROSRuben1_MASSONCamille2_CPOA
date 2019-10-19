package daomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import daofactory.Connexion;
import daoobjects.RevueIDAO;
import metiers.Revue;

public class MySQLRevue implements RevueIDAO{
	private static MySQLRevue instance;

	private MySQLRevue() {}

	public static MySQLRevue getInstance() {

		if (instance == null) {
			instance = new MySQLRevue();
		}
		return instance;
	}
	

	public Revue getById(int id) {
		Revue Revue = new Revue();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT id_revue,titre,description,tarif_numero,visuel,id_periodicite FROM Revue WHERE id_Revue=?");
			requete.setInt(1,id);
			ResultSet res = requete.executeQuery();
			res.next();
			Revue = new Revue(
					res.getInt("id_revue"),
					res.getString("titre"),
					res.getString("description"),
					res.getDouble("tarif_numero"),
					res.getString("visuel"),
					res.getInt("id_periodicite")
					);
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			Revue=null;
		}

		return Revue;

	}

	@Override
	public ArrayList<Revue> findAll() {
		ArrayList<Revue> listeRevue = new ArrayList<>();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"SELECT id_revue,titre,description,tarif_numero,visuel,id_periodicite FROM Revue");
			ResultSet res = requete.executeQuery();
			while (res.next()) {

				listeRevue.add(new Revue(
						res.getInt("id_revue"),
						res.getString("titre"),
						res.getString("description"),
						res.getDouble("tarif_numero"),
						res.getString("visuel"),
						res.getInt("id_periodicite")
						));
			}
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return listeRevue;
	}

	@Override
	public boolean create(Revue rev) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"INSERT INTO Revue(titre,description,tarif_numero,visuel,id_periodicite) VALUES(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, rev.getTitre());
			requete.setString(2, rev.getDescription());
			requete.setDouble(3, rev.getTarif_numero());
			requete.setString(4, rev.getVisuel());
			requete.setInt(5, rev.getId_periodicite());
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
	public boolean update(Revue rev) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"UPDATE Revue SET titre=?,description=?,tarif_numero=?,visuel=?,id_periodicite=? WHERE id_Revue=?");

			requete.setString(1, rev.getTitre());
			requete.setString(2, rev.getDescription());
			requete.setDouble(3, rev.getTarif_numero());
			requete.setString(4, rev.getVisuel());
			requete.setInt(5, rev.getId_periodicite());
			requete.setInt(6, rev.getId_revue());
			requete.executeUpdate();
			System.out.println("Le Revue a �t� modifi�.");
			if (requete != null)
				requete.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
	}
	}
	@Override
	public boolean delete(Revue rev) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM Revue WHERE id_Revue="+ rev.getId_revue());
			if (requete != null)
				requete.close();
			return true;

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
		}
	}
	
	
//---------------------------------- a faire plus tard -------------------------------------------------------------

	@Override
	public ArrayList<Revue> getByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByTarif(int tarif_numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByVisuel(String visuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByPeriodicite(int id_periodicite) {
		// TODO Auto-generated method stub
		return null;
	}
}
