public class Findetri {



    public static void main(String[] args) throws InterruptedException {
        



	
		int[] tableau={5,8,3,2,7,10,1,12,4};
		TriParallele t = new TriParallele(tableau,0,8);		
		t.start();
	
		t.join(); 
		t.affiche();


		

    }


}
