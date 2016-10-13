package firstExercise;
import java.util.Iterator;

class Person{
	 public final int id;
	 public Person(int id){
		 this.id = id;
	 }
	 //@override
	 public String toString(){
		 return "Person:  "+id;
	 }
}

public class ResizeArrayStack<T> implements Iterable<T> {
	private T[] a;
	private int N;
	
	public ResizeArrayStack(int cap){
		a=(T[])new Object[cap];
	}
	public ResizeArrayStack(){
		a=(T[])new Object[16];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public void push(T t){
		if(N==a.length)
			resize(2*a.length);
		a[N++]=t;
	}
	public T pop(){
		N--;
		T t=a[N];
		a[N]=null;
		if(N>0 && N==a.length/4)
			resize(a.length/2);
		return t;
	}
	public int arraySize(){
		return a.length;
	}
	void resize(int max){
		T[] temp = (T[])new Object[max];
		for(int i=0;i<N;i++){
			temp[i] = a[i];
		}
		a = temp;
		System.out.println("I has changed : "+arraySize());
	}
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			int l = N;
			public boolean hasNext(){
				return l > 0;
			}
			public T next(){
				return a[--l];
			}
			public void remove(){};
		};
	}
	public static void main(String[] args){
		ResizeArrayStack<Person> st = new ResizeArrayStack<Person>(4);
		for(int i=0;i<100;i++)
			st.push(new Person(i));	
		for(int i=0;i<80;i++)
			System.out.println(st.pop());
		//for(Person p:st)
		//	System.out.println(p);
	}
}
