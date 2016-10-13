package weightedDigraph;

import dataType.MinIndexPreQueue;
import firstExercise.Bag;

public class DijkstraSP {
	//private boolean[] marked;
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private MinIndexPreQueue<Double> pq;
	private int s;
	
	public DijkstraSP(WeightedDigraph G,int s){
		this.s = s;
		edgeTo = new DirectedEdge[G.vertexSize()];
		distTo = new double[G.vertexSize()];
		pq = new MinIndexPreQueue<Double>(G.vertexSize());
		for(int v=0;v<G.vertexSize();v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()){
			int v = pq.delMin();
			relax(G,v);
		}
	}
	private void relax(WeightedDigraph G,int v){
		for(DirectedEdge e:G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v]+e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}
	public double distTo(int v){
		return distTo[v];
	}
	public boolean hasPathTo(int v){
		return distTo[v] != Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) throw new RuntimeException("No Path to vertex: "+v);
		Bag<DirectedEdge> path = new Bag<DirectedEdge>();
		int x;
		for(x=v;edgeTo[x].from()!=s;x=edgeTo[x].from())
			path.add(edgeTo[x]);
		path.add(edgeTo[x]);
		return path;
	}
	public static void main(String[] args){
		DirectedEdge e1 = new DirectedEdge(1,2,0.1);
		DirectedEdge e2 = new DirectedEdge(2,3,0.3);
		DirectedEdge e3 = new DirectedEdge(3,4,0.5);
		DirectedEdge e4 = new DirectedEdge(2,4,0.4);
		WeightedDigraph G = new WeightedDigraph(5);
		G.addEdge(e1);G.addEdge(e2);G.addEdge(e3);G.addEdge(e4);
		DijkstraSP sp = new DijkstraSP(G,1);
		if(sp.hasPathTo(4)){
			for(DirectedEdge e : sp.pathTo(4))
				System.out.println(e);
		}
		System.out.println(sp.distTo(4));
	}
}
