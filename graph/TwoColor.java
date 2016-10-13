/*
 * ����ͼ�ж�   �������ڶ���Ԫ�ؾ���ͬ��ɫ����Ϊ���л���Ϊż����
 */
package graph;

public class TwoColor {
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColor;
	public TwoColor(Graph G){
		isTwoColor = true;
		marked = new boolean[G.vertexSize()];
		color = new boolean[G.vertexSize()];
		for(int i = 0;i < G.vertexSize();i++){
			if(!isTwoColor) return;
			if(!marked[i]){
				marked[i] = true;
				color[i] = true;
				dfs(G,i);
			}
				
		}
	}
	private void dfs(Graph G,int v){
		for(int w:G.adj(v)){
			if(!marked[w]){
				marked[w] = true;
				color[w] = !color[v];
				dfs(G,w);
			}
			else if(color[w] == color[v]) isTwoColor = false;//�ѱ�����Ƿ��뵽��ö���Ķ�����ɫһ��
		}
	}
	public boolean isTwoColor(){
		return isTwoColor;
	}
	public static void main(String[] args){
		Graph G = new Graph(6);
		G.addEdge(1,2);
		G.addEdge(2,5);
		G.addEdge(5,3);
		G.addEdge(5,0);
		G.addEdge(0,4);
		G.addEdge(1,4);
		G.addEdge(3,1);

		TwoColor tc = new TwoColor(G);
		System.out.println(tc.isTwoColor());
	}
}
