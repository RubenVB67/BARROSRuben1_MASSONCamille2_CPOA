package mysql;

import java.util.ArrayList;

import metierDAO.IClientDAO;
import metiers.Client;

public class MySQLClientDAO  implements IClientDAO{

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Client cli) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client cli) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client cli) {
		// TODO Auto-generated method stub
		return false;
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
