package dao;

import metierDAO.*;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactoriy daoF = null;
		
		switch (cible) {
		case MYSQL:
		daoF = new MySQLDAOFactory();
		break;
		case LISTE_MEMOIRE:
		daoF = new ListeMemoireDAOFactory();
		break;
		}

		return doaF;
		
	}
	
	public abstract IClientDAO getIClientDAO();
	public abstract IRevueDAO getIRevueDAO();
	public abstract IAbonnementDAO getIAbonnementDAO();
	public abstract IPeriodiciteDAO getIPeriodiciteDAO();
	
}
