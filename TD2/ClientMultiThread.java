import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMultiThread {

	public ClientMultiThread() {
	}
	
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
				hote=InetAddress.getByName(null); //Localhost

			}
		}

		catch(UnknownHostException e){
		System.err.println("Machine inconnue :" +e);
		}

		int cpt=0;
		try{
				System.out.println("connexion au : "+hote+" port : "+port);
				sc = new Socket(hote, port);

				while (cpt != 10) {
					
				in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				String answere = in.readLine();
				System.out.println("MESSAGE du serveur: "+answere);
				cpt++;
				out = new PrintWriter(sc.getOutputStream(), true);
				String answereClient="Je suis le client"+InetAddress.getLocalHost().toString()+" et j'ai fait "+cpt+" appels";
			    Thread.sleep(2000);                 //2s de pause
				if (cpt==10) {out.println("Bye"); sc.close(); } //Pour terminer
				out.println(answereClient);

				}

		}
		catch(IOException | InterruptedException e){
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
