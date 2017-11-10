public class DeuxThreads extends Thread {
public void run(){
  
  for (int i=0; i<30; i++){
  	this.currentThread().setName("Thread numero 1");
	System.out.println("nouveau thread"+this.getName());
	}
}
	
public static void main (String[] args){

	DeuxThreads th = new DeuxThreads();    
	th.start();
	for (int i=0; i<30; i++){
		System.out.println("Main thread");
		System.out.flush();
		try {

		sleep(1);			//yield(); 

		}
		
		catch  (Exception e) {

			e.printStackTrace();
		}

   	}

 }

}

/* ex1 :

1. Affichage de "nouveau thread" 10 fois à l'appel de run et "Main thread " 10 fois 
L'affchage sera effectuée de manière aléatoire car on ne sait pas quand les commutations auront lieu 
on ne connait pas l'execution à l'avance (dépend de l'os, du scheduler, on est pas sur d'avoir le meme affichage )

*/


