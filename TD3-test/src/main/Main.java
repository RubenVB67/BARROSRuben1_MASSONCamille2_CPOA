package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import daofactory.DAOFactory;
import daofactory.Persistance;
import daoobjects.AbonnementIDAO;
import daoobjects.ClientIDAO;
import daoobjects.PeriodiciteIDAO;
import daoobjects.RevueIDAO;
import metiers.Abonnement;
import metiers.Client;
import metiers.Periodicite;
import metiers.Revue;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choixdao;
		DAOFactory daof = null;
		int ok = 1;
		while (ok == 1) {
			System.out.println("ListeMemoire --> 0\nMySQL  --> 1");
			do {
				choixdao = sc.nextInt();
			} while (choixdao != 0 && choixdao != 1);
			if (choixdao == 1)
				daof = DAOFactory.getDAOFactory(Persistance.Mysql);
			else if (choixdao == 0)
				daof = DAOFactory.getDAOFactory(Persistance.Liste);

			System.out.println("Quelle table :\n - Abonnement --> 1 \n - Client --> 2 \n - Periodicite --> 3 \n - Revue --> 4)");
			int choix = sc.nextInt();
			switch (choix) {
			case 1:
				menuAbo(daof);
				break;
			case 2:
				menuClient(daof.getClientDAO());
				break;
			case 3:
				menuPer(daof.getPeriodiciteDAO());
				break;
			case 4:
				menuRevue(daof);
				break;
			default:
				System.out.println("Pas compris le choix");
				break;
			}

			System.out.println("Fin de tache : \n - oui --> 0 \n - non --> 1");
			do {
				ok = sc.nextInt();
			} while (ok != 0 && ok != 1);

		}
		sc.close();
	}

	public static void menuAbo(DAOFactory a) {
		AbonnementIDAO m = a.getAbonnementDAO();
		RevueIDAO r = a.getRevueDAO();
		ClientIDAO c = a.getClientDAO();
		int choix;
		ArrayList<Integer> listeidcl = new ArrayList<Integer>();
		ArrayList<Integer> listeidrevcl = new ArrayList<Integer>();
		for (Abonnement abo : m.findAll())
			listeidcl.add(abo.getId_client());
		int idabo;
		int idrev;
		System.out.println("Que voulez vous faire ? (Ajouter 1,Modifier 2,Supprimer 3)");
		choix = nbonly();
		Abonnement generic = new Abonnement();
		if (choix != 1) {
			AfficheAbo(m);
			do {
				System.out.println("id de l'abonnement");
				idabo = nbonly();
				if (!listeidcl.contains(idabo))
					System.out.println("Cet id n'existe pas");
			} while (!listeidcl.contains(idabo));
			for (Abonnement abo : m.findAll())
				if (abo.getId_client() == idabo)
					listeidrevcl.add(abo.getId_revue());
			System.out.println(listeidrevcl.toString());
			do {
				System.out.println("id revue");
				idrev = nbonly();
				if (!listeidrevcl.contains(idrev))
					System.out.println("Ce client n'est pas abonné a cette revue");
			} while (!listeidrevcl.contains(idrev));
			generic = m.getById(idabo, idrev);
		}

		LocalDate datedeb;
		LocalDate datefin;

		if (choix == 1) {
			for (Revue rev : r.findAll())
				listeidrevcl.add(rev.getId_revue());
			for (Client cl : c.findAll())
				listeidcl.add(cl.getId());
			do {
				System.out.println("id du client :");
				AfficheCl(c);
				idabo = nbonly();
				if (!listeidcl.contains(idabo))
					System.out.println("Ce client n'existe pas");
			} while (!listeidcl.contains(idabo));
			do {
				System.out.println("date debut (annee/mois/jours)");
				datedeb = dateonly();
				System.out.println("date fin (annee/mois/jours)");
				datefin = dateonly();
			} while (!compdate(datedeb, datefin));

			do {
				System.out.println("numéro de la revue :");
				AfficheRev(r);
				idrev = nbonly();
				if (!listeidrevcl.contains(idrev))
					System.out.println("Cette revue n'existe pas");
			} while (!listeidrevcl.contains(idrev));
			m.create(new Abonnement(idabo, idrev, datedeb, datefin));

		} else if (choix == 2) {
			System.out.println("Que voulez vous modifier(date debut 1,date fin 2)");
			choix = nbonly();
			System.out.println("Donnez la date :");
			LocalDate date = dateonly();
			if (choix == 1) {
				generic.setDate_debut(date);
			} else if (choix == 2) {
				generic.setDate_fin(date);
			} else {
				System.out.println("Vous n'avez rien modifier");
			}
			m.update(generic);
		} else if (choix == 3) {
			m.delete(generic);
		}

	}

	private static boolean compdate(LocalDate d1, LocalDate d2) {

		if (d2.isBefore(d1)) {
			System.out.println("Mauvaises dates");
			return false;
		} else if (d1.getYear() > LocalDate.now().getYear()) {
			System.out.println("Annee de debut impossible");
			return false;
		} else

			return true;
	}

	public static void menuPer(PeriodiciteIDAO m) {
		int choix;
		ArrayList<Integer> Listeid = new ArrayList<Integer>();
		Periodicite generic = new Periodicite();
		int id;
		for (Periodicite c : m.findAll())
			Listeid.add(c.getId());

		System.out.println("Que voulez vous faire ? (Ajouter 1,Modifier 2,Supprimer 3)");
		choix = nbonly();

		if (choix != 1) {
			AffichePer(m);
			do {
				System.out.println("id de la période ? :");
				id = nbonly();
				if (!Listeid.contains(id))
					System.out.println("Cette id n'existe pas");
			} while (!Listeid.contains(id));
			generic = m.getById(id);
		}

		if (choix == 1) {
			System.out.println("Libelle");
			String libelle = textonly();
			m.create(new Periodicite(0, libelle));
		} else if (choix == 2) {
			System.out.println("Donnez le nouveau libelle :");
			String libelle = textonly();
			generic.setLibelle(libelle);
			m.update(generic);
		} else if (choix == 3) {
			m.delete(generic);
		}

	}

	public static void menuClient(ClientIDAO m) {
		int choix;
		ArrayList<Integer> Listeid = new ArrayList<Integer>();
		for (Client c : m.findAll())
			Listeid.add(c.getId());
		System.out.println("Que voulez vous faire ? (Ajouter 1,Modifier 2,Supprimer 3)");
		choix = nbonly();
		int id;
		Client generic = new Client();
		if (choix != 1) {
			AfficheCl(m);
			do {
				System.out.println("id du Client");
				id = nbonly();
				if (!Listeid.contains(id))
					System.out.println("Cette id n'existe pas");
			} while (!Listeid.contains(id));
			generic = m.getById(id);
		}

		if (choix == 1) {
			System.out.println("Nom");
			// textonly();
			String nom = textonly();
			System.out.println("Prenom");
			String prenom = textonly();
			System.out.println("numero rue");
			int norue = nbonly();
			System.out.println("voie");
			// textonly();
			String voie = textonly();
			System.out.println("code_postal");
			int codep = nbonly();
			System.out.println("ville");
			// textonly();
			String ville = textonly();
			System.out.println("pays");
			// textonly();
			String pays = textonly();

			m.create(new Client(0, nom, prenom, String.valueOf(norue), voie, String.valueOf(codep), ville, pays));
		} else if (choix == 2) {
			System.out.println(
					"Que voulez vous modifier(nom 1,prenom 2,numero rue 3,voie 4,code postal 5,ville 6,pays 7)");
			choix = nbonly();
			if (choix == 1) {
				System.out.println("Donnez le nouveau nom :");
				String nom = textonly();
				generic.setNom(nom);
			} else if (choix == 2) {
				System.out.println("Donnez le nouveau prenom :");
				String prenom = textonly();
				generic.setPrenom(prenom);
			} else if (choix == 3) {
				System.out.println("Donnez la nouvelle rue :");
				int rue = nbonly();
				generic.setNo_rue(String.valueOf(rue));
			} else if (choix == 4) {
				System.out.println("Donnez la nouvelle voie :");
				String voie = textonly();
				generic.setVoie(voie);
			} else if (choix == 5) {
				System.out.println("Donnez le nouveau code postal :");
				int codep = nbonly();
				generic.setCode_postal(String.valueOf(codep));
			} else if (choix == 6) {
				System.out.println("Donnez la nouvelle ville :");
				String ville = textonly();
				generic.setVille(ville);
			} else if (choix == 7) {
				System.out.println("Donnez le nouveau pays :");
				String pays = textonly();
				generic.setPays(pays);
			} else {
				System.out.println("Vous n'avez rien modifier");
			}
			m.update(generic);

		} else if (choix == 3) {
			m.delete(generic);
		}

	}

	public static void menuRevue(DAOFactory daof) {
		RevueIDAO m = daof.getRevueDAO();
		PeriodiciteIDAO p = daof.getPeriodiciteDAO();
		ArrayList<Integer> Listeid = new ArrayList<Integer>();
		for (Revue c : m.findAll())
			Listeid.add(c.getId_revue());
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choix;
		int id;
		Revue generic = new Revue();
		System.out.println("Que voulez vous faire ? (Ajouter 1,Modifier 2,Supprimer 3)");
		choix = nbonly();

		if (choix != 1) {
			AfficheRev(m);
			do {
				System.out.println("id de la revue :");
				id = nbonly();
				if (!Listeid.contains(id))
					System.out.println("Cette id n'existe pas");
			} while (!Listeid.contains(id));
			generic = m.getById(id);
		}

		// textonly();
		if (choix == 1) {
			ArrayList<Integer> listeperio = new ArrayList<Integer>();
			for (Periodicite per : p.findAll())
				listeperio.add(per.getId());
			System.out.println("titre :");
			String titre = textonly();
			// textonly();
			System.out.println("description	:");
			String desc = textonly();
			System.out.println("tarif :");
			double tarif = sc.nextDouble();
			// textonly();
			System.out.println("visuel :");
			String visuel = textonly();
			int idp;
			do {
				AffichePer(p);
				System.out.println("id periode :");
				idp = nbonly();
				if(!listeperio.contains(idp))
					System.out.println("Cette periode n'existe pas");
			} while (!listeperio.contains(idp));
			m.create(new Revue(0, titre, desc, tarif, visuel, idp));
		} else if (choix == 2) {
			System.out.println("Que voulez vous modifier(titre 1,description 2,tarif 3,visuel 4,periode 5)");
			choix = nbonly();
			if (choix == 1) {
				System.out.println("Donnez le nouveau titre :");
				String titre = textonly();
				generic.setTitre(titre);
			} else if (choix == 2) {
				System.out.println("Donnez la nouvelle Description :");
				String desc = textonly();
				generic.setDescription(desc);
			} else if (choix == 3) {
				System.out.println("Donnez le nouveau tarif :");
				double tarif = sc.nextDouble();
				generic.setTarif_numero(tarif);
			} else if (choix == 4) {
				System.out.println("Donnez le nouveau visuel (sans .jpg):");
				String visu = textonly();
				generic.setVisuel(visu+".jpg");
			} else if (choix == 5) {
				System.out.println("Donnez la nouvelle periode :");
				int idp = nbonly();
				generic.setId_periodicite(idp);
			} else {
				System.out.println("Vous n'avez rien modifier");
			}
			m.update(generic);

		} else if (choix == 3) {
			m.delete(generic);
		}

	}

	public static String textonly() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String txt = new String();
		do {
			txt = sc.nextLine();
			if (!txt.matches("[a-zA-z\\s]*"))
				System.out.println("Uniquement du texte reessayer");
		} while (!txt.matches("[a-zA-z\\s]*"));
		return txt;

	}

	public static LocalDate dateonly() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String txt = new String();
		ArrayList<String> ex = new ArrayList<String>();
		boolean sortie = false;
		txt.matches(".*\\d.*");
		char a = ' ';
		char b = '/';
		do {
			txt = sc.nextLine();
			if (!txt.contains("/"))
				System.out.println("Il n'y a pas de /");
			else {
				txt = txt.replace(b, a);
				if (!txt.matches("[0-9 ]+"))
					System.out.println("Uniquement des chiffres entre les /");
				else {
					for (String i : txt.split(" "))
						ex.add(i);
					if (ex.size() > 3)
						System.out.println("Trop de parametre");
					else if (Integer.parseInt(ex.get(2)) > 31 || Integer.parseInt(ex.get(2)) < 0
							|| Integer.parseInt(ex.get(1)) == 2 && Integer.parseInt(ex.get(2)) > 28)
						System.out.println("jours incorrecte");
					else if (Integer.parseInt(ex.get(1)) > 12 || Integer.parseInt(ex.get(2)) < 0)
						System.out.println("Mois incorrecte");
					else
						sortie = true;
				}
				if (!sortie)
					ex.clear();
			}

		} while (!sortie);
		// System.out.println(ex.toString());
		return LocalDate.of(Integer.parseInt(ex.get(0)), Integer.parseInt(ex.get(1)), Integer.parseInt(ex.get(2)));

	}

	public static int nbonly() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String txt = new String();
		do {
			txt = sc.nextLine();
			if (!txt.matches("[0-9]+"))
				System.out.println("Uniquement des chiffres reessayer");
		} while (!txt.matches("[0-9]+"));
		return Integer.parseInt(txt);

	}

	public static void AfficheAbo(AbonnementIDAO a) {
		System.out.println("Voici les abonnements disponibles :\n");
		for (Abonnement b : a.findAll())
			System.out.println(b.toString() + "\n");
	}

	public static void AfficheCl(ClientIDAO a) {
		System.out.println("Voici les clients disponibles :\n");
		for (Client b : a.findAll())
			System.out.println(b.toString() + "\n");
	}

	public static void AfficheRev(RevueIDAO a) {
		System.out.println("Voici les revues disponibles :\n");
		for (Revue b : a.findAll())
			System.out.println(b.toString() + "\n");
	}

	public static void AffichePer(PeriodiciteIDAO a) {
		System.out.println("Voici les periodes disponibles :\n");
		for (Periodicite b : a.findAll())
			System.out.println(b.toString() + "\n");
	}
		
}


