package weightedGraph;

import dataType.MinIndexPreQueue;
import firstExercise.Bag;

public class LazyPrimMST {
	private MinIndexPreQueue<Edge> pq;
	private Bag<Edge> mst;
	private boolean[] marked;
	private int V;
	private int eIndex;
	public LazyPrimMST(WeightedGraph G){
		pq = new MinIndexPreQueue<Edge>(2*G.edgeSize());//很关键，不能小于，否则在插入时会越界 ！！！
		mst = new Bag<Edge>();
		marked = new boolean[G.vertexSize()];
		
		visit(G,0);
		while(!pq.isEmpty()){
			Edge min = pq.delMinKey();
			int v = min.vertex();
			int w = min.otherVertex(v);
			if(marked[v] && marked[w]) continue;
			mst.add(min);
			if(!marked[v])visit(G,v);
			if(!marked[w])visit(G,w);
		}
	}
	private void visit(WeightedGraph G,int v){
		marked[v] = true;
		for(Edge e: G.adj(v))
			pq.insert(eIndex++, e);
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight(){
		double w = 0.0;
		for(Edge e: edges())
			w += e.weight();
		return w;
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
		LazyPrimMST mst = new LazyPrimMST(G);
		for(Edge e: mst.edges())
			System.out.println(e);
	}
}
