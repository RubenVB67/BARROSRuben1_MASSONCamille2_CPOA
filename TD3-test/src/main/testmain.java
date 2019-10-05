package main;

import java.time.LocalDate;

import daofactory.DAOFactory;
import daofactory.Persistance;
import metiers.Abonnement;

public class testmain {

	public static void main(String[] args) {
		DAOFactory daof=DAOFactory.getDAOFactory(Persistance.Mysql);
		daof.getAbonnementDAO().create(new Abonnement(1, 1, LocalDate.of(1999, 9, 29), LocalDate.of(2002, 5, 3)));
		Abonnement M=daof.getAbonnementDAO().getById(1,1);
		System.out.println(M.toString());
		M.setDate_debut(LocalDate.of(1999,1,22));
		daof.getAbonnementDAO().update(M);
		System.out.println(daof.getAbonnementDAO().findAll().toString());
		daof.getAbonnementDAO().delete(M);
	}

}
