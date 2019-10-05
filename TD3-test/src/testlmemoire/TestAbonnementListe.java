package testlmemoire;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.AbonnementIDAO;

public class TestAbonnementListe {

	DAOFactory dao = DAOFactory.getDAOFactory(Persistance.Liste);
	AbonnementIDAO Abonnement = dao.getAbonnementDAO();
	
}
