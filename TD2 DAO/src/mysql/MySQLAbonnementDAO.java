package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Abonnement abo) {
		// TODO Auto-generated method stub
		return false;
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
