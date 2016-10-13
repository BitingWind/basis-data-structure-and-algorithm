package sortAlgorithms;
import java.util.Random;
public class Bubble {
	//将最小的每次排在最前面
/*	public static void sort(double[] a){
		for(int i=0;i<a.length;i++){
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1])
					exch(a,j,j-1);
			}	
		}	
	}
	*/
	//将最大的每次排在最后面
	public static void sort(double[] a){
		int n = a.length;
		for(int i = n - 1;i > 0; i--){
			for(int j = 0; j < i; j++){
				if(a[j] > a[j+1])
					exch(a,j,j+1);
			}
		}
	}
	//for simplicity , Comparable[] -> double[]
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
		double[] a = new double[100];
		for(int i=0;i<100;i++){
			a[i] = random.nextDouble();
		}
		sort(a);
		for(double d:a)System.out.println(d);
		System.out.println(isSorted(a));
	}
}
