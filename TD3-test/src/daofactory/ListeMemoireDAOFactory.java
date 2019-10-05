package daofactory;

import daomemoire.*;
import daoobjects.AbonnementIDAO;
import daoobjects.ClientIDAO;
import daoobjects.PeriodiciteIDAO;
import daoobjects.RevueIDAO;

public class ListeMemoireDAOFactory extends DAOFactory{

	@Override
	public ClientIDAO getClientDAO() {
		return ListeClient.getInstance();
	}

	@Override
	public RevueIDAO getRevueDAO() {
		return ListeRevue.getInstance();
	}

	@Override
	public PeriodiciteIDAO getPeriodiciteDAO() {
		return ListePeriodicite.getInstance();
	}

	@Override
	public AbonnementIDAO getAbonnementDAO() {

		return ListeAbonnement.getInstance();
	}
}
