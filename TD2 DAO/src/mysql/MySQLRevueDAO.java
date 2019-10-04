package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import metierDAO.IRevueDAO;
import metiers.Revue;

public class MySQLRevueDAO implements IRevueDAO{

	private static MySQLRevueDAO instance = null;
	
	private MySQLRevueDAO(){
		// singleton
	}
	
	public static MySQLRevueDAO getInstance(){
		if (instance == null){
			instance = new MySQLRevueDAO();
		}
		return instance;
	}
	
	@Override
	public Revue getById(int id){
		Revue revue = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();			

			PreparedStatement requete = laConnexion.prepareStatement("select * from Revue where id_revue = ?");
			requete.setInt(1, id);
			
			requete.executeQuery();
		}
		catch(SQLException sqle){
			System.out.println("Pb Revue.getById" + sqle.getMessage());
		}
		
		return revue;	//faux mais a finir par la suite
	}
	@Override
	public	boolean create(Revue rev){
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Revue(id_revue,titre,description,tarif_numero,visuel,id_periodicite) values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setInt(6,rev.getId_periodicite());
			requete.setString(5,rev.getVisuel());
			requete.setInt(4,rev.getTarif_numero());
			requete.setString(3,rev.getDescription());
			requete.setString(2,rev.getTitre());
			requete.setInt(1,rev.getId_revue());
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
	public	boolean update(Revue rev){
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Revue SET titre,description,tarif_numero,visuel,id_periodicite = ? WHERE id_revue= ?");
			requete.setInt(6,rev.getId_periodicite());
			requete.setString(5,rev.getVisuel());
			requete.setInt(4,rev.getTarif_numero());
			requete.setString(3,rev.getDescription());
			requete.setString(2,rev.getTitre());
			requete.setInt(1,rev.getId_revue());
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
	public	boolean delete(Revue rev){
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Revue where id_revue= ?");
			requete.setInt(1,rev.getId_revue());
			requete.executeUpdate();
			if (requete != null)
				requete.close();
			if (laConnexion != null)
				laConnexion.close();
			System.out.println("Suppression effectué");
			return true;
			} 
		catch (SQLException sqle) {
			System.out.println("Il y'a un problème" + sqle.getMessage());
			return false;
			}
	}
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
