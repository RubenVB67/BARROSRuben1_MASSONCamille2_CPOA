package daoobjects;
import daofactory.IDAO;
import metiers.Client;

public interface ClientIDAO extends IDAO<Client>{
	public abstract Client getById(int id_c);
}
