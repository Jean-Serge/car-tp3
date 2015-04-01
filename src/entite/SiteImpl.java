package entite;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Cette classe implémente un Site pour cet exercice.
 * Un site implémente SiteItf et doit pouvoir envoyer et recevoir
 * des messages.
 * 
 * @author Jean-Serge Monbailly
 *
 */
public class SiteImpl extends UnicastRemoteObject implements SiteItf{

	/*
	 * ==========================================================================
	 * Constructeurs et attributs 
	 * ================================
	 */
	
	private static final long serialVersionUID = 7151500616352256347L;

	@SuppressWarnings("unused")
	private SiteItf pere;
	private SiteItf fils[];
	private int id;
	
	public SiteImpl() throws RemoteException {
		super();
	}
	
	/**
	 * Instancie un nouveau site avec un pere et une liste de fils.
	 * 
	 * @param pere le père du Site courant
	 * @param fils les files du Site courant
	 * @throws RemoteException 
	 */
	public void init(int id, SiteItf pere) throws RemoteException {
		this.pere = pere;
		this.id = id;
		this.fils = new SiteImpl[0];
	}

	/*
	 * ==========================================================================
	 * Fonctions implémentées 
	 * ================================
	 */
	
	/**
	 * Transfère les données passées en paramètre à chacun des fils 
	 * du site courant.
	 * 
	 * @param donnees le message à transmettre aux fils
	 * @throws RemoteException
	 */
	@Override
	public void transfererAuxFils(byte[] donnees) throws RemoteException{
		System.out.println();
		for(SiteItf s : fils){
			new TransfertThread(s, donnees).start();
		}
	}

	
	/**
	 * Permet à un Site de recevoir des données de son père.
	 * 
	 * @param donnees les données reçues du père
	 * @throws RemoteException 
	 */
	@Override
	public void recevoir(byte[] donnees) throws RemoteException {
		System.out.println("Le site n° " + id + " a reçu le message \n\""+ new String(donnees) + "\"");
		this.transfererAuxFils(donnees);
	}

	/*
	 * ==========================================================================
	 * Accesseurs 
	 * ================================
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * Permet d'ajouter une Site au tableau de fils du site courant.
	 * Pour cela, cette fonction réalloue le tableau de fils pour l'augmenter d'une case
	 * (contenant le nouveau fils).
	 * 
	 * @param fils le fils à ajouter au site courant
	 */
	@Override
	public void ajouterFils(SiteItf fils) throws RemoteException {
		SiteItf tmp[] = new SiteItf[this.fils.length + 1];
		
		for(int i = 0 ; i < this.fils.length ; i++)
			tmp[i] = this.fils[i];
		tmp[tmp.length -1] = fils;
		
		this.fils = tmp;
	}

}
