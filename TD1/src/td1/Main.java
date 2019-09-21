package td1;
import java.sql.Date;
import java.util.Scanner;

import objets.Abonnement;
import objets.Client;
import objets.Periodicite;
import objets.Revue;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) 
	{
		menu();
	}
		
		public static void menu(){
		Abonnement abo = new Abonnement(0, 0, null, null);
		Client cl = new Client(0,"","",0,"",0,"","");
		Periodicite perio = new Periodicite(0,"");
		Revue rev = new Revue(0,"","",0,"",0);
		Scanner sc = new Scanner(System.in);
		System.out.println("Sur quelle table voulez vous faire une opération");
		System.out.println("1: Abonnement (Appuyer sur 1)");
		System.out.println("2: Client (Appuyer sur 2)");
		System.out.println("3: Periodicite (Appuyer sur 3)");
		System.out.println("4: Revue (Appuyer sur 4)");
		int choixtable = sc.nextInt();
		switch(choixtable)
		{
			
			case 1:
				System.out.println("Quelles opération voulez vous faire ?");
				System.out.println("===1===: Ajouter");
				System.out.println("===2===: Modifier");
				System.out.println("===3===: Supprimer");
				System.out.println("===4===: Retour");
				int choixop = sc.nextInt();
				
				switch(choixop)
				{
					case 1:
						System.out.println("Mettez l'id client");
						int idcl = sc.nextInt();
						System.out.println("Mettez l'id revue");
						int idrev = sc.nextInt();
						System.out.println("Mettez la date de debut dans ce format -> (annee-mois-jour)");
						sc.nextLine();
						String ddeb = sc.next();
						System.out.println("Mettez la date de fin dans ce format -> (annee-mois-jour)");
						String dfin = sc.nextLine();
						abo.Ajouter(idcl, idrev, ddeb,dfin);
						
						break;
					case 2:
						System.out.println("Spécifier votre id client");
						int idclabo = sc.nextInt();
						System.out.println("Spécifier votre id revue");
						int idrevabo = sc.nextInt();
						System.out.println("Mettez la date de debut a modifier");
						sc.nextLine();
						String ddebabo = sc.nextLine();
						System.out.println("Mettez la date de fin a modifier");
						String dfinabo = sc.nextLine();
						abo.Modifier(idclabo, idrevabo, ddebabo,dfinabo);
						break;
					case 3:
						System.out.println("Spécifier votre id client");
						int idclabosuppr = sc.nextInt();
						System.out.println("Spécifier votre id revue");
						int idrevabosuppr = sc.nextInt();
						abo.Supprimer(idclabosuppr, idrevabosuppr);
						break;
					case 4:
						menu();
						break;
				}
	
				break;
			case 2:
				System.out.println("Quelles opération voulez vous faire ?");
				System.out.println("===1===: Ajouter");
				System.out.println("===2===: Modifier");
				System.out.println("===3===: Supprimer");
				System.out.println("===4===: Retour");
				int choixop1 = sc.nextInt();
				
				
				switch(choixop1)
				{
					case 1:
						System.out.println("Mettez l'id_client");
						int idcl = sc.nextInt();
						System.out.println("Mettez le nom du client");
						sc.nextLine();
						String nomcl = sc.nextLine();
						System.out.println("Mettez le prenom du client");
						String prenomcl = sc.nextLine();
						System.out.println("Mettez le numéro de la rue du client");
						int numruecl = sc.nextInt();
						System.out.println("Mettez le nom de la voie du client");
						sc.nextLine();
						String voiecl = sc.nextLine();
						System.out.println("Mettez le code postal du client");
						int cpcl = sc.nextInt();
						System.out.println("Mettez la ville du client");
						sc.nextLine();
						String villecl = sc.nextLine();
						System.out.println("Mettez le pays du client");
						String payscl = sc.nextLine();
						cl.Ajouter(idcl, nomcl, prenomcl, numruecl, voiecl, cpcl, villecl, payscl);
						break;
					case 2:
						System.out.println("Spécifier votre id client");
						int idclmodif = sc.nextInt();
						System.out.println("Mettez le nom a modifier");
						sc.nextLine();
						String nomclmodif = sc.nextLine();
						System.out.println("Mettez le prenom a modifier");
						String prenomclmodif = sc.nextLine();
						System.out.println("Mettez le numéro de la rue a modifier");
						int rueclmodif = sc.nextInt();
						System.out.println("Mettez votre voie a modifier");
						sc.nextLine();
						String voie  = sc.nextLine();
						System.out.println("Mettez le code postal a modifier");
						int cp = sc.nextInt();
						System.out.println("Mettez la ville a modifier");
						sc.nextLine();
						String ville = sc.nextLine();
						System.out.println("Mettez le pays a modifier");
						String pays = sc.nextLine();
						cl.Modifier(idclmodif,nomclmodif,prenomclmodif,rueclmodif,voie,cp,ville,pays);
						break;
					case 3:
						System.out.println("Spécifier votre id client");
						int idclsuppr = sc.nextInt();
						cl.Supprimer(idclsuppr);
						break;
					case 4:
						menu();
						break;
				}
				break;
			case 3:
				System.out.println("Quelles opération voulez vous faire ?");
				System.out.println("===1===: Ajouter");
				System.out.println("===2===: Modifier");
				System.out.println("===3===: Supprimer");
				System.out.println("===4===: Retour");
				int choixop2 = sc.nextInt();
				
				switch(choixop2)
				{
					case 1:
						System.out.println("Mettez l'id periodicite");
						int idp = sc.nextInt();
						System.out.println("Mettez le libellea a ajouter");
						sc.nextLine();
						String libperio = sc.nextLine();
						perio.Ajouter(idp, libperio);
						break;
					case 2:
						System.out.println("Spécifier l'id périodicité");
						int idpmodif = sc.nextInt();
						System.out.println("Mettez le libelle a modifier");
						sc.nextLine();
						String libperiomodif = sc.nextLine();
						perio.Modifier(idpmodif,libperiomodif);
						break;
					case 3:
						System.out.println("Spécifier l'id periodicite");
						int idpperiosuppr = sc.nextInt();
						perio.Supprimer(idpperiosuppr);
						break;
					case 4:
						menu();
						break;
				}
				
				
				break;
			case 4:
				System.out.println("Quelles opération voulez vous faire ?");
				System.out.println("===1===: Ajouter");
				System.out.println("===2===: Modifier");
				System.out.println("===3===: Supprimer");
				System.out.println("===4===: Retour");
				int choixop3 = sc.nextInt();
				
				switch(choixop3)
				{
					case 1:
						System.out.println("Mettez l'id revue");
						int idrev = sc.nextInt();
						System.out.println("Mettez le titre de la revue");
						sc.nextLine();
						String titrerev = sc.nextLine();
						System.out.println("Mettez la description la revue");
						String descrev = sc.nextLine();
						System.out.println("Mettez le tarif");
						int tarifnumrev = sc.nextInt();
						System.out.println("Mettez le nom du visuel de la revue");
						sc.nextLine();
						String visuelrev = sc.nextLine();
						System.out.println("Mettez l'id de la periodicite");
						int idperiorev = sc.nextInt();
						rev.Ajouter(idrev,titrerev,descrev,tarifnumrev, visuelrev,idperiorev);
						
						break;
					case 2:
						System.out.println("Spécifier votre id revue");
						int idrevmodif = sc.nextInt();
						System.out.println("Mettez le titre a Modifier");
						sc.nextLine();
						String titrevmodif = sc.nextLine();
						System.out.println("Mettez le prenom a Modifier");
						String descrevmodif = sc.nextLine();
						System.out.println("Mettez le numéro de la rue a Modifier");
						int tarifrevmodif = sc.nextInt();
						System.out.println("Mettez votre voie a Modifier");
						sc.nextLine();
						String visuelrevmodif  = sc.nextLine();
						System.out.println("Mettez le code postal a Modifier");
						int idrevperiomodif = sc.nextInt();
						rev.Modifier(idrevmodif,titrevmodif,descrevmodif,tarifrevmodif,visuelrevmodif,idrevperiomodif);
						
						break;
					case 3:
						System.out.println("Spécifier l'id revue");
						int idrevuesuppr = sc.nextInt();
						rev.Supprimer(idrevuesuppr);
						break;
					case 4:
						menu();
						break;
				}
				
					break;
			}
		
		
		}
}
	



