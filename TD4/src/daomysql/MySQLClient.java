package daomysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daofactory.Connexion;
import metiers.*;
import daoobjects.*;

public class MySQLClient implements ClientIDAO {

	private static MySQLClient instance;

	private MySQLClient() {}

	public static MySQLClient getInstance() {

		if (instance == null) {
			instance = new MySQLClient();
		}
		return instance;
	}

	@Override
	public ArrayList<Client> findAll() {
		ArrayList<Client> listeClient = new ArrayList<>();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT id_client,nom,prenom,no_rue,voie,code_postal,ville,pays FROM Client");
			ResultSet res = requete.executeQuery();
			while (res.next()) {
				listeClient.add(new Client(
						res.getInt("id_client"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("no_rue"),
						res.getString("voie"),
						res.getString("code_postal"),
						res.getString("ville"),
						res.getString("pays")
						));
			}
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		return listeClient;
	}

	public Client getById(int id) {
		Client Client = new Client();
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("SELECT nom,prenom,no_rue,voie,code_postal,ville,pays FROM Client WHERE id_client=" + id);
			ResultSet res = requete.executeQuery();
			res.next();
			Client=new Client(
					id,
					res.getString("nom"),
					res.getString("prenom"),
					res.getString("no_rue"),
					res.getString("voie"),
					res.getString("code_postal"),
					res.getString("ville"),
					res.getString("pays")
					);
			if (requete != null)
				requete.close();
			if (res != null)
				res.close();
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());

		}
		if (Client.getNom() == null || Client.getPrenom() == null)
			Client = null;
		return Client;

	}

	@Override
	public boolean create(Client cli) {
		try { 
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion.prepareStatement(
					"INSERT INTO Client(nom,prenom,no_rue,voie,code_postal,ville,pays) VALUES(?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, cli.getNom());
			requete.setString(2, cli.getPrenom());
			requete.setString(3, cli.getNo_rue());
			requete.setString(4, cli.getVoie());
			requete.setString(5, cli.getCode_postal());
			requete.setString(6, cli.getVille());
			requete.setString(7, cli.getPays());
			requete.executeUpdate();

			ResultSet res = requete.getGeneratedKeys();
		/*	if (res.next()) {
				Client.setId(res.getInt(1));
			}*/
			if (requete != null)
				requete.close();
			if (res != null) {
				res.close();
			}
			return true;

		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Client cli) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			PreparedStatement requete = laConnexion
					.prepareStatement("UPDATE Client SET nom=?,prenom=?,no_rue=?,voie=?,code_postal=?,ville=?,pays=? WHERE id_client=?");
			requete.setString(1, cli.getNom());
			requete.setString(2, cli.getPrenom());
			requete.setString(3, cli.getNo_rue());
			requete.setString(4, cli.getVoie());
			requete.setString(5, cli.getCode_postal());
			requete.setString(6, cli.getVille());
			requete.setString(7, cli.getPays());
			requete.setInt(8, cli.getId());
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
	public boolean delete(Client cli) {
		try {
			Connection laConnexion = Connexion.getInstance().getMaConnexion();
			Statement requete = laConnexion.createStatement();
			requete.executeUpdate("DELETE FROM Client WHERE id_client=" + cli.getId());
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
