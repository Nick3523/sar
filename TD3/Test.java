import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test {

	public static void main(String[] args)  {
		
		try {
		    
			LocateRegistry.createRegistry(1095); //C'est ça qui m'a corrigé mon exception dans Naming.rebind
		    SecurityManager security = System.getSecurityManager();
		    System.setProperty("java.rmi.server.hostname","192.168.0.10");
			ServeurImpl sv = new ServeurImpl();
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, sv);
			System.out.println("Serveur lancé");
		} catch (RemoteException | UnknownHostException | MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
