package daomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daofactory.Connexion;
import daoobjects.PeriodiciteIDAO;
import metiers.Periodicite;

public class MySQLPeriodicite implements PeriodiciteIDAO{
	private static MySQLPeriodicite instance;

	private MySQLPeriodicite() {}

	public static MySQLPeriodicite getInstance() {

		if (instance == null) {
			instance = new MySQLPeriodicite();
		}
		return instance;
	} 

	
	public Periodicite getById(int id) {
		Periodicite Periodicite = new Periodicite();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT libelle FROM Periodicite WHERE id_Periodicite= ?");
			requete.setInt(1,id);
			ResultSet res = requete.executeQuery();
			res.next();
			Periodicite = new Periodicite(
					id,
					res.getString("libelle")
					);
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return Periodicite;

	}

	@Override
	public ArrayList<Periodicite> findAll() {
		ArrayList<Periodicite> listePeriodicite = new ArrayList<>();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT id_Periodicite,libelle FROM Periodicite");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				listePeriodicite.add(new Periodicite(
						res.getInt("id_periodicite"),
						res.getString("libelle")
						));
			}
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		
		return listePeriodicite;
	}

	@Override
	public boolean create(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("INSERT INTO Periodicite(libelle) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, per.getLibelle());
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
	public boolean update(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle=? WHERE id_Periodicite=?");
			requete.setString(1, per.getLibelle());
			requete.setInt(2, per.getId());
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
	public boolean delete(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM Periodicite WHERE id_Periodicite=" + per.getId());
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
	public ArrayList<Periodicite> getByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}
}
