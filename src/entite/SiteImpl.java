package entite;

public class SiteImpl implements SiteItf {

	private SiteItf pere;
	private SiteItf fils[];
	
	/**
	 * Instancie un nouveau site avec un pere et une liste de fils.
	 * 
	 * @param pere le père du Site courant
	 * @param fils les files du Site courant
	 */
	public SiteImpl(SiteItf pere, SiteItf[] fils) {
		super();
		this.pere = pere;
		this.fils = fils;
	}

	@Override
	public void transfererAuxFils(byte[] donnees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recevoir(byte[] donnees) {
		// TODO Auto-generated method stub
		
	}

}
