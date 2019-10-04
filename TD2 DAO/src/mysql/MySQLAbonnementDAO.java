package mysql;

import java.util.ArrayList;

import metierDAO.IAbonnementDAO;
import metiers.Abonnement;

public class MySQLAbonnementDAO  implements IAbonnementDAO{

	@Override
	public Abonnement getById(int id) {
		return null;
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
