package dao;

import metierDAO.*;

public class MYSQLDAOFactory extends DAOFactory {

	@Override
	public IPeriodiciteDAO getIPeriodiciteDAO() {
		return MySQLIPeriodiciteDAO.getInstance();
	}
	@Override
	public IAbonnementDAO getIAbonnementDAO() {
		return MySQLIAbonnementDAO.getInstance();
	}

	@Override
	public IClientDAO getIClientDAO() {
		return MySQLIClientDAO.getInstance();
	}

	@Override
	public IRevueDAO getIRevueDAO() {
		return MySQLIRevueDAO.getInstance();
	}

}
