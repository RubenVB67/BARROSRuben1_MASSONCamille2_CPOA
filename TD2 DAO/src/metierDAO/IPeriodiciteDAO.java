package metierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Client;
import metiers.Periodicite;

public interface IPeriodiciteDAO extends IDAO<Periodicite>{

	
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
