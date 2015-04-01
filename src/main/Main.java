package main;

import java.rmi.RemoteException;

import entite.SiteImpl;

/**
 * Cette classe permet de tester le fonctionnement générique des sites
 * sans prendre en compte l'implémentation RMI.
 * 
 * @author Jean-Serge Monbailly
 */
public class Main {

	public static void main(String[] args) {
		SiteImpl s1, s2, s3, s4, s5, s6;
		
		// Création de tout les sites et ajout au serveur 
		try {
			s1 = new SiteImpl();
			s2 = new SiteImpl();
			s5 = new SiteImpl();
			s6 = new SiteImpl();
			s3 = new SiteImpl();
			s4 = new SiteImpl();

			s1.init(1, null);
			s2.init(2, s1);
			s5.init(5, s1);
			s6.init(6, s5);
			s3.init(3, s2);
			s4.init(4, s2);
			
			s1.ajouterFils(s2);
			s1.ajouterFils(s5);
			s2.ajouterFils(s3);
			s2.ajouterFils(s4);
			s5.ajouterFils(s6);

			s1.transfererAuxFils("Bonjour".getBytes());

		} catch (RemoteException e) {
			System.out.println("Problème de connexion au poste distant.");
			e.printStackTrace();
		}
	}

}
