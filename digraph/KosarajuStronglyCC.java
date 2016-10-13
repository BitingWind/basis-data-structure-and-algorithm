package digraph;

public class KosarajuStronglyCC {
	private boolean[] marked;
	private int[] id;
	private int count;
	public KosarajuStronglyCC(Digraph G){
		marked = new boolean[G.vertexSize()];
		id = new int[G.vertexSize()];
		Digraph GR = G.reverse();
		Topological to = new Topological();
		for(int s : to.topological(GR)){
			if(!marked[s]){
				dfs(G,s);
				count++;   //在递归之后，分量id 由 0 开始 
			}
		}
	}
	private void dfs(Digraph G,int v){
		id[v] = count;
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	public boolean stronglyCC(int v,int w){
		return id[v] == id[w];
	}
	public int count(){
		return count;
	}
	public static void main(String[] args){
		Digraph G = new Digraph(6);
		G.addEdge(1,2);
	//	G.addEdge(1,5);
	//	G.addEdge(2,5);
		G.addEdge(5,3);
	//	G.addEdge(3,1);
        G.addEdge(2,3);
		G.addEdge(0,1);
		G.addEdge(4,3);
		KosarajuStronglyCC scc = new KosarajuStronglyCC(G);
		System.out.println(scc.stronglyCC(1,2));
		
	}
}
