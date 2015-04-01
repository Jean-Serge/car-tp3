package entite;

import java.rmi.RemoteException;

public class TransfertThread extends Thread {

	/*
	 * ==========================================================================
	 * Constructeurs et attributs ================================
	 */
	private SiteItf cible;
	private byte[] donnees;

	public TransfertThread(SiteItf cible, byte[] donnees) {
		this.cible = cible;
		this.donnees = donnees;
	}

	/*
	 * ==========================================================================
	 * Fonctions surchargées ================================
	 */
	/**
	 * Le Thread doit permettre d'envoyer un message à une cible spécifié.
	 */
	public void run() {
		try {
			if (!this.cible.estVisitee()) {
				System.out.println("Transfert de données à " + cible.getId());
				this.cible.recevoir(donnees);
			}
		} catch (RemoteException e) {
			System.out
					.println("Problème lors de la communication avec la cible.");
		}
	}
}
