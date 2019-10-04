package daoobjects;
import java.util.ArrayList;

import daofactory.IDAO;
import metiers.Periodicite;

public interface PeriodiciteIDAO extends IDAO<Periodicite>{

	@Override
    public abstract ArrayList<Periodicite> findAll();
	@Override
	public abstract Periodicite getById(int id);
	@Override
	public abstract	boolean create(Periodicite per);
	@Override
	public abstract	boolean update(Periodicite per);
	@Override
	public abstract	boolean delete(Periodicite per);
	
	
	public abstract ArrayList <Periodicite>getByLibelle(String libelle);
	

}
