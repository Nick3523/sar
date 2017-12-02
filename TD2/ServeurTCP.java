import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ServeurTCP{

public static void main(String[] args){
	
	int port=9951;
	ServerSocket se;
	Socket ssv=null;
 	PrintWriter out;
	BufferedReader in;
	
	try{

		se = new ServerSocket(port);


	 while(true) {		

		ssv = se.accept();		
		out = new PrintWriter(ssv.getOutputStream(), true);
		out.println("Bienvenu !");
		
		in = new BufferedReader(new InputStreamReader(ssv.getInputStream()));
		String answere = in.readLine();
		System.out.println("DEMANDE : "+answere);
		
	  }
	}

	catch (IOException e){
	System.err.println("Erreur : " +e);
	}

	finally{
		
		try{
		ssv.close();
		}		
		catch (IOException e){return;}
	}
  }
}