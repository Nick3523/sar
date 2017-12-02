public class ThreadClientIRC extends Thread{

ServeurIRC serv;
Socket ssv;
String nom;
BufferedReader in;
PrintWriter out;

public ThreadClientIRC(Socket ssv, ServeurIRC serv){…}

public void run(){

	try{
	
	in = new BufferedReader(new InputStreamReader(ssv.getInputStream()));
	out= new PrintWriter(ssv.getOutputStream(),true);
	String req = in.readLine();
	setNom(req);
	out.println("Bienvenu parmis nous! ");//envoi un premier message d'accueil
	
	//envoi la liste des clients connectes
	…
	while(true){
	//attendre un phrase de reponse
	…
	req = in.readLine();
	if (req.equals("Bye")){
	//supprimer le client
	…
	}
	//repondre au client
	…
	//envoyer le message à tous les clients
	…
	}
	System.out.println (" Fin Communication");
	}
	catch (IOException e){
	System.err.println("Erreur : " +e);
	}
	finally{
	try{
	ssv.close(); in.close(); out.close();
	}
	catch (IOException e){}
	}
	}

public void Envoyer(String s){…}
public void setNom(String s){…}
public String getNom(){…}
}