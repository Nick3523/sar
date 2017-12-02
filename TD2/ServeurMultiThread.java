import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServeurMultiThread {


public static void main(String[] args){

ServerSocket se=null;
int nport = Integer.parseInt(args[0]);
try { 

	se= new ServerSocket(nport); //Socket d'écoute

	}


catch (Exception e) {}



System.out.println("Le serveur est à l'écoute :");


 while(true) {		

 		try{
		Socket ssv = se.accept();	//Le client se connecte à la socket de communication
		System.out.println("Connexion acceptée");		
		ThreadClient tc=new ThreadClient(ssv);
		//tc.start();	
		System.out.println("END");		
		}

		catch (Exception e) {}
	}		
 }	

}