package testlmemoire;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.ClientIDAO;

public class TestClientListe {
	
	DAOFactory dao = DAOFactory.getDAOFactory(Persistance.Liste);
	ClientIDAO Client = dao.getClientDAO();
	
	

}
