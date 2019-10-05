package dao;

import metierDAO.*;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		
		switch (cible) {
		case MYSQL:
		daoF = new MYSQLDAOFactory();
		break;
		case LISTE_MEMOIRE:
		daoF = new ListeMemoireDAOFactory();
		break;
		}
		
		return daoF;
		
	}
	
	public abstract IClientDAO getClientDAO();
	
	public abstract IRevueDAO getRevueDAO();
	
	public abstract IAbonnementDAO getAbonnementDAO();
	
	public abstract IPeriodiciteDAO getPeriodiciteDAO();
	
}
