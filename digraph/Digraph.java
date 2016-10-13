package digraph;
import firstExercise.Bag;
public class Digraph {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	public Digraph(int vSize){
		V = vSize;
		adj = (Bag<Integer>[])new Bag[vSize];
		for(int i=0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public int vertexSize(){
		return V;
	}
	public int edgeSize(){
		return E;
	}
	public Digraph reverse(){
		Digraph r = new Digraph(V);
		for(int v=0;v<V;v++){
			for(int w : adj[v])
				r.addEdge(w, v);
		}
		return r;
	}
	// @override 
	public String toString(){
		StringBuilder s = new StringBuilder("Digraph:\n");
		s.append(V + " vertexs\n" );
		s.append(E + " edges:\n");
		for(int v=0;v<V;v++)
			for(int w : adj[v])
				s.append(v + " -> " + w + "\n");
		return s.toString();
	}
	public static void main(String[] args){
		Digraph G = new Digraph(6);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(0,4);
		System.out.println(G);
	}
}
