package rmi;

import static org.junit.Assert.assertNotNull;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServeur {

	private static ServeurRMI serv;
	
	@BeforeClass
	public static void setUp(){
		serv = new ServeurRMI();
	}
	
	/**
	 * Ce test vérifie que le serveur est bien initialisé.
	 * 
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws AccessException 
	 */
	@Test
	public void testRegistre(){
		assertNotNull(serv.registre());
	}
	
	/**
	 * Ce test vérifie que les sites du serveur sont correctement initialisés.
	 * 
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	@Test
	public void testLookup() throws AccessException, RemoteException, NotBoundException{
		Registry r = serv.registre();
		assertNotNull(r.lookup("s1"));
	}
}
