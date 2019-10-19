<<<<<<< HEAD
package daoobjects;
import java.util.ArrayList;

import daofactory.*;
import metiers.Abonnement;

public interface AbonnementIDAO extends IDAO<Abonnement>{
	
	@Override
	public abstract ArrayList<Abonnement> findAll();
	@Override
	public abstract Abonnement getById(int id);
	@Override
	public abstract	boolean create(Abonnement abo);
	@Override
	public abstract	boolean update(Abonnement abo);
	@Override
	public abstract	boolean delete(Abonnement abo);
	
	public abstract ArrayList <Abonnement>getByClient(int id_client);
	public abstract ArrayList <Abonnement>getByRevue(int id_revue);
	public abstract ArrayList <Abonnement>getByDebut(String date_debut);
	public abstract ArrayList <Abonnement>getByFin(String date_fin);
	
	public abstract Abonnement getById(int idabo, int idrev);
}
=======
package daoobjects;
import daofactory.*;
import metiers.Abonnement;

public interface AbonnementIDAO extends IDAO<Abonnement>{
	public abstract Abonnement getById(int id_c, int id_r);
}
>>>>>>> 509b770864a6dee7ba0d4f0e59639ed62484fcc1
