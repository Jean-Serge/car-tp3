package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entite.SiteItf;

import utils.Tools;

public class ClientRMI {

	/**
	 * Cette classe sert de client au Serveur RMI lancé au préalable.
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		/*
		 * Ce client se connecte au Serveur RMI pour récupérer s1 (la racine de
		 * l'arbre). Il lui envoie ensuite un message et on peut constater le
		 * résultat.
		 */
		
		Registry r;

		r = LocateRegistry.getRegistry(Tools.PORT_RMI_SERVEUR);
		SiteItf s1 = (SiteItf) r.lookup("s1");
		s1.transfererAuxFils("Bonjour".getBytes());

	}

}
