package sortAlgorithms;
import java.util.Random;
public class Quick {
	public static void sort(double[] a){
		//在起初打乱数组
		sortAfterShuffle(a);
		
		//另一种实现，在切分时完成部分随机化
		//sort(a,0,N-1); 
	}
	private static void sortAfterShuffle(double[] a){
		Random ran = new Random();
		int n = a.length;
		for(int i=0;i<n;i++){
			int r = i + ran.nextInt(n-i);//range [0 , n - i)
			exch(a,i,r);
		}
		sortAfterShuffle(a,0,n-1);
	}
	private static void sort(double[] a,int lo,int hi){
		if(lo>=hi) return;
		int j = randomPartation(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
		
	}
	private static void sortAfterShuffle(double[] a,int lo,int hi){
		if(lo>=hi) return;
		int j = partation(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
		
	}
	private static int randomPartation(double[] a,int lo,int hi){
		int r = new Random(32).nextInt(hi-lo) + lo;
		//System.out.println(r);
		exch(a,lo,r);
		return partation(a,lo,hi);
	}
	private static int partation(double[] a,int lo,int hi){
		double p = a[lo];
		int i = lo, j = hi+1;
		while(true){
			while(a[++i] < p) if(i == hi) break;
			while(a[--j] > p) if(j == lo) break; 
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private static void exch(double[] a,int i,int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args){
		double[] a = new double[20];
		Random ran = new Random(47);
		for(int i=0;i<20;i++)
			a[i]=ran.nextDouble();
		ArrayPrintAsRow.print(a);
		//sort(a);
		sortAfterShuffle(a);
		ArrayPrintAsRow.print(a);
	}
}
