package daomemoire;

import java.time.LocalDate;
import java.util.ArrayList;

import daoobjects.AbonnementIDAO;
import metiers.Abonnement;

public class ListeAbonnement implements AbonnementIDAO{
	private static ListeAbonnement instance;

	private ArrayList<Abonnement> ListeAbo;

	public static ListeAbonnement getInstance() {

		if (instance == null) {
			instance = new ListeAbonnement();
		}

		return instance;
	}

	private ListeAbonnement() {
		this.ListeAbo = new ArrayList<Abonnement>();
		this.ListeAbo.add(new Abonnement(1, 2, LocalDate.of(2015, 9, 28), LocalDate.of(2015, 9, 30)));
		this.ListeAbo.add(new Abonnement(1, 1, LocalDate.of(2032, 9, 23), LocalDate.of(2033, 1, 1)));
		this.ListeAbo.add(new Abonnement(2, 3, LocalDate.of(1998, 5, 30), LocalDate.of(1998, 7, 3)));
	}

	@Override
	public ArrayList<Abonnement> findAll() {
		return this.ListeAbo;
	}

	@Override
	public boolean create(Abonnement abo) {
		boolean ok = this.ListeAbo.add(abo);
		return ok;

	}

	@Override
	public boolean update(Abonnement abo) {
		int idx = this.ListeAbo.indexOf(abo);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			this.ListeAbo.set(idx, abo);
		}
		return true;
	}

	@Override
	public boolean delete(Abonnement abo) {
		Abonnement abon = null;

		int idx = this.ListeAbo.indexOf(abo);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			abo = this.ListeAbo.remove(idx);
		}
		return abo.equals(abon);
	}

	public Abonnement getById(int id_c, int id_r) {
		Abonnement abo = new Abonnement();
		boolean trouve = false;
		int i = 0;
		while (trouve == false && i < this.ListeAbo.size()) {
			if (this.ListeAbo.get(i).getId_client() == id_c && this.ListeAbo.get(i).getId_revue() == id_r) {
				abo = this.ListeAbo.get(i);
				trouve = true;
			} else
				i++;
		}
		if (!trouve) {
			System.out.println("Pas d'abonnement avec ces ids");
			abo = null;
		}
		return abo;
	}

	@Override
	public Abonnement getById(int id) {
		return null; // on la neutralise elle ne sert a rien car on a 2 PK dans cette table
	}
	
//---------------------------------- a faire plus tard -------------------------------------------------------------


	@Override
	public ArrayList<Abonnement> getByClient(int id_client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByRevue(int id_revue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByDebut(String date_debut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Abonnement> getByFin(String date_fin) {
		// TODO Auto-generated method stub
		return null;
	}
}
