package graph;

import firstExercise.Queue;
import firstExercise.Bag;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private Queue<Integer> q;
	private final int s;
	
	public BreadthFirstPaths(Graph G,int s){
		marked = new boolean[G.vertexSize()];
		edgeTo = new int[G.vertexSize()];
		q = new Queue<Integer>();
		this.s = s;
		marked[s] = true;
		q.enqueue(s);
		while(!q.isEmpty()){
			int v = q.dequeue();
			bfs(G,v);
		}	
	}
	public void bfs(Graph G,int v){
		for(int w: G.adj(v)){
			if(marked[w] != true){
				marked[w] = true;
				q.enqueue(w);
				edgeTo[w] = v;
			}		
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){		
		Bag<Integer> path = new Bag<Integer>();
		if(!hasPathTo(v)) return path;
		for(int x = v;x != s;x = edgeTo[x])
			path.add(x);
		path.add(s);
		return path;
	}
	public static void main(String[] args){
		Graph G = new Graph(7);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(2,6);
		G.addEdge(6,3);
		BreadthFirstPaths dfs = new BreadthFirstPaths(G,1);
		for(int i:dfs.pathTo(6))
			System.out.println(i);
	}
}
