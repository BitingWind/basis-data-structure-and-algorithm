package sortAlgorithms;
import java.util.Random;
public class Selection {
	public static void sort(double[] a){
		for(int i=0;i<a.length;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min])
					min=j;
			}
			double t = a[i];
			a[i] = a[min];
			a[min] = t;
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
