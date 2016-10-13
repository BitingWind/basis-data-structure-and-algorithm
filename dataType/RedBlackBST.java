package dataType;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int N;
		boolean color;
		public Node(Key key,Value value,int N,boolean color){
			this.key = key;
			this.value = value;
			this.N = N;
			this.color = color;
		}
	}
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	private Node leftRotate(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = 1 + size(h.left) + size(h.right);
		return x;
	}
	private Node rightRotate(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N ;
		h.N = 1+size(h.left) + size(h.right);
		return x;
	}
	private void flipColor(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	public void put(Key k, Value v){
		root = put(root,k,v);
		root.color = BLACK;
	}
	private Node put(Node x,Key k,Value v){
		if(x == null) return new Node(k,v,1,RED);
		int cmp = k.compareTo(x.key);
		if(cmp < 0) x.left = put(x.left,k,v);
		else if(cmp > 0) x.right = put(x.right,k ,v);
		else x.value = v;
		
		//所有判断，若前一个判断参数为null 后面不会执行，不存在NullPointer
		if(isRed(x.right)&& !(isRed(x.left))) x = leftRotate(x);
		if(isRed(x.left) && isRed(x.left.left)) x = rightRotate(x);
		if(isRed(x.left) && isRed(x.right))  flipColor(x);
		
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	} 
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null) return 0;
		else  return x.N;
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
	public static void main(String[] args){
		RedBlackBST<Student,Integer> st = new RedBlackBST<Student,Integer>();
		st.put(Student.newStu("zhang", 10), 10);
		st.put(Student.newStu("zhang", 20), 20);
		st.put(Student.newStu("zhang", 15), 15);
		st.put(Student.newStu("zhang", 16), 16);
		st.put(Student.newStu("zhang", 14), 14);
		st.put(Student.newStu("zhang", 13), 13);
//		st.put(Student.newStu("zhang", 12), 12);
		
	//	st.delete(Student.newStu("zhang", 15));

		System.out.println(st.get(Student.newStu("zhang", 16)));
	//	System.out.println(st.root.left.value);
	}
}
