package graph;

public class UnionFind {
	private int[] id;
	private int[] size; //º”»®
	private int count;
	public UnionFind(int V){
		id = new int[V];
		size = new int[V];
		for(int i=0;i<V;i++){
			id[i] = i;
			size[i] = 1;
		}
		count = V;
	}
	public int find(int v){
		while(v != id[v]) v = id[v];
		return v;
	}
	public void union(int v,int w){
		int vid = find(v);
		int wid = find(w);
		if(vid == wid)return;
		if(size[vid] <= size[wid]){
			id[vid] = wid;
			size[wid] += size[vid];
		}
		else{
			id[wid] = vid;
			size[vid] += size[wid];
		}	
		count--;
	}
	public boolean connected(int v,int w){
		return find(v) == find(w);
	}
	public int count(){
		return count;
	}
	public static void main(String[] args){
		UnionFind uf = new UnionFind(5);
		uf.union(0,1);
		uf.union(1,2);
//		uf.union(3,0);
		System.out.println(uf.find(3));
		System.out.println(uf.count());
		System.out.println(uf.connected(2,3));
	}
}
