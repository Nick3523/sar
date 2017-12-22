//package com.td3.sar;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Test {

	public static void main(String[] args)  {
		
		try {
		    
			//LocateRegistry.createRegistry(9901); //C'est ça qui m'a corrigé mon exception dans Naming.rebind
		    //SecurityManager security = System.getSecurityManager();
		    //System.setProperty("java.rmi.server.hostname","192.168.154.68");
			
			ServeurImpl sv = new ServeurImpl();
			//String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":1099/TestRMI";
			String url = "rmi://192.168.154.58:2001/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			
			Naming.rebind(url, sv);
			System.out.println("Serveur lancé");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}

	}

}
