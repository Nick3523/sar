public class TriParallele extends Thread {
	
private int[] t;
int debut,fin;

TriParallele(int[] t,int a,int b){

this.t=t;
debut=a;
fin=b;

}



public void affiche() {
	
	for (int i = 0; i < t.length; i++) {
		
		System.out.println(t[i]+" ");
	}
	
}

/*public synchronized void notifier() {

	this.nbNotify++;
	this.notify();
}*/

public void run() {
	
	
	if ((fin-debut)<2){
		if (t[debut]>t[fin]){
		permuter(debut,fin);
		}
	}

	else{
		
		int milieu=debut + (fin-debut)/2;						
																// RAjouter une variable père à notifier quand il termine
		TriParallele t1 = new TriParallele (t,debut,milieu);  // (this,t,debut,milieu); 
		TriParallele t2 = new TriParallele (t,milieu+1,fin);
		t1.start();
		t2.start();
		synchronized(this){
		try {
			
			wait();
			wait(); //Pour les 2 fils
			

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		trifusion(debut,fin);

		}

	/*	if( parent != null) {

			parent.notifier(); //Méthode qui fait notify
		}*/
	 }
		//notify();
}

int[] getInternal() {
	
	return t;
}

private void permuter (int a, int b){
	int temp=t[a];
	t[a]=t[b];
	t[b]=temp;
}


void trier (int debut, int fin){
	

}

private void trifusion(int debut, int fin){
	
	int[] tfusion = new int[fin-debut+1];
	int milieu = (debut + fin)/2;
	int i1=debut;
	int i2=milieu+1;
	int ifusion=0;
	
	while (i1<=milieu && i2<=fin){
		
		if (t[i1]<t[i2]){
		tfusion[ifusion++]=t[i1++];
		}
		else{
		tfusion[ifusion++]=t[i2++];
		}
	}
	
	if (i1>milieu){
		for (int i=i2; i<=fin; i++){
		tfusion[ifusion++]=t[i];
		}
	}
	else{
		for (int i=i1; i<=milieu; i++){
		tfusion[ifusion++]=t[i];
		}
	}
	
	for (int i=0, j=debut; i<=fin-debut; i++, j++){
		t[j]= tfusion[i];
	}
}


}