package metierDAO;

import java.util.ArrayList;

import dao.IDAO;
import metiers.Abonnement;
import metiers.Client;

public interface IClientDAO extends IDAO<Client>{
	
	
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
