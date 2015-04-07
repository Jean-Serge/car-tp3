package entite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

public class TestSite {

	private SiteImpl s1, s2, s3, s4, s5, s6;

	@Before
	public void setUp() throws RemoteException {
		s1 = new SiteImpl();
		s2 = new SiteImpl();
		s5 = new SiteImpl();
		s6 = new SiteImpl();
		s3 = new SiteImpl();
		s4 = new SiteImpl();
	}
	
	@Test
	public void testInit() throws RemoteException{
		s1.init(1, null);
		s2.init(2, s1);
		s5.init(5, s1);
		s6.init(6, s5);
		s3.init(3, s2);
		s4.init(4, s2);
		
		assertEquals(1, s1.getId());
		assertEquals(6, s6.getId());
		
		assertFalse(s1.getVoisins().isEmpty());
		assertTrue(s3.getVoisins().contains(s2));
		assertTrue(s1.getVoisins().contains(s2));
	}
}
