package entite;

import java.rmi.RemoteException;

public class TransfertThread extends Thread {

	private SiteItf cible;
	private byte[] donnees;

	public TransfertThread(SiteItf cible, byte[] donnees) {
		this.cible = cible;
		this.donnees = donnees;
	}

	public void run() {
		try {
			System.out.println("Transfert de données à " + cible.getId());
			System.out.println("Données envoyées : \n\"" + new String(donnees) + "\"\n");
			this.cible.recevoir(donnees);
		} catch (RemoteException e) {
			System.out.println("Problème lors de la communication avec la cible.");
		}
	}
}
