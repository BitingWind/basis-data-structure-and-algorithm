package weightedGraph;

import dataType.MinIndexPreQueue;
import firstExercise.Bag;

public class PrimMST {
	private boolean[] marked;
	private Edge[] edgeTo;
	private double[] distTo;
	private MinIndexPreQueue<Double> pq;
	public PrimMST(WeightedGraph G){
		marked = new boolean[G.vertexSize()];
		edgeTo = new Edge[G.vertexSize()];
		distTo = new double[G.vertexSize()];
		pq = new MinIndexPreQueue<Double>(G.vertexSize());
		for(int i=0;i<G.vertexSize();i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty()){
			int v = pq.delMin();
			visit(G,v);
		}
		
	}
	private void visit(WeightedGraph G,int v){
		marked[v] = true;
		for(Edge e: G.adj(v)){
			int w = e.otherVertex(v);
			if(marked[w]) continue;
			if(e.weight()<distTo[w]){
				distTo[w] = e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, e.weight());
				else pq.insert(w, e.weight());
			}
		}
	}
	public Iterable<Edge> edges(){
		Bag<Edge> es = new Bag<Edge>();
		for(int i=1;i<edgeTo.length;i++){
			es.add(edgeTo[i]);
		}
		return es;
	}
	public static void main(String[] args){
		Edge e1 = new Edge(1,0,0.1);
		Edge e2 = new Edge(1,3,0.2);
		Edge e3 = new Edge(4,3,0.3);
		Edge e4 = new Edge(4,2,0.5);
		Edge e5 = new Edge(2,0,0.6);
		Edge e6 = new Edge(1,2,0.8);
		Edge e7 = new Edge(3,0,0.7);
		Edge e8 = new Edge(4,0,0.05);
		WeightedGraph G = new WeightedGraph(5);
		G.addEdge(e1);G.addEdge(e2);G.addEdge(e3);G.addEdge(e4);
		G.addEdge(e5);G.addEdge(e6);G.addEdge(e7);G.addEdge(e8);
		PrimMST mst = new PrimMST(G);
		for(Edge e: mst.edges())
			System.out.println(e);
	}
}
