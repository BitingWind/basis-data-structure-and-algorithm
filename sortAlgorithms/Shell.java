package sortAlgorithms;
import java.lang.Math;
import java.util.Random;
public class Shell {
	public static void sort(double[] a){
		int N = a.length;
		int[] se = shellSequence(N);
		for(int i=se.length-1;i>=0;i--){
			int h = se[i];
			for(int j=h;j<N;j++){
				for(int k=j;k>=h && (a[k]<a[k-h]);k-=h)
					exch(a,k,k-h);
			}
		}
	}
	private static int[] shellSequence(int length){
		// Shell array for a sequence  1/2*(3^k-1)  k>=1
		int N = (int)Math.floor(Math.log(2*length+1)/Math.log(3));
		int[] sequence = new int[N];
		for(int i=0;i<N;i++){
			sequence[i]=(int)(Math.pow(3.0, i+1)-1)/2;
		}
		return sequence;
	}
	private static void exch(double[] a,int i,int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static boolean isSorted(double[] a){
        for(int i=0;i<a.length-1;i++)
            if(a[i+1]<a[i])return false;
        return true;
	}
	public static void main(String[] args){
		Random random = new Random(47);
		double[] a = new double[1000];
		for(int i=0;i<1000;i++){
			a[i] = random.nextDouble();
		}
		sort(a);
		for(double d:a)System.out.println(d);
		System.out.println(isSorted(a));
	}
	
}
