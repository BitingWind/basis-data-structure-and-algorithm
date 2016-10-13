package digraph;

import firstExercise.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	private boolean hasCycle;
	private int[] edgeTo;
	
	public DirectedCycle(Digraph G){
		marked = new boolean[G.vertexSize()];
		cycle = new Stack<Integer>();
		onStack = new boolean[G.vertexSize()];
		edgeTo = new int[G.vertexSize()];
		for(int i=0;i<G.vertexSize();i++){
			if(!marked[i]){
				dfs(G,i);
			}
		}
	}
	private void dfs(Digraph G,int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w: G.adj(v)){
			if(hasCycle) return;
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}	
			else if(onStack[w] == true){  //判断已标记的顶点，是否在来时递归的路径中
				hasCycle = true;
				cycle.push(w);
				for(int i=v;i!=w;i=edgeTo[i])
					cycle.push(i);
				cycle.push(w);
			} 
		}
		onStack[v] = false; //递归之后，在上爬操作中清除标志
	}
	public boolean hasCycle(){
		return hasCycle;
	}
	public Iterable<Integer> cycle(){
		return cycle;
	}
	public static void main(String[] args){
		Digraph G = new Digraph(6);
		G.addEdge(1,2);
		G.addEdge(1,5);
		G.addEdge(2,5);
//		G.addEdge(5,3);
		G.addEdge(3,1);
        G.addEdge(2,3);
		G.addEdge(0,4);
		DirectedCycle c = new DirectedCycle(G);
		System.out.println(c.hasCycle());
		for(int v : c.cycle() )
			System.out.println(v);
	}
}
