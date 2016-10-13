package digraph;

import firstExercise.Stack;

public class Topological {
	private boolean[] marked;
	private Stack<Integer> topo;
	private DirectedCycle dicy;
	
	public boolean hasCycle(Digraph G){
		dicy = new DirectedCycle(G);
		return dicy.hasCycle();
	}
	public Iterable<Integer> topological(Digraph G){
	//	if(hasCycle(G)) return null;
		marked = new boolean[G.vertexSize()];
		topo = new Stack<Integer>();
		for(int i=0;i<G.vertexSize();i++){
			if(!marked[i]) dfs(G,i);
		}
		return topo;
	}
	private void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
		topo.push(v);
	}
	public static void main(String[] args){
		Digraph G = new Digraph(6);
		G.addEdge(1,2);
	//	G.addEdge(1,5);
		G.addEdge(2,5);
//		G.addEdge(5,3);
	//	G.addEdge(3,1);
        G.addEdge(2,3);
		G.addEdge(0,1);
		G.addEdge(4,3);
		Topological c = new Topological();
	//	System.out.println(c.topological(G));
		for(int v : c.topological(G) )
			System.out.println(v);
	}
}
