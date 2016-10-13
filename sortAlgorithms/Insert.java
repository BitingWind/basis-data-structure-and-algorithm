package sortAlgorithms;

import java.util.Random;

public class Insert {
	public static void sort(double[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j]<a[j-1])
					exch(a,j,j-1);
				else break;
			}
		}
	}
	public static void exch(double[] a,int i,int j){
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
