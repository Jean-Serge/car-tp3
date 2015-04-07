package rmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entite.SiteItf;
import utils.Tools;

/**
 * Cette classe sert de client au Serveur RMI lancé au préalable.
 * 
 * @author Jean-Serge Monbailly
 */
public class ClientRMI {

	/**
	 * Ce client se connecte au Serveur RMI pour récupérer s1 (la racine de
	 * l'arbre). Il lui envoie ensuite un message et on peut constater le
	 * résultat.
	 **/
	public static void main(String[] args) {
		SiteItf s;
		Registry registre;

		try {
			// On se connecte au serveur RMI
			registre = LocateRegistry.getRegistry(Tools.PORT_RMI_SERVEUR);

			// On envoi un message au site sélectionné
			s = ((SiteItf) registre.lookup("s2"));
			s.recevoir("Bonjour".getBytes());
			
		} catch (AccessException e) {
			System.out.println("Le stub demandé n'a pas pu être trouvé.");
		} catch (RemoteException e) {
			System.out
					.println("Problème de communication avec le poste distant.");
		} catch (NotBoundException e) {
			System.out.println("Le stub demandé n'existe pas.");
		}

		// On termine le programme pour qu'il ne tourne pas en background.
		System.exit(0);
	}

}
