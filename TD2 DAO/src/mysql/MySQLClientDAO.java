package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connexion.Connexion;
import metierDAO.IClientDAO;
import metiers.Client;

public class MySQLClientDAO  implements IClientDAO{

	private static MySQLClientDAO instance = null;
	
	private MySQLClientDAO(){
		// singleton
	}
	
	public static MySQLClientDAO getInstance(){
		if (instance == null){
			instance = new MySQLClientDAO();
		}
		return instance;
	}
	
	
	
	@Override
	public Client getById(int id) {
		Client client = null;
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();			

			PreparedStatement requete = laConnexion.prepareStatement("select * from Client where id_client = ?");
			requete.setInt(1, id);
			
			requete.executeQuery();
		}
		catch(SQLException sqle){
			System.out.println("Pb Client.getById" + sqle.getMessage());
		}
		
		return client;	//faux mais a finir par la suite
	}

	@Override
	public boolean create(Client cli) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Client(id_client,nom,prenom,no_rue,voie,code_postal,ville,pays) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			requete.setString(8,cli.getPays());
			requete.setString(7,cli.getVille());
			requete.setInt(6,cli.getCode_postal());
			requete.setString(5,cli.getVoie());
			requete.setInt(4,cli.getNo_rue());
			requete.setString(3,cli.getPrenom());
			requete.setString(2,cli.getNom());
			requete.setInt(1,cli.getId_client());
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
	public boolean update(Client cli) {
		try {	
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("UPDATE Client SET nom,prenom,no_rue,voie,code_postal,ville,pays = ? WHERE id_client= ?");
			requete.setString(8,cli.getPays());
			requete.setString(7,cli.getVille());
			requete.setInt(6,cli.getCode_postal());
			requete.setString(5,cli.getVoie());
			requete.setInt(4,cli.getNo_rue());
			requete.setString(3,cli.getPrenom());
			requete.setString(2,cli.getNom());
			requete.setInt(1,cli.getId_client());
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
	public boolean delete(Client cli) {
		try {
			Connection laConnexion = Connexion.getInstance().creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client= ?");
			requete.setInt(1,cli.getId_client());
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
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByAdresse(int no_rue, String voie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByCodePostal(int codepostal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByVille(String ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByPays(String Pays) {
		// TODO Auto-generated method stub
		return null;
	}

}
