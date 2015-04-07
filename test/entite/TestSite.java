package entite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class TestSite {

	private SiteItf s1, s2, s3, s4, s5, s6;

	@Before
	public void setUp() throws RemoteException {
		s1 = new SiteImpl();
		s2 = new SiteImpl();
		s5 = new SiteImpl();
		s6 = new SiteImpl();
		s3 = new SiteImpl();
		s4 = new SiteImpl();
	}
	
	/**
	 * Cette fonction teste le bon fonctionnement de la fonction init de la
	 * classe SiteImpl.
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testInit() throws RemoteException{
		s1.init(1);
		s6.init(6);
		
		// Vérification des ids
		assertEquals(1, s1.getId());
		assertEquals(6, s6.getId());
		
		// Initialise une liste vide
		assertTrue(s1.getVoisins().isEmpty());
	}
	
	
	/**
	 * Cette fonction vérifie le bon fonctionnement de la fonction d'ajout 
	 * d'un voisin à un site.
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testAjoutVoisin() throws RemoteException{
		s1.init(1);
		s2.init(2);
		
		s1.ajouterSite(s2);
		
		assertTrue(s1.getVoisins().contains(s2));
		assertTrue(s2.getVoisins().contains(s1));
	}
}
