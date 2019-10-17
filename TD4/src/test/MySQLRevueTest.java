package test;

import java.util.List;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daomysql.MySQLRevue;
import junit.framework.TestCase;
import metiers.Client;
import metiers.Revue;

public class MySQLRevueTest extends TestCase {
	
private MySQLRevue revtest;
	
	public void setUp()
	{
		revtest = (MySQLRevue) DAOFactory.getDAOFactory(Persistance.Mysql).getRevueDAO();
	}
	public void testCreate()
	{
		Revue rev = new Revue(18,"Le Chat","Un chat beau",3.0,"chat",10);
		assertTrue(revtest.create(rev));
		revtest.delete(rev);
	}
	public void testUpdate()
	{
		Revue rev = new Revue(18,"Le Chat","Un chat beau",3.0,"chat",10);
		revtest.create(rev);
		rev.setTitre("Le Chat");
        assertTrue(revtest.update(rev));
        revtest.delete(rev);
	}
	public void testDelete()
	{
		Revue rev = new Revue(18,"Le Chat","Un chat beau",3.0,"chat",10);
		assertTrue(revtest.create(rev));
		assertTrue(revtest.delete(rev));
	}
	public void testfindAll()
	{
		List<Revue> listederevue = revtest.findAll();
		assertNotNull(listederevue);
	}
	public void testgetById()
	{
		Revue rev = new Revue(18,"Le Chat","Un chat beau",3.0,"chat",10);
		revtest.create(rev);
		assertEquals(rev, revtest.getById(rev.getId_revue()));
		revtest.delete(rev);
	}
}
