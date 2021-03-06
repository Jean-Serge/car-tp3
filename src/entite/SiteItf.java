package entite;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface représentant un Site dans cet exercice.
 * Un site doit pouvoir envoyer et recevoir des messages.
 * Un site a un ou plusieurs père.
 * L'envoi de messages se fait en parallèle pour chacun de ses fils.
 * 
 * @author Jean-Serge Monbailly
 *
 */
public interface SiteItf extends Remote{
	
	public void init(int id) throws RemoteException;
	
	public void transfererAuxFils(byte[] donnees) throws RemoteException;
	
	public void recevoir(byte[] donnees) throws RemoteException;
	
	public void ajouterSite(SiteItf fils) throws RemoteException;
	
	public int getId() throws RemoteException;

	public List<SiteItf> getVoisins() throws RemoteException;
}
