package firstExercise;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	private Node first;
	private int N;
	private class Node<T>{
		T t;
		Node next;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void push(T t){
		Node oldfirst = first;
		first = new Node();
		first.t = t;
		first.next = oldfirst;
		N++;
	}
	public T pop(){
		T t1 = (T)first.t;  //!!!!!!!
		first = first.next;
		N--;
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
		Stack<Person> st = new Stack<Person>();
		for(int i=0;i<100;i++)
			st.push(new Person(i));	
		for(int i=0;i<80;i++)
			st.pop();
		for(Person p:st)
			System.out.println(p);
		//Iterator<Person> iter = st.iterator();
		//System.out.println(iter.hasNext());
	}
}
