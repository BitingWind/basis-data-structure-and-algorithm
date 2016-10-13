package dataType;

import firstExercise.Queue;

public class LinearprobingHashST<Key,Value>{
	private int M;
	private int N;
	private Key[] ks;
	private Value[] vs;
	
	public LinearprobingHashST(){
		this(16);
	}
	public LinearprobingHashST(int cap){
		M = cap;
		ks = (Key[])new Object[M];
		vs = (Value[])new Object[M];
	}
	private int hash(Key k){
		return (k.hashCode() & 0x7fffffff) % M;
	}
//	public Key lookKey(int i){
//		return ks[i];
//	}
	private void resize(int m){
		LinearprobingHashST<Key,Value> re;
		re = new LinearprobingHashST<Key,Value>(m);
		for(int i=0;i < M;i++){
			re.put(ks[i],vs[i]);
		}
		ks = re.ks;
		vs = re.vs;
		M = re.M;
	}
	public void put(Key k,Value v){
		if(N >= M/2) resize(2*M);
		int i;
		for(i=hash(k);ks[i] != null;i = (i+1)% M){
			if(ks[i].equals(k)){
				vs[i]= v;
				return;
			}
		}
		ks[i] = k;
		vs[i] = v;
		N++;
	}
	public Value get(Key k){
		for(int i = hash(k);ks[i]!=null;i =(i+1)% M){
			if(k.equals(ks[i])) return vs[i];
		}
		return null;
	}
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(int i =0;i<M;i++){
			if(ks[i] == null) continue;
			q.enqueue(ks[i]);
		}
		return q;
	}
	public static void main(String[] args){
		LinearprobingHashST<Student,Integer> st = new LinearprobingHashST<Student,Integer>();
		st.put(Student.newStu("zhang", 10), 10);
		st.put(Student.newStu("zhang", 20), 20);
		st.put(Student.newStu("zhang", 15), 15);
		st.put(Student.newStu("zhang", 16), 16);
		st.put(Student.newStu("zhang", 14), 14);
		st.put(Student.newStu("zhang", 13), 13);
		st.put(Student.newStu("zhang", 12), 12);
		for(Student k: st.keys()){
			System.out.println(st.hash(k));
			System.out.println(k);
			//System.out.println(st.get(k));
		}
	//	System.out.println(st.lookKey(4));	
		//System.out.println(st.select(1));
		//System.out.println(st.keys());
		//System.out.println(st.max());
	}
}
