package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.RevueIDAO;
import metiers.Revue;

class TestListeRevue {
	
	RevueIDAO revu = DAOFactory.getDAOFactory(Persistance.Liste).getRevueDAO();

	@Test
	void testCreate() {
		 
		Revue rev = new Revue(30, "Mangactu", "pour les fans de manga", 3., "mangactu.jpg",2);
		
		if(!revu.create(rev)) {
			fail("Pas encore implemente");
		}
		revu.delete(rev);
	}

	@Test
	void testDelete() {
		 
		Revue rev = new Revue(30, "Mangactu", "pour les fans de manga", 3., "mangactu.jpg",2);
		
		revu.create(rev);
		if(!revu.delete(rev)) {
			fail("Pas encore supprime");
		}
	}

	@Test
	void testUpdate() {
		
		Revue rev = new Revue(30, "Mangactu", "pour les fans de manga", 3., "mangactu.jpg",2);

		revu.create(rev);
		
		if(!revu.update(rev)) {
			fail("Pas encore modifie");
		}
		revu.delete(rev);
	}

	@Test
	void testGetById() {
		
		Revue rev = new Revue(30, "Mangactu", "pour les fans de manga", 3., "mangactu.jpg",2);

		revu.create(rev);
		
		if(!revu.getById(rev.getId_revue()).equals(rev)) {
			revu.delete(rev);
			fail("Pas trouve");			
		}
		revu.delete(rev);
	}

	@Test
	void testFindAll() {	
		
		Revue rev = new Revue(30, "Mangactu", "pour les fans de manga", 3., "mangactu.jpg",2);

		revu.create(rev);
		
		if(revu.findAll()==null) {
			revu.delete(rev);
			fail("Pas trouve");
		}
		revu.delete(rev);
	}

}
