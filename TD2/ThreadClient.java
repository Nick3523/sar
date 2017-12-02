import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class ThreadClient extends Thread {

PrintWriter out;
BufferedReader in;
Socket soc;


ThreadClient(Socket ssv) {


	soc = ssv;
	start();

}


public void run () {
	
	
	try {
		out=new PrintWriter(soc.getOutputStream(),true);		
		out.println("Bonjour et bienvenu");
		while (true) {
		in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		String answere = in.readLine();
		System.out.println("Message reçu : "+answere ); //Readline est bloquante
		if (answere.equals("Bye")) {
			
			System.out.println("Au revoir et à bientot !");
			soc.close();
			return;
		}
		Thread.sleep(1000); //Pause d'une seconde
		out.println("J'ai bien reçu ton message !");
		}
	} catch (IOException | InterruptedException e1) {
		e1.printStackTrace();
	}



finally{

	try {
	soc.close();
	} catch (IOException e) {
	e.printStackTrace();
   }
  }
	
 } 

}


