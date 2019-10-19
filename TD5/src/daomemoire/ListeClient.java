package daomemoire;

import java.util.ArrayList;

import daoobjects.ClientIDAO;
import metiers.Client;

public class ListeClient implements ClientIDAO{

	private static ListeClient instance;

	private ArrayList<Client> ListeClient;
 
	public static ListeClient getInstance() {

		if (instance == null) {
			instance = new ListeClient();
		}

		return instance;
	}

	private ListeClient() {

		this.ListeClient = new ArrayList<Client>();
		this.ListeClient.add(new Client("MASSON", "Camille", 0));
		this.ListeClient.add(new Client("BARROS", "Ruben", 1));
	}

	@Override
	public ArrayList<Client> findAll() {
		return this.ListeClient;
	}

	@Override
	public boolean create(Client cli) {
		cli.setId(1);
		
		ArrayList<Integer> lic = new ArrayList<Integer>();
		for(Client c : this.ListeClient) lic.add(c.getId());
		
		while (lic.contains(cli.getId())) {

			cli.setId(cli.getId() + 1);
		}
		boolean ok = this.ListeClient.add(cli);
		
		return ok;
	}

	@Override
	public boolean update(Client cli) {
		int idx = this.ListeClient.indexOf(cli);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			this.ListeClient.set(idx, cli);
		}
		return true;
	}

	@Override
	public boolean delete(Client cli) {
		Client cl;

		int idx = this.ListeClient.indexOf(cli);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			cl = this.ListeClient.remove(idx);
		}
		return cli.equals(cl);
	}

	@Override
	public Client getById(int id) {
		Client cli = new Client();
		boolean trouve = false;
		int i = 0;
		while (trouve == false && i < this.ListeClient.size()) {
			if (this.ListeClient.get(i).getId() == id) {
				cli = this.ListeClient.get(i);
				trouve = true;
			} else
				i++;
		}
		if (i >= this.ListeClient.size()) {
			System.out.println("Pas de clients avec cet id_client");
			cli = null;
		}
		return cli;
	}
	
	
//---------------------------------- a faire plus tard -------------------------------------------------------------


	@Override
	public ArrayList<Client> getByNomPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByAdresse(int no_rue, String voie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByCodePostal(int codepostal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByVille(String ville) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Client> getByPays(String Pays) {
		// TODO Auto-generated method stub
		return null;
	}
}
