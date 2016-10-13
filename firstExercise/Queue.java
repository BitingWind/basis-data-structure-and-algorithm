package firstExercise;
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private Node first;
	private Node last;
	private int N;
	private class Node<T>{
		T t;
		Node next;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void enqueue(T t){
		Node oldlast = last;
		last = new Node();
		last.t = t;
		last.next = null;
		if(isEmpty()) //!!!!!!!!!!
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	public T dequeue(){
		T t1 = (T)first.t;  //!!!!!!!
		first = first.next;
		N--;
		if(isEmpty())last = null; //!!!!!!!!!
		return t1;
	}
	public int size(){
		return N;
	}
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			Node cur = first;
			public boolean hasNext(){
				return cur!=null;
			}
			public T next(){
				T t1= (T)cur.t;
				cur = cur.next;
				return t1;
			}
			public void remove(){};
		};
	}
	public static void main(String[] args){
		Queue<Person> st = new Queue<Person>();
		for(int i=0;i<100;i++)
			st.enqueue(new Person(i));	
		for(int i=0;i<80;i++)
			st.dequeue();
		for(Person p:st)
			System.out.println(p);	
	}
}
