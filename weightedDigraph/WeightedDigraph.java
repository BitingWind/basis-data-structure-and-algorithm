package weightedDigraph;

import firstExercise.Bag;
import weightedGraph.Edge;
import weightedGraph.WeightedGraph;

public class WeightedDigraph {
	private int V;
	private Bag<DirectedEdge>[] adj;
	private int E;
	public WeightedDigraph(int V){
		this.V = V;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int i=0;i<V;i++)
			adj[i] = new Bag<DirectedEdge>();
	}
	public void addEdge(DirectedEdge e){
		int v = e.from();
		adj[v].add(e);
		E++;
	}
	public int vertexSize(){
		return V;
	}
	public int edgeSize(){
		return E;
	}
	public Iterable<DirectedEdge> adj(int v){
		return adj[v];
	}
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> es = new Bag<DirectedEdge>();
		for(int v=0;v<V;v++){
			for(DirectedEdge e:adj[v]){
					es.add(e);
			}
		}
		return es;
	}
	public String toString(){
		StringBuilder s = new StringBuilder("WeightedGraph:\n");
		s.append(V + " vertexs\n" );
		s.append(E + " edges:\n");
		for(DirectedEdge e : edges())
			s.append(e + "\n");
		return s.toString();
	}
	public static void main(String[] args){
		DirectedEdge e1 = new DirectedEdge(1,2,0.1);
		DirectedEdge e2 = new DirectedEdge(2,3,0.3);
		DirectedEdge e3 = new DirectedEdge(4,1,0.5);
		DirectedEdge e4 = new DirectedEdge(1,3,0.4);
		WeightedDigraph G = new WeightedDigraph(5);
		G.addEdge(e1);G.addEdge(e2);G.addEdge(e3);G.addEdge(e4);
		for(DirectedEdge e : G.edges())
			System.out.println(e);
	}
}
