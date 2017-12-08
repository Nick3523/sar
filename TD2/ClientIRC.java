public class ClientIRC extends Thread{

static int port=9950;
static InetAddress hote=null;
Socket sc=null;
BufferedReader in; 
PrintWriter out;
String nom;
int compteur=0;

public ClientIRC(InetAdress ht, int prt, String nom){
hote=ht;
port=prt;
this.nom=nom;
start();
}

public void run(){
	
  try{
	sc = new Socket(hote,port);
	System.out.println("Connexion acceptée !");

	in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
	out = new PrintWriter(sc.getOutputStream(),true);

	String rep; 
	String req;
	out.println(nom);
	String answere=in.readLine();								//envoyer le pseudonyme au serveur
	System.out.println("Réponse du serveur : "+answere);		//recevoir le message d'accueil du serveur

	for (int i = 0; i < 10; i++) {
	answere=in.readLine(); //recevoir un message du serveur
	System.out.println("Serveur dit : "+answere);
	compteur++;//incrementer le nb d'echanges

	Scanner scan = new Scanner(System.in);			
	out.println(scan.nextLine());				//repondre au serveur
	Thread.sleep(3000); //Pause 3s
	}

	answere=in.readLine();  //recevoir un message du serveur
	System.out.println("Serveur dit : "+answere);
	Thread.sleep(2000);//faire une pause de 2sec
	out.println("Bye"); //envoyer un message « Bye » au serveur
	
    }

	catch(IOException e){
	   System.err.println("Impossible cree socket du client : " +e);
	}

   finally{
	try{
		sc.close();in.close();out.close();
	}
	catch (IOException e){}
   }

}


public static void main (String[] args){


	int hote;int port;String nom;
	try{
	if (args.length>=3){
		
		hote=InetAddress.getByName(args[0]);
		port=Integer.parseInt(args[1]);
		nom=args[2];
	}
	else{

		hote=InetAddress.getByName(null);
		port=9950;
		nom="anonnymous";
		
	 }
	}

	catch(UnknownHostException e){
	System.err.println("Machine inconnue :" +e);
	}
    
    ClientIRC client=new ClientIRC(hote,port,nom);
  }
}