package daomemoire;

import java.util.ArrayList;
import java.util.List;

import daoobjects.RevueIDAO;
import metiers.Revue;

public class ListeRevue implements RevueIDAO{

	private static ListeRevue instance;
	private List<Revue> donnees;

 
	public static ListeRevue getInstance() {

		if (instance == null) {
			instance = new ListeRevue();
		}

		return instance;
	}

	private ListeRevue() {

		this.donnees = new ArrayList<Revue>();

		this.donnees.add(new Revue(1,"Mega revue","Une revue enorme",2.0, "Megarevue.jpg",1));
		this.donnees.add(new Revue(2,"Bof revue","Une revue pas ouf",2.0, "bof.jpg",2));
	}
	
	@Override
	public ArrayList<Revue> findAll() {
		return (ArrayList<Revue>) this.donnees;

	}

	@Override
	public boolean create(Revue object) {
		while (this.donnees.contains(object)) {

			object.setId_revue(object.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(object);
		
		return ok;
	}

	@Override
	public boolean update(Revue object) {
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, object);
		}
		
		return true;
	}

	@Override
	public boolean delete(Revue object) {
		Revue supprime;
		
		// Ne fonctionne que si l'objet metier est bien fait...
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return object.equals(supprime);
	}

	@Override
	public Revue getById(int id_r) {
		Revue client = new Revue();
		boolean trouve=false;
		int i=0;
		while (trouve==false && i<this.donnees.size()){
			if (this.donnees.get(i).getId_revue() == id_r) {
				client = this.donnees.get(i);
				trouve=true;
				}
			else
				i++;			
		}
		if(i>=this.donnees.size()){
			System.out.println("Aucune periodicite avec avec cet id");
			client=null;}
		return client;
	}

}
