package graph;

public class ConnectedCount {
	private int[] id;
	private boolean[] marked;
	private int count;
	public ConnectedCount(Graph G){
		id = new int[G.vertexSize()];
		marked = new boolean[G.vertexSize()];
		for(int i = 0;i<G.vertexSize() ;i++){
			if(marked[i])continue;
			count++;
			id[i] = count;
			dfs(G,i);
		}
	}
	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w]){
				id[w] = count;
				dfs(G,w);
			}
		}
			
	}
	public boolean connected(int v,int w){
		return id[v]==id[w];
	}
	public int count(){
		return count;
	}
	public static void main(String[] args){
		Graph G = new Graph(10);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,3);
		G.addEdge(3,5);
		G.addEdge(2,6);
		G.addEdge(6,3);
		G.addEdge(4,7);
		G.addEdge(4,9);
		G.addEdge(7,8);
		G.addEdge(8,9);
		ConnectedCount cc = new ConnectedCount(G);
		System.out.println(cc.connected(8,3));
		System.out.println(cc.count());
	}
}
