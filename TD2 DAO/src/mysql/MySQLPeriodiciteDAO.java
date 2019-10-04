package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import metierDAO.IPeriodiciteDAO;
import metiers.Periodicite;

public class MySQLPeriodiciteDAO  implements IPeriodiciteDAO{

	
	private static MySQLPeriodiciteDAO instance = null;
	
	private MySQLPeriodiciteDAO(){
		// singleton
	}
	
	public static MySQLPeriodiciteDAO getInstance(){
		if (instance == null){
			instance = new MySQLPeriodiciteDAO();
		}
		return instance;
	}
	
	
	
	
	@Override
	public Periodicite getById(int id) {
		Periodicite peri = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();			

			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ?");
			requete.setInt(1, id);
			
			requete.executeQuery();
		}
		catch(SQLException sqle){
			System.out.println("Pb Client.getById" + sqle.getMessage());
		}
		
		return peri;	//faux mais a finir par la suite
	}

	@Override
	public boolean create(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Periodicite(id_periodicite,libelle) values(?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(2,per.getLibelle());
			requete.setInt(1,per.getId());
			requete.executeUpdate();
			ResultSet res = requete.getGeneratedKeys();
			if (res != null)
				res.close();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Ajout effectué");
			return true;
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle = ? WHERE id_periodicite= ?");
			requete.setString(1,per.getLibelle());
			requete.setInt(2,per.getId());
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Modification effectué");
			return true;
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(Periodicite per) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite= ?");
			requete.setInt(1,per.getId());
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Suppression effectué");
			return true;
		} catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<Periodicite> getByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
