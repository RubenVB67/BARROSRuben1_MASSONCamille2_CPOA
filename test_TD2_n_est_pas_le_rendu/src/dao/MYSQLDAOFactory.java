package dao;

import metierDAO.*;
import mysql.*;

public class MYSQLDAOFactory extends DAOFactory {

	@Override
	public IPeriodiciteDAO getPeriodiciteDAO() {
		return MySQLPeriodiciteDAO.getInstance();
	}
	@Override
	public IAbonnementDAO getAbonnementDAO() {
		return MySQLAbonnementDAO.getInstance();
	}

	@Override
	public IClientDAO getClientDAO() {
		return MySQLClientDAO.getInstance();
	}

	@Override
	public IRevueDAO getRevueDAO() {
		return MySQLRevueDAO.getInstance();
	}

}
