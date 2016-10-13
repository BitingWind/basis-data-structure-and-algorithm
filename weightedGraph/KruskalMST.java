package weightedGraph;

import dataType.MinIndexPreQueue;
import firstExercise.Bag;
import graph.UnionFind;
public class KruskalMST {
	private MinIndexPreQueue<Edge> pq;
	private Bag<Edge> mst;
	private int eIndex;
	public KruskalMST(WeightedGraph G){
		pq = new MinIndexPreQueue<Edge>(2*G.edgeSize());
		UnionFind uf = new UnionFind(G.vertexSize());
		mst = new Bag<Edge>();
		for(int v=0;v<G.vertexSize();v++){
			for(Edge e:G.adj(v)){
				pq.insert(eIndex++,e);
			}
		}
		while(!pq.isEmpty() &&  mst.size() < G.vertexSize()-1){
			Edge e = pq.delMinKey();
			int v = e.vertex();
			int w = e.otherVertex(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			mst.add(e);
		}
	}
	public Iterable<Edge> edges(){
		return mst;
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
		KruskalMST mst = new KruskalMST(G);
		for(Edge e: mst.edges())
			System.out.println(e);
	}
}
