package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entite.SiteImpl;
import entite.SiteItf;
import utils.Tools;

public class ServeurRMI {

	/**
	 * Cette classe permet de lancer un serveur RMI.
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		
		/*
		 * Cette classe lance un serveur RMI et y ajoute les objets
		 * représentant l'arbre du sujet de TP.
		 */
		SiteItf s1, s2, s3, s4, s5, s6;
		s1 = s2 = s3 = s4 = s5 = s6 = null;

		s1 = new SiteImpl();
		s2 = new SiteImpl();
		s5 = new SiteImpl();
		s6 = new SiteImpl();
		s3 = new SiteImpl();
		s4 = new SiteImpl();

		Registry registre = LocateRegistry
				.createRegistry(Tools.PORT_RMI_SERVEUR);
		registre.rebind("s1", s1);
		registre.rebind("s2", s2);
		registre.rebind("s3", s3);
		registre.rebind("s4", s4);
		registre.rebind("s5", s5);
		registre.rebind("s6", s6);

	

	}

}
