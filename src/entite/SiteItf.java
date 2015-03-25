package entite;

public interface SiteItf {
	
	public void transfererAuxFils(byte[] donnees);
	
	public void recevoir(byte[] donnees);
	
	public void ajouterFils(SiteItf fils);
}
