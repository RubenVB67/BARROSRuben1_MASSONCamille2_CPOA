package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daomysql.MySQLClient;
import daoobjects.ClientIDAO;
import junit.framework.TestCase;
import metiers.Client;

public class MySQLClientTest extends TestCase {

	private ClientIDAO cltest;
	
	public void setUp()
	{
		cltest = DAOFactory.getDAOFactory(Persistance.Mysql).getClientDAO();
	}
	public void testCreate()
	{
		Client cl = new Client(17,"Barros","Ruben","9","Rue de la ronde","57050","Metz","France");
		assertTrue(cltest.create(cl));
		cltest.delete(cl);
	}
	public void testUpdate() {
		Client cl = new Client(17,"Barros","Ruben","9","Rue de la ronde","57050","Metz","France");
		cltest.create(cl);
		cl.setNom("Foster");
        assertTrue(cltest.update(cl));
        cltest.delete(cl);
    }
	public void testDelete()
	{
		Client cl = new Client(17,"Barros","Ruben","9","Rue de la ronde","57050","Metz","France");
		assertTrue(cltest.create(cl));
		assertTrue(cltest.delete(cl));
	}
	public void testfindAll()
	{
		List<Client> listedeclient = cltest.findAll();
		assertNotNull(listedeclient);
	}
	public void testgetById()
	{
		Client cl = new Client(17,"Barros","Ruben","9","Rue de la ronde","57050","Metz","France");
		cltest.create(cl);
		assertEquals(cl, cltest.getById(cl.getId()));
		cltest.delete(cl);
	}
}
