package sortAlgorithms;
import java.util.Random;
import java.lang.Math;
public class Merge {
	private static double[] aux;
/*	public static void sort(double[] a){
		aux = new double[a.length];
		sort(a,0,a.length-1);
	}
*/
	public static void sort(double[] a){
		int N = a.length;
		aux = new double[N];
		for(int sz=1;sz<N;sz=2*sz)
			for(int j=0;j<N-sz;j=j+2*sz)
				merge(a,j,j+sz-1,Math.min(N-1,j+2*sz-1));
	}
/*	private static void sort(double[] a,int lo,int hi){
		if(hi<=lo) return;
		int mid = (hi+lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
*/
    private static void merge(double[] a,int lo,int mid,int hi){
    	int i = lo, j = mid+1; 
    	for(int k=lo;k<=hi;k++)
    		aux[k]=a[k];
    	for(int k=lo;k<=hi;k++){
    		if      (i>mid) a[k] = aux[j++];
    		else if (j>hi)  a[k] = aux[i++];
    		else if (aux[i]<aux[j])
    			            a[k] = aux[i++];
    		else            a[k] = aux[j++];
    	}
    }
    public static boolean isSorted(double[] a){
        for(int i=0;i<a.length-1;i++)
            if(a[i+1]<a[i])return false;
        return true;
    }
    public static void main(String[] args){
    	Random random = new Random(47);
		double[] a = new double[100];
		for(int i=0;i<100;i++){
			a[i] = random.nextDouble();
		}
		sort(a);
		for(double d:a)System.out.println(d);
		System.out.println(isSorted(a));
    }
}
