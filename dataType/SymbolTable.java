package dataType;
import java.util.Iterator;

public class SymbolTable<Key,Value> {
	private Node first;
	private class Node{
		Key key;
		Value value;
		Node next;
		
		public Node(Key key,Value value,Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}	
	}
	public int size(){
		int i = 0;
		for(Node n = first;n != null;n = n.next)
			i++;
		return i;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public boolean contains(Key k){
		return get(k)!=null;
	}
	public void put(Key k,Value v){
		for(Node n=first;n!=null;n=n.next){
			Key key = n.key;
			if(k.equals(key)){
				n.value = v;
				return;
			}
		}
		first = new Node(k,v,first);
	}
	public Value get(Key k){
		for(Node n=first;n!=null;n=n.next){
			Key key = n.key;
			if(k.equals(key))
				return n.value;
		}
		return null;
	}
	public  Value delete(Key k){
		if(isEmpty())return null;
		if(first.key.equals(k)){
			Value v = first.value;
			first = first.next;
			return v;
		}
		for(Node n=first;n.next!=null;n=n.next){
			Key key = n.next.key;
			if(k.equals(key)){
				Value v = n.next.value;
				n.next = n.next.next;
				return v;
			}		
		}
		return null;
	}
	public Iterable<Key> keys(){
		return new Iterable<Key>(){
			public Iterator<Key> iterator(){
				return new Iterator<Key>(){
					Node n = first;
				    public boolean hasNext(){
				    	return n != null;
					}
					public Key next(){
						Key k =n.key;
						n = n.next;
						return k;
					}
					public void remove(){}
				};	
			}	
		};
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("·ûºÅ±í£º\n");
		for(Key k : keys()){
			sb.append(k.toString()+" value: "+get(k).toString()+"\n");
		}
		return sb.toString();
	}
	public static void main(String[] args){
		SymbolTable<Student,Integer> st = new SymbolTable<Student,Integer>();
		st.put(Student.newStu("zhang", 1), 100);
		st.put(Student.newStu("zhang", 10), 100);
		st.put(Student.newStu("shuang", 2), 10);
		st.put(Student.newStu("xing", 3), 0);
		System.out.println(st.size());
		System.out.println(st.contains(Student.newStu("zhang", 10)));
		for(Student s : st.keys())
			System.out.println(s);
		System.out.println(st);
	}
}
