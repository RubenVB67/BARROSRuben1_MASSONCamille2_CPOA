package test;

import java.util.List;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daomysql.MySQLClient;
import daomysql.MySQLPeriodicite;
import junit.framework.TestCase;
import metiers.Client;
import metiers.Periodicite;

public class MySQLPeriodiciteTest extends TestCase {
	private MySQLPeriodicite periotest;

	public void setUp()
	{
		Periodicite perio = new Periodicite(10,"Hey");
		MySQLPeriodicite.getInstance().create(perio);
	}
	
	public void testCreate()
	{
		Periodicite perio = new Periodicite(10,"Hey");
		assertTrue(periotest.create(perio));
		periotest.delete(perio);
	}
	public void testUpdate()
	{
		Periodicite perio = new Periodicite(10,"Hey");
		periotest.create(perio);
		perio.setLibelle("Boogie");
        assertTrue(periotest.update(perio));
        periotest.delete(perio);
	}
	public void testDelete()
	{
		Periodicite perio = new Periodicite(10,"Hey");
		assertTrue(periotest.create(perio));
		assertTrue(periotest.delete(perio));
	}
	public void testfindAll()
	{
		List<Periodicite> listedeperio = periotest.findAll();
		assertNotNull(listedeperio);
	}
	public void testgetById()
	{
		Periodicite perio = new Periodicite(10,"Hey");
		periotest.create(perio);
		assertEquals(perio, periotest.getById(perio.getId()));
		periotest.delete(perio);
	}
}
