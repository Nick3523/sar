package com.td3.sar;

import java.rmi.Naming;
import java.rmi.Remote;

public class TestClient {

	public TestClient() {
	}

	public static void main(String[] args) {
	  
		
		SecurityManager security = System.getSecurityManager();

		try {
		    Remote r = Naming.lookup("rmi://192.168.0.10/TestRMI"); //Le stub
		    System.out.println("Trouvé ! "+r);
		    
		    if (r instanceof Informations) {
		    int answere = ((Informations) r).NbOccurence("e", "viltaneuse");
		    int som = ((Informations) r).somme(23,64632);
		    System.out.println("Nombre d'occurence de << e >> dans : viltaneuse "+ answere);
		    System.out.println("Somme de 23 + 64632 = "+ som );
		    }
		   
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		
		
	}

}
