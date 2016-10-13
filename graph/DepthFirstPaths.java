package graph;
import firstExercise.Stack;
public class DepthFirstPaths {
	private boolean[] marked;
	private int[] pathTo;
	private final int s;
	public DepthFirstPaths(Graph G,int s){
		marked = new boolean[G.vertexSize()];
		pathTo = new int[G.vertexSize()];
		this.s = s;
		dfs(G,s);
	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w]){
				pathTo[w] = v;
				dfs(G,w);
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int i=v;i!=s;i = pathTo[i]){
			path.push(i);
		}
		path.push(s);
		return path;
	}
	public static void main(String[] args){
		Graph G = new Graph(6);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(0,4);
		DepthFirstPaths dfs = new DepthFirstPaths(G,1);
		for(int i:dfs.pathTo(2))
			System.out.println(i);
	}
}
