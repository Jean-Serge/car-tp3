package entite;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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

	private List<SiteItf> voisins;
	private int id;
	private boolean estVisite = false;
	
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
		this.id = id;
		this.voisins = new ArrayList<SiteItf>();
		
		if(pere != null){
			this.voisins.add(pere);
			pere.getVoisins().add(this);
		}
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
	 * @param donnees le message à transmettre aux sites connectés
	 * @throws RemoteException
	 */
	@Override
	public void transfererAuxFils(byte[] donnees) throws RemoteException{
		List<TransfertThread> threads = new ArrayList<TransfertThread>();

		for(SiteItf s : voisins){
			threads.add(new TransfertThread(s, donnees));
			threads.get(threads.size()-1).start();
		}
		
		for(Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("Le thread a été interrompu.");
			}
		}
		synchronized(this){
			this.estVisite = false;
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
		if(this.estVisite)
			return;
		System.out.println("Le site n° " + id + " a reçu le message \n\""+ new String(donnees) + "\"");
		synchronized(this){
			this.estVisite = true;
		}
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
	 * Permet de connecter un site au site courant.
	 * 
	 * @param site le site à ajouter au site courant
	 */
	@Override
	public void ajouterSite(SiteItf site) throws RemoteException {
		if(!site.getVoisins().contains(this))
			site.getVoisins().add(this);
		if(!this.voisins.contains(site))
			this.voisins.add(site);
	}

	@Override
	public List<SiteItf> getVoisins() throws RemoteException {
		return this.voisins;
	}
	
//	@Override
//	public boolean estVisitee(){
//			return this.estVisite;
//	}

}
