import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTCP{

public static void main (String[] args){
	
	int port = 0;
	InetAddress hote = null;
	Socket sc = null;
	BufferedReader in;
	PrintWriter out;
	
	try{

		if (args.length>=2){
		
		hote=InetAddress.getByName(args[0].toString());
		port=Integer.parseInt(args[1]);

		}

		else{

			port=9950;
			hote=InetAddress.getByName(null);

		}
	}

	catch(UnknownHostException e){
	System.err.println("Machine inconnue :" +e);
	}

	int cpt=0;
	try{
			System.out.println("connexion au : "+hote+" port : "+port);

			while (cpt != 10) {
			sc = new Socket(hote, port);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String answere = in.readLine();
			System.out.println("REPONSE du serveur: "+answere);

			out = new PrintWriter(sc.getOutputStream(), true);
			System.out.println("Entrez une phrase à envoyer au serveur : ");
			Scanner scan = new Scanner(System.in);			
			out.println(scan.nextLine());
			cpt++;
			}
	}
	catch(IOException e){
		System.err.println("Impossible de creer la socket du client : " +e);
	}
	finally{
	
		try{

			sc.close();
		}
		catch (IOException e){}
	 }
  }
}