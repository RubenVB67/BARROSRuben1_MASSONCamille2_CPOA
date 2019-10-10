package testlistememoire;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.AbonnementIDAO;
import metiers.Abonnement;

class TestListeAbonnement {

	AbonnementIDAO abon = DAOFactory.getDAOFactory(Persistance.Liste).getAbonnementDAO();
	
	@Test
	void testCreate() {
		
		Abonnement abo = new Abonnement(30, 20, LocalDate.of(2020, 11, 10), LocalDate.of(2021, 1, 10));
		
		if(!abon.create(abo)) {
			fail("Pas implemente");
		}
		abon.delete(abo);
	}

	@Test
	void testDelete() {
		
		Abonnement abo = new Abonnement(30, 20, LocalDate.of(2020, 11, 10), LocalDate.of(2021, 1, 10));

		abon.create(abo);
		
		if(!abon.delete(abo)) {
			fail("Pas supprime");
		}	
	}

	@Test
	void testUpdate() {
		
		Abonnement abo = new Abonnement(30, 20, LocalDate.of(2020, 11, 10), LocalDate.of(2021, 1, 10));

		abon.create(abo);
		
		if(!abon.update(abo)) {
			fail("Pas modifie");
		}	
		abon.delete(abo);
	}

	@Test
	void testGetById() {
		
		Abonnement abo = new Abonnement(30, 20, LocalDate.of(2020, 11, 10), LocalDate.of(2021, 1, 10));

		abon.create(abo);
		
		if(!abon.getById(abo.getId_client(), abo.getId_revue()).equals(abo)) {
			abon.delete(abo);
			fail("Pas trouve");			
		}
		abon.delete(abo);
	}

	@Test
	void testFindAll() {
		
		Abonnement abo = new Abonnement(30, 20, LocalDate.of(2020, 11, 10), LocalDate.of(2021, 1, 10));

		abon.create(abo);
		
		if(abon.findAll()==null) {
			abon.delete(abo);
			fail("Pas trouve");
		}
		abon.delete(abo);
	}

}
