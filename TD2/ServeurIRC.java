public class ServeurIRC{

int port=9950;
ServerSocket se=null;
Socket ssv=null;
int cl=0;
Vector V; //Vector est thread safe: Toutes ses méthodes sont synchronized

public ServeurIRC(int nport){

	try{

		V = new Vector();
		port=nport;
		se = new ServerSocket(port);
		System.out.println("Serveur à l'écoute ");

	while(true){
		ssv = se.accept();
		System.out.println("Connexion acceptée");		
		cl++;
		ThreadClientIRC th= new ThreadClientIRC(ssv,this);
		ajouterClient(th);
	  }
	}
	catch (IOException e){
	System.err.println("Erreur : " +e);
	}
	finally{
		try{
		se.close();
		}
		catch (IOException e){}
	}
}

public void ajouterClient(ThreadClientIRC c) { V.add(c); }
synchronized public void supprimerClient(ThreadClientIRC c){V.remove(c); cl--;}
synchronized public void EnvoyerATous(String s){for(int i=0;i<V.size();i++) {v.get(i).Envoyer(s);}}
synchronized public void EnvoyerListeClients(PrintWriter out){ out.println(v.toString();)}//Boucler pour ajouter dans un string

public static void main(String[] args){
	new ServeurIRC();
}

}