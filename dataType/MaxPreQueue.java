package dataType;
import java.util.Random;

public class MaxPreQueue {
	double[] pq;
	int N = 0;
	public MaxPreQueue(int maxN){
		pq = new double[maxN+1];
	}
	public void insert(double d){
		pq[++N]=d;
		swim(N);
	}
	public double delMax(){
		double max = pq[1];
		exch(pq,1,N--);
		pq[N+1] = 0; // 引用类型时设置为 null,便于垃圾收集
		sink(1);
		return max;
	}
	private void swim(int k){
		while(k>1 && pq[k/2]<pq[k]){
				exch(pq,k/2,k);
				k = k/2;
		}
	}
	private void sink(int k){
		while(2*k < N){
			int j = 2*k;
			if(pq[j]<pq[j+1]) j = j+1;
			if(pq[k]<pq[j]) exch(pq,k,j);
			else break;
			k = j;
		}
	}
	private static void exch(double[] a,int i,int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args){
		MaxPreQueue mpq = new MaxPreQueue(16);
		Random r = new Random(47);
		for(int i=0;i<16;i++)
			mpq.insert(r.nextDouble());
		for(int i=0;i<10;i++)
			System.out.println(mpq.delMax());
	}
}
