package graph;

import firstExercise.Bag;

public class Graph {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	public Graph(int V){
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++)
			adj[i] = new Bag<Integer>();
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public int edgeSize(){
		return E;
	}
	public int vertexSize(){
		return V;
	}
	public Iterable<Integer> adj(int i){
		return adj[i];
	}
}
