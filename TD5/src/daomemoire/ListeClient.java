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
	public boolean create(Client object) {
		if (this.ListeClient.size() == 0) {
			object.setId(0);
		} else {
			int id = this.ListeClient.get(this.ListeClient.size() - 1).getId() + 1;
			object.setId(id);
		}

		boolean ok = this.ListeClient.add(object);
		return ok;
	}

	@Override
	public boolean update(Client object) {
		int idx = this.ListeClient.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			this.ListeClient.set(idx, object);
		}
		return true;
	}

	@Override
	public boolean delete(Client object) {
		Client cl;

		int idx = this.ListeClient.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			cl = this.ListeClient.remove(idx);
		}
		return object.equals(cl);
	}

	@Override
	public Client getById(int id_c) {
		Client cl = new Client();
		boolean trouve = false;
		int i = 0;
		while (trouve == false && i < this.ListeClient.size()) {
			if (this.ListeClient.get(i).getId() == id_c) {
				cl = this.ListeClient.get(i);
				trouve = true;
			} else
				i++;
		}
		if (i >= this.ListeClient.size()) {
			System.out.println("Aucun ClientM avec cet id");
			cl = null;
		}
		return cl;
	}
}
