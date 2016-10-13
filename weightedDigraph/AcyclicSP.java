/*
 * 利用遍历的逆倒序，来逐个relax顶点，可以解决，无环无负权重环的问题
 */
package weightedDigraph;

import firstExercise.Bag;
import firstExercise.Stack;

public class AcyclicSP {
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private int s;
	private boolean[] marked;
	private Stack<Integer> tpOrder;
	
	public AcyclicSP(WeightedDigraph G,int s){
		this.s = s;
		marked = new boolean[G.vertexSize()];
		distTo = new double[G.vertexSize()];
		for(int i=0;i<G.vertexSize();i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		edgeTo = new DirectedEdge[G.vertexSize()];
		tpOrder = new Stack<Integer>();
		dfs(G,s);
		while(!tpOrder.isEmpty()){
			int v = tpOrder.pop();
			relax(G,v);
		}
	}
	private void relax(WeightedDigraph G,int v){
		for(DirectedEdge e:G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v]+e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
			}
		}
	}
	private void dfs(WeightedDigraph G,int v){
		marked[v] = true;
		for(DirectedEdge e:G.adj(v)){
			int w = e.to();
			if(!marked[w]){
				dfs(G,w);
			}
		}
		tpOrder.push(v);
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
		DirectedEdge e3 = new DirectedEdge(3,1,0.5);
		DirectedEdge e4 = new DirectedEdge(2,4,0.4);
		WeightedDigraph G = new WeightedDigraph(5);
		G.addEdge(e1);G.addEdge(e2);G.addEdge(e3);
		G.addEdge(e4);
		AcyclicSP sp = new AcyclicSP(G,1);
		if(sp.hasPathTo(3)){
			for(DirectedEdge e : sp.pathTo(3))
				System.out.println(e);
		}
		System.out.println(sp.distTo(3));
	}
}
