public class Compte {

	private int solde=0;

	public synchronized void ajouter(int somme) {
	solde=solde+somme;
	System.out.println(" ajout de " +somme);
	
	}

	public synchronized void retirer (int somme) {
	solde=solde-somme;
	System.out.println(" retrait de " +somme);
	
	}

	public synchronized void  operationNulle (int somme) {

	ajouter(somme);
	System.out.print(" ajout de " +somme +",");
	retirer(somme);
	System.out.print(" et retrait de " +somme +".");	
	System.out.println();
	
	}

	public synchronized  int  getSolde() {
	return solde;
	}
}