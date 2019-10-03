package ImetierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Periodicite;

public interface IPeriodiciteDAO extends IDAO<Periodicite>{

	@Override
	public abstract Periodicite getById(int id_periodicite);
	
	public abstract ArrayList <Periodicite>getByLibelle(String libelle);
	
}
