import java.util.Random;


public class Compteur extends Thread  {

public void run(){
  
  for (int i=1; i<=10; i++){
  	
  	System.out.println("Je suis le thread numÃ©ro : "+this.getName()+" | "+i);
  	Random r = new Random ();
	int hasard = r.nextInt(5000);
  	try {
  	this.sleep(hasard);
	}
	catch  (Exception e) {
	e.printStackTrace();
	}

	}

 System.out.println("Thread numéro : "+this.getName()+" a fini de compter");

}
	
public static void main (String[] args){


	if (args.length < 1 ) { System.out.println("Nombre de parametre incorrect, fournissez un entier "); return; }

	int n = Integer.parseInt(args[0]);

	if( n <= 0 ) { System.out.println("Le nombre de thread ne peut etre négatif ! "); return; }

	Thread myThreads[] = new Thread[n];

	for(int i=0; i<n;i++){

		Thread t = new Compteur();
		t.setName("Thread  : "+ i);
		myThreads[i]=t;		
		myThreads[i].start();
	}
	
	for(int i=0; i<n;i++){
	
	try {
	
	myThreads[i].join();
	
	}

	catch  (Exception e) {
	e.printStackTrace();
	
	}	
	
	}

 } 

}

