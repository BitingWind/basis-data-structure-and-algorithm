package graph;

public class Cycle {
	private boolean[] marked;
	private boolean hasCycle;
	public Cycle(Graph G){
		marked = new boolean[G.vertexSize()];
		for(int i=0;i<G.vertexSize();i++){
			if(!marked[i])
				dfs(G,i,i);
		}
	}
	private void dfs(Graph G,int v,int u){
		if(hasCycle) return;
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G,w,v);
			}
			else if(w!=u) hasCycle = true; //判断已标记的顶点是否为该路径来时的前一个顶点
		}
	}
	public boolean hasCycle(){
		return hasCycle;
	}
	public static void main(String[] args){
		Graph G = new Graph(6);
	//	G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,5);
	//	G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(0,4);
		Cycle c = new Cycle(G);
		System.out.println(c.hasCycle());
	}
}
