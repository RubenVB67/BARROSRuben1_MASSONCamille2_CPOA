package daoobjects;
import daofactory.*;
import metiers.Abonnement;

public interface AbonnementIDAO extends IDAO<Abonnement>{
	public abstract Abonnement getById(int id_c, int id_r);
}
