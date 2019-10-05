package testlmemoire;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.RevueIDAO;

public class TestRevueListe {

	DAOFactory dao = DAOFactory.getDAOFactory(Persistance.Liste);
	RevueIDAO Abonnement = dao.getRevueDAO();
	
}
