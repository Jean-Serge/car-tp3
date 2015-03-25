package entite;

public class SiteImpl implements SiteItf {

	/*
	 * ==========================================================================
	 * Constructeurs et attributs 
	 * ================================
	 */
	
	
	private SiteItf pere;
	private SiteItf fils[];
	private int id;
	
	/**
	 * Instancie un nouveau site avec un pere et une liste de fils.
	 * 
	 * @param pere le père du Site courant
	 * @param fils les files du Site courant
	 */
	public SiteImpl(int id, SiteItf pere, SiteItf[] fils) {
		super();
		this.pere = pere;
		this.fils = fils;
		this.id = id;
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
	 */
	@Override
	public void transfererAuxFils(byte[] donnees) {
		for(SiteItf s : fils){
			System.out.println("Transfert de données de " + id + " à " + s.getId());
			s.recevoir(donnees);
		}
	}

	
	/**
	 * Permet à un Site de recevoir des données de son père.
	 * 
	 * @param donnees les données reçues du père
	 */
	@Override
	public void recevoir(byte[] donnees) {
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

	
}
