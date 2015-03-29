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
		
		SiteItf s1, s2, s3, s4, s5, s6;
		Registry registre;

		registre = LocateRegistry.getRegistry(Tools.PORT_RMI_SERVEUR);

		s1 = ((SiteItf) registre.lookup("s1"));
		s2 = ((SiteItf) registre.lookup("s2"));
		s3 = ((SiteItf) registre.lookup("s3"));
		s4 = ((SiteItf) registre.lookup("s4"));
		s5 = ((SiteItf) registre.lookup("s5"));
		s6 = ((SiteItf) registre.lookup("s6"));

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
	}

}
