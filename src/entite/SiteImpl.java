package entite;

public class SiteImpl implements SiteItf {

	/*
	 * ==========================================================================
	 * Constructeurs et attributs 
	 * ================================
	 */
	
	private SiteImpl pere;
	private SiteImpl fils[];
	private int id;
	
	/**
	 * Instancie un nouveau site avec un pere et une liste de fils.
	 * 
	 * @param pere le père du Site courant
	 * @param fils les files du Site courant
	 */
	public SiteImpl(int id, SiteImpl pere) {
		super();
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
	 */
	@Override
	public void transfererAuxFils(byte[] donnees) {
		System.out.println();
		for(SiteImpl s : fils){
			System.out.println("Transfert de données de " + id + " à " + s.getId());
			System.out.println("Données envoyées : \n\"" + new String(donnees) + "\"");
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

	/**
	 * Permet d'ajouter une Site au tableau de fils du site courant.
	 * Pour cela, cette fonction réalloue le tableau de fils pour l'augmenter d'une case
	 * (contenant le nouveau fils).
	 * 
	 * @param fils le fils à ajouter au site courant
	 */
	@Override
	public void ajouterFils(SiteItf fils) {
		SiteImpl tmp[] = new SiteImpl[this.fils.length + 1];
		
		for(int i = 0 ; i < this.fils.length ; i++)
			tmp[i] = this.fils[i];
		tmp[tmp.length -1] = (SiteImpl) fils;
		
		this.fils = tmp;
	}

}
