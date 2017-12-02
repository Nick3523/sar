import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



public class ThreadClient extends Thread {

PrintWriter out;
BufferedReader in;
Socket soc;


ThreadClient(Socket ssv) {

	soc = ssv;
	start();
}


public void run () {

	System.out.println("TEEEEEEST");

try {

	in=new BufferedReader(new InputStreamReader(soc.getInputStream()));

} 

catch (IOException e1) {

	e1.printStackTrace();
}

try {
	out=new PrintWriter(soc.getOutputStream());
	System.out.println("Entrez une phrase à envoyer au client : ");
	Scanner scan = new Scanner(System.in);			
	out.println(scan.nextLine());

} catch (IOException e1) {
	e1.printStackTrace();
}

try {String req=in.readLine();out.println(req);


	}

catch(IOException e){}

finally{

	try {
	soc.close();
	} catch (IOException e) {
	e.printStackTrace();
   }
  }
 } 

}


