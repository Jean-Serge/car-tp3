package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entite.SiteImpl;
import entite.SiteItf;
import utils.Tools;

/**
 * Cette classe permet de lancer un serveur RMI et d'y 
 * ajouter des sites.
 * 
 * @author Jean-Serge Monbailly
 *
 */
public class ServeurRMI {

	public static void main(String[] args){
		Registry registre;
		SiteItf s1, s2, s3, s4, s5, s6;

		try {
			// Création du serveur RMI
			registre = LocateRegistry.createRegistry(Tools.PORT_RMI_SERVEUR);

			// Ajout des objets au serveur
			s1 = new SiteImpl();
			s2 = new SiteImpl();
			s5 = new SiteImpl();
			s6 = new SiteImpl();
			s3 = new SiteImpl();
			s4 = new SiteImpl();

			s1.init(1);
			s2.init(2);
			s5.init(5);
			s6.init(6);
			s3.init(3);
			s4.init(4);

			s1.ajouterSite(s2);
			s1.ajouterSite(s5);
			s2.ajouterSite(s5);
//			s2.ajouterSite(s3);
//			s2.ajouterSite(s4);
//			s5.ajouterSite(s6);
//			s4.ajouterSite(s6);

			registre.rebind("s1", s1);
			registre.rebind("s2", s2);
//			registre.rebind("s3", s3);
//			registre.rebind("s4", s4);
//			registre.rebind("s5", s5);
//			registre.rebind("s6", s6);

		} catch (RemoteException e) {
			System.out
					.println("Problème de communication avec le poste distant.");
		}
	}
}
