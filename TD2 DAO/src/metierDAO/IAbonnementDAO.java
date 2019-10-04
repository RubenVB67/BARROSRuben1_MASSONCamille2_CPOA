package metierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Abonnement;

public interface IAbonnementDAO extends IDAO<Abonnement>{
	
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

}
