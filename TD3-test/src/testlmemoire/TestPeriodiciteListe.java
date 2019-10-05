package testlmemoire;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.PeriodiciteIDAO;

public class TestPeriodiciteListe {

	DAOFactory dao = DAOFactory.getDAOFactory(Persistance.Liste);
	PeriodiciteIDAO Abonnement = dao.getPeriodiciteDAO();
	
}
