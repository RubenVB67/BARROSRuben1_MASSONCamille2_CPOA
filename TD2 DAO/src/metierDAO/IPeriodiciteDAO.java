package metierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Periodicite;

public interface IPeriodiciteDAO extends IDAO<Periodicite>{

	public abstract ArrayList <Periodicite>getByLibelle(String libelle);
	
}
