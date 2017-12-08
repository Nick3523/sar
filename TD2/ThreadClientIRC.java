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
	System.out.println("Pseudo du client : "+req);

	out.println("Bienvenu parmis nous! ");//envoi un premier message d'accueil
	
	//envoi la liste des clients connectes
	serv.EnvoyerListeClients(out);
	
	while(true){
	//attendre un phrase de reponse
	
	req = in.readLine();
	if (req.equals("Bye")){
	
	serv.supprimerClient(this);
	
	}
	

	//Envoyer("Message reçu");   						//Pour ne pas avoir de doublons
	serv.EnvoyerATous("J'ai bien reçu votre message"); //repondre au client et l'envoi à tous les autres
	
	//envoyer le message à tous les clients
	
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

public void Envoyer(String s){out.println(s);}
public void setNom(String s){nom=s;}
public String getNom(){return nom;}

}