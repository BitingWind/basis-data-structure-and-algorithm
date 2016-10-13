package weightedGraph;

import firstExercise.Bag;;

public class WeightedGraph {
	private int V;
	private int E;
	private Bag<Edge>[] adj;
	public WeightedGraph(int V){
		this.V = V;
		adj = (Bag<Edge>[])new Bag[V];
		for(int i=0;i<V;i++)
			adj[i] = new Bag<Edge>();
	}
	public int vertexSize(){
		return V;
	}
	public int edgeSize(){
		return E;
	}
	public void addEdge(Edge e){
		int v = e.vertex();
		int w = e.otherVertex(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public Iterable<Edge> edges(){
		Bag<Edge> es = new Bag<Edge>();
		for(int v=0;v<V;v++){
			for(Edge e:adj[v]){
				if(v > e.otherVertex(v))
					es.add(e);
			}
		}
		return es;
	}
	public String toString(){
		StringBuilder s = new StringBuilder("WeightedGraph:\n");
		s.append(V + " vertexs\n" );
		s.append(E + " edges:\n");
		for(Edge e : edges())
			s.append(e + "\n");
		return s.toString();
	}
	public static void main(String[] args){
		Edge e1 = new Edge(1,2,0.1);
		Edge e2 = new Edge(2,3,0.3);
		Edge e3 = new Edge(4,1,0.5);
		Edge e4 = new Edge(1,3,0.4);
		WeightedGraph G = new WeightedGraph(5);
		G.addEdge(e1);G.addEdge(e2);G.addEdge(e3);G.addEdge(e4);
		for(Edge e : G.adj(1))
			System.out.println(e);
	}
}
