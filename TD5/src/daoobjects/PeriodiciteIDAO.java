package daoobjects;
import java.util.ArrayList;

import daofactory.IDAO;
import metiers.Periodicite;

public interface PeriodiciteIDAO extends IDAO<Periodicite>{

<<<<<<< HEAD
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
=======
	public abstract Periodicite getById(int id);
>>>>>>> 509b770864a6dee7ba0d4f0e59639ed62484fcc1
	

}
