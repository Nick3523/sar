import java.util.Random;

public class Findetri {

	public static int[] finalMerge(int[] a, int[] b) {
		
        int[] result = new int[a.length + b.length];
        int i=0; 
        int j=0; 
        int r=0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r]=a[i];
                i++;
                r++;
            } else {
                result[r]=b[j];
                j++;
                r++;
            }
            if (i==a.length) {
                while (j<b.length) {
                    result[r]=b[j];
                    r++;
                    j++;
                }
            }
            if (j==b.length) {
                while (i<a.length) {
                    result[r]=a[i];
                    r++;
                    i++;
                }
            }
        }
        
return result;

}

    public static void main(String[] args) throws InterruptedException {
        



	
		int[] tableau={5,8,3,2,7,10,1,12,4};
		TriParallele t = new TriParallele(tableau);
		//t.trier(0,tableau.length-1);


        int[] subArr1 = new int[tableau.length/2];
        int[] subArr2 = new int[tableau.length - tableau.length/2];
        System.arraycopy(tableau, 0, subArr1, 0, tableau.length/2);
        System.arraycopy(tableau, tableau.length/2, subArr2, 0, tableau.length - tableau.length/2);

        TriParallele runner1 = new TriParallele(subArr1);
        TriParallele runner2 = new TriParallele(subArr2);
        runner1.start();
        runner2.start();
        runner1.join();
        runner2.join();
        int[] tab=finalMerge (runner1.getInternal(), runner2.getInternal());
       
        for(int i=0;i<9;i++) {
        	System.out.println(tab[i]);
        }
    }


}
