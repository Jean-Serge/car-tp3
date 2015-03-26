package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entite.SiteImpl;
import entite.SiteItf;

import utils.Tools;

public class ClientRMI {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry r;
		
		r = LocateRegistry.getRegistry(Tools.PORT_RMI_SERVEUR);
		SiteItf s1 = (SiteItf) r.lookup("s1");
		s1.transfererAuxFils("Bonjour".getBytes());

	}

}
