package firstExercise;

import java.util.Iterator;
public class Bag<T> implements Iterable<T> {
	private Node first;
	private int N;
	private class Node{
		T t;
		Node next;
	}
	public void add(T t){
		Node firstOld = first;
		first = new Node();
		first.t = t;
		first.next = firstOld;
		N++;
	}
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			Node n = first;
			public boolean hasNext(){
				return n != null;
			}
			public T next(){
				T rt = n.t;
				n = n.next;
				return rt;
			}
			public void remove(){}
		};
	} 
	public int size(){
		return N;
	}
	public static void main(String[] args){
		Bag<Integer> bagT = new Bag<Integer>();
		bagT.add(5);
		bagT.add(6);
		bagT.add(7);
		bagT.add(8);
		for(int k: bagT)
			System.out.println(Integer.toString(k));
	}
}
