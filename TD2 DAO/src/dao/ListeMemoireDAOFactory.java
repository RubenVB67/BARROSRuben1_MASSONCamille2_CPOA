package dao;

import metierDAO.*;
import listememoire.*;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public IPeriodiciteDAO getPeriodiciteDAO() {
		return ListeMemoirePeriodiciteDAO.getInstance();
	}
	@Override
	public IAbonnementDAO getAbonnementDAO() {
		return ListeMemoireAbonnementDAO.getInstance();
	}

	@Override
	public IClientDAO getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public IRevueDAO getRevueDAO() {
		return ListeMemoireRevueDAO.getInstance();
	}
	
}
