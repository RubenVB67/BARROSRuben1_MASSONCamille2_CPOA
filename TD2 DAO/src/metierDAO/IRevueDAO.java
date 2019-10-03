package metierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Revue;


public interface IRevueDAO extends IDAO<Revue>{

	@Override
	public abstract Revue getById(int id_revue);
	
	public abstract ArrayList <Revue>getByTitre(String titre);
	public abstract ArrayList <Revue>getByDescription(String description);
	public abstract ArrayList <Revue>getByTarif(int tarif_numero);
	public abstract ArrayList <Revue>getByVisuel(String visuel);
	public abstract ArrayList <Revue>getByPeriodicite(int id_periodicite);
	
}
