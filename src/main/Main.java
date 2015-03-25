package main;

import java.rmi.RemoteException;

import entite.SiteImpl;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SiteImpl s1, s2, s3, s4, s5, s6;
		s1 = s2 = s3 = s4 = s5 = s6 = null;

		// Racine
		try {
			s1 = new SiteImpl(1, null);
			s2 = new SiteImpl(2, s1);
			s5 = new SiteImpl(5, s1);
			s6 = new SiteImpl(6, s5);
			s3 = new SiteImpl(3, s2);
			s4 = new SiteImpl(4, s2);

			s1.ajouterFils(s2);
			s1.ajouterFils(s5);
			s2.ajouterFils(s3);
			s2.ajouterFils(s4);
			s5.ajouterFils(s6);

			s1.transfererAuxFils("Bonjour".getBytes());

		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
