<<<<<<< HEAD
package daomemoire;

import java.util.ArrayList;
import java.util.List;

import daoobjects.PeriodiciteIDAO;
import metiers.Periodicite;

public class ListePeriodicite implements PeriodiciteIDAO{

	private static ListePeriodicite instance;
	private List<Periodicite> donnees;


	public static ListePeriodicite getInstance() {

		if (instance == null) {
			instance = new ListePeriodicite();
		}

		return instance;
	}

	private ListePeriodicite() {

		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Quotidien"));
		this.donnees.add(new Periodicite(2, "Hebdomadaire"));
		this.donnees.add(new Periodicite(3, "Mensuel"));
		this.donnees.add(new Periodicite(4, "Bimestriel"));
		this.donnees.add(new Periodicite(5, "Trimestriel"));
	}
	
	@Override
	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}

	@Override
	public boolean create(Periodicite per) {
		per.setId(1);
		
		ArrayList<Integer> lid = new ArrayList<Integer>();
		for(Periodicite p : this.donnees) lid.add(p.getId());
		
		while (lid.contains(per.getId())) {

			per.setId(per.getId() + 1);
		}
		boolean ok = this.donnees.add(per);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite per) {
		int idx = this.donnees.indexOf(per);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, per);
		}
		
		return true;
	}

	@Override
	public boolean delete(Periodicite per) {
		Periodicite supprime;
		int idx = this.donnees.indexOf(per);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return per.equals(supprime);
	}

	@Override
	public Periodicite getById(int id) {
		Periodicite perio = new Periodicite();
		boolean trouve=false;
		int i=0;
		while (trouve==false && i<this.donnees.size()){
			if (this.donnees.get(i).getId() == id) {
				perio = this.donnees.get(i);
				trouve=true;
				}
			else
				i++;			
		}
		if(i>=this.donnees.size()){
			System.out.println("Pas de periodicite avec cet id_periodicite");
			perio=null;}
		return perio;
	}

	
//---------------------------------- a faire plus tard -------------------------------------------------------------

	
	@Override
	public ArrayList<Periodicite> getByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
package daomemoire;

import java.util.ArrayList;
import java.util.List;

import daoobjects.PeriodiciteIDAO;
import metiers.Periodicite;

public class ListePeriodicite implements PeriodiciteIDAO{

	private static ListePeriodicite instance;
	private List<Periodicite> donnees;


	public static ListePeriodicite getInstance() {

		if (instance == null) {
			instance = new ListePeriodicite();
		}

		return instance;
	}

	private ListePeriodicite() {

		this.donnees = new ArrayList<Periodicite>();

		this.donnees.add(new Periodicite(1, "Mensuel"));
		this.donnees.add(new Periodicite(2, "Quotidien"));
	}
	
	@Override
	public ArrayList<Periodicite> findAll() {
		return (ArrayList<Periodicite>) this.donnees;
	}

	@Override
	public boolean create(Periodicite object) {
		object.setId(3);
		// Ne fonctionne que si l'objet m�tier est bien fait...
		while (this.donnees.contains(object)) {

			object.setId(object.getId() + 1);
		}
		boolean ok = this.donnees.add(object);
		
		return ok;
	}

	@Override
	public boolean update(Periodicite object) {
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, object);
		}
		
		return true;
	}

	@Override
	public boolean delete(Periodicite object) {
		Periodicite supprime;
		
		// Ne fonctionne que si l'objet m�tier est bien fait...
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return object.equals(supprime);
	}

	@Override
	public Periodicite getById(int id_perio) {
		Periodicite perio = new Periodicite();
		boolean trouve=false;
		int i=0;
		while (trouve==false && i<this.donnees.size()){
			if (this.donnees.get(i).getId() == id_perio) {
				perio = this.donnees.get(i);
				trouve=true;
				}
			else
				i++;			
		}
		if(i>=this.donnees.size()){
			System.out.println("Aucune p�riodicit� avec avec cet id");
			perio=null;}
		return perio;
	}

}
>>>>>>> 509b770864a6dee7ba0d4f0e59639ed62484fcc1
