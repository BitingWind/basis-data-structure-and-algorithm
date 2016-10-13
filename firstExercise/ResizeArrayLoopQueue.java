package firstExercise;
import java.util.Iterator;

public class ResizeArrayLoopQueue<T> implements Iterable<T> {
	private T[] a;
	//private int N;
	private int first;
	private int last;
	
	public ResizeArrayLoopQueue(int cap){
		a=(T[])new Object[cap];
	}
	public ResizeArrayLoopQueue(){
		a=(T[])new Object[16];
	}
	public boolean isEmpty(){
		return first==last;
	}
	public int size(){
		return (last+a.length-first)%a.length;
	}
	public void enqueue(T t){
		if(size()==a.length-1)
			resize(2*a.length);
		if(last==a.length) last=0;
		a[last++]=t;
	}
	public T dequeue(){
		T t=a[first];
		a[first]=null;
		first++;
		if(first==a.length) first=0;
		if(size()<=a.length/4)
			resize(a.length/2);
		return t;
	}
	
	void resize(int max){
		T[] temp = (T[])new Object[max];
		for(int i=0;i<size();i++){
			temp[i] = a[(first+i)%a.length];
		}
		a = temp;
		first = 0;
		last = size();
		System.out.println("I has changed : "+a.length);
	}
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			int l=first;
			public boolean hasNext(){
				return l==last;
			}
			public T next(){
				return a[(l++)%a.length];
			}
			public void remove(){};
		};
	}
	public static void main(String[] args){
		ResizeArrayLoopQueue<Person> st = new ResizeArrayLoopQueue<Person>(2);
		for(int i=0;i<1000;i++)
			st.enqueue(new Person(i));	
		for(int i=0;i<900;i++)
		//	System.out.println(st.dequeue());
			st.dequeue();
		for(int i=0;i<800;i++)
			st.enqueue(new Person(i+1000));
		for(Person p:st)
			System.out.println(p);
	}
}
