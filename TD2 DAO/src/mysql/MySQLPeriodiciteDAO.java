package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import connexion.Connexion;
import metierDAO.IPeriodiciteDAO;
import metiers.Periodicite;

public class MySQLPeriodiciteDAO  implements IPeriodiciteDAO{

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Periodicite per) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Periodicite per) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Periodicite> getByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
