package daoobjects;
import java.util.ArrayList;

import daofactory.IDAO;
import metiers.Periodicite;

public interface PeriodiciteIDAO extends IDAO<Periodicite>{

	public abstract Periodicite getById(int id);
	

}
