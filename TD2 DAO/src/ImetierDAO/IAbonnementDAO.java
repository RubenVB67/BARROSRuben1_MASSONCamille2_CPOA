package ImetierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Abonnement;

public interface IAbonnementDAO extends IDAO<Abonnement>{
	
	public abstract ArrayList <Abonnement>getByClient(int id_client);
	public abstract ArrayList <Abonnement>getByRevue(int id_revue);
	public abstract ArrayList <Abonnement>getByDebut(String date_debut);
	public abstract ArrayList <Abonnement>getByFin(String date_fin);

}
