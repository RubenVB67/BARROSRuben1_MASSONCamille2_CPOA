package daoobjects;
import java.util.ArrayList;

import daofactory.IDAO;
import metiers.Revue;

public interface RevueIDAO extends IDAO<Revue>{

	@Override
    public abstract ArrayList<Revue> findAll();
	@Override
	public Revue getById(int id);
	@Override
	public abstract	boolean create(Revue rev);
	@Override
	public abstract boolean update(Revue rev);
	@Override
	public abstract boolean delete(Revue rev);
	
	
	public abstract ArrayList <Revue>getByTitre(String titre);
	public abstract ArrayList <Revue>getByDescription(String description);
	public abstract ArrayList <Revue>getByTarif(int tarif_numero);
	public abstract ArrayList <Revue>getByVisuel(String visuel);
	public abstract ArrayList <Revue>getByPeriodicite(int id_periodicite);
	
}
