package entite;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SiteItf extends Remote{
	
	public void transfererAuxFils(byte[] donnees) throws RemoteException;
	
	public void recevoir(byte[] donnees) throws RemoteException;
	
	public void ajouterFils(SiteItf fils) throws RemoteException;
}
