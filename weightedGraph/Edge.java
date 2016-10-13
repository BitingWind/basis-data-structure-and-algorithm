package weightedGraph;

public class Edge implements Comparable<Edge> {
	private int v;
	private int w;
	private double weight;
	
	public Edge(){}
	public Edge(int v,int w,double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	public double weight(){
		return weight;
	}
	public int vertex(){
		return v;
	}
	public int otherVertex(int v){
		if(this.v == v ) return w;
		else if(this.w == v) return this.v;
		else return -1;
	}
	public int compareTo(Edge that){
		if(this.weight < that.weight)
			return -1;
		else if(this.weight > this.weight)
			return 1;
		else return 0;
	}
	public String toString(){
		return "edge: "+v+"---"+w+ "  weight: "+weight;
	}
	public static void main(String[] args){
		Edge e = new Edge(1,21,0.1);
		System.out.println(e.otherVertex(21));
	}
}

