package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.ClientIDAO;
import metiers.Client;

class TestListeClient {

	ClientIDAO clien = DAOFactory.getDAOFactory(Persistance.Liste).getClientDAO();
	
	@Test
	void testCreate() {
		 
		Client cli = new Client(15,  "Jean",  "Jaque",  "14",  "rue che pas",  "57000",
				"moncu",  "France");
		
		if(!clien.create(cli)) {
			fail("Pas encore implemente");
		}
		clien.delete(cli);
	}

	@Test
	void testDelete() {
		 
		Client cli = new Client(15,  "Jean",  "Jaque",  "14",  "rue che pas",  "57000",
				 "moncu",  "France");
		clien.create(cli);
		
		if(!clien.delete(cli)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testUpdate() {
		 
		Client cli = new Client(15,  "Jean",  "Jaque",  "14",  "rue che pas",  "57000",
				 "moncu",  "France");
		clien.create(cli);
		
		if(!clien.update(cli)) {
			fail("Pas encore modifie");
		}
		clien.delete(cli);
	}
	
	@Test
	void testGetById() {
		 
		Client cli = new Client(15,  "Jean",  "Jaque",  "14",  "rue che pas",  "57000",
				 "moncu",  "France");
		clien.create(cli);
		
		if(!clien.getById(cli.getId()).equals(cli)) {
			clien.delete(cli);
			fail("Pas trouve");			
		}
		clien.delete(cli);
	}

	@Test
	void testFindAll() {
	
		Client cli = new Client(15,  "Jean",  "Jaque",  "14",  "rue che pas",  "57000",
				 "moncu",  "France");
		clien.create(cli);
		
		if(clien.findAll()==null) {
			clien.delete(cli);
			fail("Pas trouve");
		}
		clien.delete(cli);
	}

}
