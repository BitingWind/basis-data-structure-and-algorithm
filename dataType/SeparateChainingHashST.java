package dataType;

import java.util.Iterator;
import firstExercise.Queue;

public class SeparateChainingHashST<Key,Value> {
	private int M;
	private int N;
	private SymbolTable<Key,Value>[] sts;
	
	public SeparateChainingHashST(){
		this(997);
	}
	public SeparateChainingHashST(int M){
		this.M = M;
		sts = (SymbolTable<Key,Value>[])new SymbolTable[M];
		for(int i=0;i<M;i++)
			sts[i] = new SymbolTable<Key,Value>();
	}
	public int hash(Key k){
		return (k.hashCode() & 0x7FFFFFFF) % M;
	}
	public Value get(Key k){
		return sts[hash(k)].get(k);
	}
	public void put(Key k,Value v){
		sts[hash(k)].put(k,v);
		N++;
	}
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(SymbolTable<Key,Value> st :sts){
			for(Key k : st.keys())
				q.enqueue(k);
		}
		return q;
	}
	public static void main(String[] args){
		SeparateChainingHashST<Student,Integer> st = new SeparateChainingHashST<Student,Integer>(111);
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
			System.out.println(st.get(k));
		}
				
		//System.out.println(st.select(1));
		//System.out.println(st.keys());
		//System.out.println(st.max());
	}
}
