package test;


import static org.junit.Assert.fail;

import org.junit.Test;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.PeriodiciteIDAO;
import metiers.Periodicite;

public class TestListePeriodicite {

PeriodiciteIDAO lper = DAOFactory.getDAOFactory(Persistance.Liste).getPeriodiciteDAO();
	
	@Test
	void testCreate() {	
		Periodicite per = new Periodicite(11, "test");
			
		if(!lper.create(per)) {
			fail("Pas implemente");
		}
		lper.delete(per);
	}

	@Test
	void testDelete() {	
		Periodicite per = new Periodicite(22, "test");
		lper.create(per);
	
		if(!lper.delete(per)) {
			fail("Pas supprime");
		}
	}

	@Test
	void testUpdate() {	
		Periodicite per = new Periodicite(33, "test");
		lper.create(per);
		
		if(!lper.update(per)) { 
			fail("Pas modifie");
		}
		lper.delete(per);
	}

	@Test
	void testGetById() {	
		Periodicite per = new Periodicite(44, "test");
		lper.create(per);
		
		if(!lper.getById(per.getId()).equals(per)) {
			lper.delete(per);
			fail("Pas trouve");			
		}
		lper.delete(per);
	}

	@Test
	void testFindAll() {		
		if(lper.findAll()==null)
		fail("Pas trouve");
		
	}

}
