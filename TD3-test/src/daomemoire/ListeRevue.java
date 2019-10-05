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

		this.donnees.add(new Revue(1,"Le monde","journal du soir",1.5, "lemonde.jpg",1));
		this.donnees.add(new Revue(2,"Charlie Hebdo","journal satirique",2.0, "charliehebdo.jpg",2));
		this.donnees.add(new Revue(3,"Spirou","Humour et bandes dessinees, retrouvez tous les heros des ?ditions Dupuis",2.2, "spirou.jpg",2));
		this.donnees.add(new Revue(4,"Programmez","Revue d'informatique orientee vers le developpement d'applications",3.5, "programmez.jpg",3));
	}
	
	@Override
	public ArrayList<Revue> findAll() {
		return (ArrayList<Revue>) this.donnees;

	}

	@Override
	public boolean create(Revue rev) {
		while (this.donnees.contains(rev)) {

			rev.setId_revue(rev.getId_revue() + 1);
		}
		boolean ok = this.donnees.add(rev);
		
		return ok;
	}

	@Override
	public boolean update(Revue rev) {
		int idx = this.donnees.indexOf(rev);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, rev);
		}
		
		return true;
	}

	@Override
	public boolean delete(Revue rev) {
		Revue supprime;

		int idx = this.donnees.indexOf(rev);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return rev.equals(supprime);
	}

	@Override
	public Revue getById(int id) {
		Revue client = new Revue();
		boolean trouve=false;
		int i=0;
		while (trouve==false && i<this.donnees.size()){
			if (this.donnees.get(i).getId_revue() == id) {
				client = this.donnees.get(i);
				trouve=true;
				}
			else
				i++;			
		}
		if(i>=this.donnees.size()){
			System.out.println("Pas de revue avec cet id_revue");
			client=null;}
		return client;
	}
	
	
//---------------------------------- a faire plus tard -------------------------------------------------------------	
	

	@Override
	public ArrayList<Revue> getByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByTarif(int tarif_numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByVisuel(String visuel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Revue> getByPeriodicite(int id_periodicite) {
		// TODO Auto-generated method stub
		return null;
	}

}
