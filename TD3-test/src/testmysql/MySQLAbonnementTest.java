package testmysql;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daomysql.MySQLAbonnement;
import metiers.Abonnement;

class MySQLAbonnementTest {

private MySQLAbonnement abotest;
	
	public void setUp()
	{
		abotest = (MySQLAbonnement) DAOFactory.getDAOFactory(Persistance.Mysql).getAbonnementDAO();
	}
	public void testCreate()
	{
		Abonnement abo = new Abonnement(10,10,LocalDate.of(2017,1,12),LocalDate.of(2017,1,15));
		assertTrue(abotest.create(abo));
		abotest.delete(abo);
	}
	public void testUpdate()
	{
		Abonnement abo = new Abonnement(10,10,LocalDate.of(2017,1,12),LocalDate.of(2017,1,15));
		abotest.create(abo);
		abo.setDate_debut(LocalDate.of(2017,1,13));
        assertTrue(abotest.update(abo));
        abotest.delete(abo);
	}
	public void testDelete()
	{
		Abonnement abo = new Abonnement(10,10,LocalDate.of(2017,1,12),LocalDate.of(2017,1,15));
		assertTrue(abotest.create(abo));
		assertTrue(abotest.delete(abo));
	}
	public void testfindAll()
	{
		List<Abonnement> listeabo = abotest.findAll();
		assertNotNull(listeabo);
	}
	public void testgetById()
	{
		Abonnement abo = new Abonnement(10,10,LocalDate.of(2017,1,12),LocalDate.of(2017,1,15));
		abotest.create(abo);
		assertEquals(abo, abotest.getById(abo.getId_client(),abo.getId_revue()));
		abotest.delete(abo);
	}

}
