package dataType;
import firstExercise.Queue;
import java.util.Iterator;
public class BinaryST<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int N;
		public Node(Key key,Value value,int N){
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null) return 0;
		else  return x.N;
	}
	public void put(Key k,Value v){
		root = put(root,k,v);
	}
	private Node put(Node x, Key k,Value v){
		if(x == null) return new Node(k,v,1);
		int cmp = k.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left,k,v);
		else if(cmp > 0) x.right = put(x.right,k,v);
		else x.value = v;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
	public Value get(Key key){
		return get(root,key);
	}
	private Value get(Node x,Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp < 0) return get(x.left,k);
		else if(cmp > 0) return get(x.right,k);
		else return x.value;
	}
	public Key min(){
		if(root == null)return null;
		return min(root).key;
	}
	private Node min(Node x){
		if(x == null) return null;
		while(!(x.left==null)){
			x =x.left;
		}
		return x;
	}
	public void delMin(){
		if(root == null) return;
		root = delMin(root);
	}
	//此处默认传入参数不为null
	private Node delMin(Node x){
		if(x.left == null) return x.right;
		x.left = delMin(x.left);
		x.N = 1+size(x.left)+size(x.right);
		return x;
	}
	public void delete(Key k){
		root = delete(root,k);
	}
	private Node delete(Node x,Key k){
		if(x==null)return null;
		int cmp = k.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left,k);
		else if(cmp > 0) x.right = delete(x.right,k);
		else{
			if(x.left == null)  return x.right;
			if(x.right == null) return x.left;
			else{
				Node h = min(x.right);
				h.right =delMin(x.right);
				h.left = x.left;
				x = h;
			}
		}
		//上爬
		x.N = 1+size(x.left)+size(x.right);
		return x;
	}
	public Key floor(Key k){
		Node x = floor(root,k);
		if(x == null)return null;
		else return x.key;
	}
	private Node floor(Node x,Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp < 0) return floor(x.left,k);
		else if(cmp == 0)return x;
		else {
			Node n = floor(x.right,k);
			if(n == null) return x;
			else return n;
		}
	}
	//排名为k，本方法接受   k >= 1
	public Key select(int k){
		if(k<=0) return null;
		Node x = select(root,k-1);
		if(x == null) return null;
		else return x.key;
	}
	private Node select(Node x,int k){
		if(x == null) return null;
		int cmp = size(x.left);
		if(cmp > k) return select(x.left,k);
		else if(cmp < k) return select(x.right,k-cmp-1);
		else return x;
	}
	//小于指定键的键数量
	public int rank(Key k){
		return rank(root,k);
	}
	private int rank(Node x,Key k){
		if(x == null) return 0;
		int cmp = x.key.compareTo(k);
		if(cmp < 0) return size(x.left)+1+rank(x.right,k);
		else if(cmp > 0) return rank(x.left,k);
		else return size(x.left);
	}
/* import java.util.Iterator;	
 * public Iterable<Key> keys(Key lo,Key hi){
		return new Iterable<Key>(){
			public Iterator<Key> iterator(){
				return new Iterator<Key>(){
					public boolean hasNext(){}
					public Key next(){}
					public void remove(){}
				};
			}  
		};
	}
	*/
	public Key max(){
		if(root == null) return null;
		Node x = root;
		for(;x.right!=null;x=x.right){
		}
		return x.key;
	}
	public Iterable<Key> keys(){
		return keys(min(),max());
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q = new Queue<Key>();
		keys(root,q,lo,hi);
		return q;
	}
	private void keys(Node x,Queue<Key> q,Key lo,Key hi){
		if(x == null) return;
		int clo = lo.compareTo(x.key);
		int chi = hi.compareTo(x.key);
		if(clo < 0) keys(x.left,q,lo,hi);
		if(clo <= 0 && chi >= 0) q.enqueue(x.key);
		if(chi > 0) keys(x.right,q,lo,hi);
	}
	public static void main(String[] args){
		BinaryST<Student,Integer> st = new BinaryST<Student,Integer>();
		st.put(Student.newStu("zhang", 10), 10);
		st.put(Student.newStu("zhang", 20), 20);
		st.put(Student.newStu("zhang", 15), 15);
		st.put(Student.newStu("zhang", 16), 16);
		st.put(Student.newStu("zhang", 14), 14);
		st.put(Student.newStu("zhang", 13), 13);
		st.put(Student.newStu("zhang", 12), 12);
		st.delete(Student.newStu("zhang", 15));
	//	System.out.println(st.root.value);
		for(Student k: st.keys())
				System.out.println(k);
		//System.out.println(st.select(1));
		System.out.println(st.min());
		System.out.println(st.max());
	}
}
