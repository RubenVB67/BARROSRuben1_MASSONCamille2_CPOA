package daoobjects;
import java.util.ArrayList;

import daofactory.IDAO;
import metiers.Client;

public interface ClientIDAO extends IDAO<Client>{

	@Override
    public abstract ArrayList<Client> findAll();
	@Override
	public abstract Client getById(int id);
	@Override
	public abstract	boolean create(Client cli);
	@Override
	public abstract	boolean update(Client cli);
	@Override
	public abstract	boolean delete(Client cli);
	
	
	public abstract ArrayList <Client>getByNomPrenom(String nom,String prenom);
	public abstract ArrayList <Client>getByAdresse(int no_rue,String voie);
	public abstract ArrayList <Client>getByCodePostal(int codepostal);
	public abstract ArrayList <Client>getByVille(String ville);
	public abstract ArrayList <Client>getByPays(String Pays);
	
}
