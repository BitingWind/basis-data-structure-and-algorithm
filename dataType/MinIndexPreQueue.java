package dataType;

public class MinIndexPreQueue<Key extends Comparable<Key>> {
	private Key[] keys;//存储键的数组
	private int[] indexs;//优先队列的数组，元素为索引，指向  keys
	private int[] indexsR;//辅助数组,存储键值索引对应的优先队列的索引
	private int N;
	public MinIndexPreQueue(int cap){
		keys = (Key[])new Comparable[cap + 1]; //!!!!! 不可用Object
		indexs = new int[cap + 1];
		indexsR = new int[cap + 1];
		for(int i=0;i<cap+1;i++)
			indexsR[i] = -1;
	}
	//return the index of the Min key
	public int delMin(){
		if(isEmpty()) return Integer.MIN_VALUE;
		int min = indexs[1];
	//	Key minK = keys[min];
		exch(1,N--);
		sink(1);
		keys[indexs[N+1]] = null; //将当前最小键元素 置为null（已交换）
		indexsR[indexs[N+1]] = -1; //辅助数组清空
		return min;
	}
	public Key delMinKey(){
		if(isEmpty()) return null;
		int min = indexs[1];
		Key minK = keys[min];
		exch(1,N--);
		sink(1);
		keys[indexs[N+1]] = null; //将当前最小键元素 置为null（已交换）
		indexsR[indexs[N+1]] = -1; //辅助数组清空
		return minK;
	}
	public void insert(int k,Key key){
		N++;  //由1开始
		indexs[N] = k;
		indexsR[k] = N;
		keys[k] = key;
		swim(N);
	}
	public boolean isEmpty(){
		return N < 1;
	}
	public boolean contains(int k){
		return  indexsR[k] != -1;
	}
	public Key minKey(){
		return keys[indexs[1]];
	}
	public void change(int k,Key key){
		keys[k] = key;
		swim(indexsR[k]);
		sink(indexsR[k]);
	}
	private void swim(int k){
		while(k > 1 && less(k,k/2)){
			 exch(k,k/2);
			 k = k/2;
		}
	}
	private void sink(int k){
		while(2*k <= N){
			int j = 2*k;
			if(j<N && less(j+1,j)) j=j+1;
			if(less(j,k)) exch(j,k);
			else break;    //若本层不可下沉，则不必再向后循环 ！！！
			k = j;
		}
	}
	private boolean less(int i,int j){
		return keys[indexs[i]].compareTo(keys[indexs[j]]) < 0;
	}
	private void exch(int i,int j){
		int t = indexs[i];
		indexs[i] = indexs[j];
		indexs[j] = t;
		indexsR[indexs[i]] = i;
		indexsR[indexs[j]] = j;
	}
	public static void main(String[] args){
		 MinIndexPreQueue<Double> mipq = new  MinIndexPreQueue<Double>(6);
		 mipq.insert(0, 1.0);
		 mipq.insert(1, 0.5);
		 mipq.insert(2, 1.5);
		 mipq.insert(3, 0.4);
		 mipq.change(1, 0.3);
		 for(int i =0;i < 6;i++)
		     System.out.println(mipq.delMin());
	}
}
