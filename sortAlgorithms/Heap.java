package sortAlgorithms;

import java.util.Random;

public class Heap {
	public static void sort(double[] a){
		int N = a.length;
		for(int k=N/2+1;k>=1;k--)
			sink(a,k,N);
		while(N>1){
			exch(a,1,N);
			N--;
			sink(a,1,N);
		}
		if(a[0]>a[1])
			exch(a,1,2);
	}
	private static void sink(double[] a,int k,int N){
		while(2*k < N){
			int j = 2*k;
			if(j<N && less(a,j,j+1)) j=j+1;
			if(less(a,k,j)) 
				exch(a,k,j);
			k = j;
		}
	}
	private static boolean less(double[] a,int i,int j){
		return a[i-1]<a[j-1];
	}
	private static void exch(double[] a,int i,int j){
		double temp = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = temp;
	}
	public static boolean isSorted(double[] a){
        for(int i=0;i<a.length-1;i++)
            if(a[i+1]<a[i])return false;
        return true;
	}
	public static void main(String[] args){
		double[] a = new double[999];
		Random ran = new Random(7);
		for(int i=0;i<999;i++)
			a[i]=ran.nextDouble();
		ArrayPrintAsRow.print(a);
	//	double[] a1 = new double[]{1.0,3.0,2.0,5.0,3.1,4.0,5.2,4.1};
		//sink(a1,2,5);
		//sink(a1,1,5);
		sort(a);
		ArrayPrintAsRow.print(a);
		System.out.println(isSorted(a));
	
	}
}
