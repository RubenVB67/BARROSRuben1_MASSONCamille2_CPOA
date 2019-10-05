package daofactory;

import daomysql.*;
import daoobjects.AbonnementIDAO;
import daoobjects.ClientIDAO;
import daoobjects.PeriodiciteIDAO;
import daoobjects.RevueIDAO;

public class MySQLDAOFactory extends DAOFactory{
	
	@Override
	public ClientIDAO getClientDAO() {
		return MySQLClient.getInstance();
	}
	@Override
	public RevueIDAO getRevueDAO() {

		return MySQLRevue.getInstance();
	}
	@Override
	public PeriodiciteIDAO getPeriodiciteDAO() {

		return MySQLPeriodicite.getInstance();
	}
	@Override
	public AbonnementIDAO getAbonnementDAO() {
		return MySQLAbonnement.getInstance();
	}
}
