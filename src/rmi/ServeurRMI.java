package rmi;

import java.rmi.AlreadyBoundException;
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
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws RemoteException,
			NotBoundException, AlreadyBoundException {
		
		/*
		 * Cette classe lance un serveur RMI et y ajoute les objets
		 * représentant l'arbre du sujet de TP.
		 */
		
		SiteItf s1;
		s1 = new SiteImpl();
		
		Registry registre = LocateRegistry
				.createRegistry(Tools.PORT_RMI_SERVEUR);
		
		registre.rebind("s1", s1);
		
	}

}
