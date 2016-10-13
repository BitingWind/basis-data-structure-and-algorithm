package graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.vertexSize()];
		dfs(G,s);
	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		count++;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	public boolean marked(int v){
		return marked[v];
	}
	public int count(){
		return count;
	}
	public static void main(String[] args){
		Graph G = new Graph(6);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(0,4);
		DepthFirstSearch dfs = new DepthFirstSearch(G,1);
		System.out.println(dfs.count());
	}
}
