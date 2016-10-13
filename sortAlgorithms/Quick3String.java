package sortAlgorithms;

public class Quick3String {
	public static void sort(String[] a){
		sort(a,0,a.length-1,0);
	}
	private static void sort(String[] a,int lo,int hi,int d){
		if(lo>=hi) return;
		int lt = lo;
		int gt = hi;
		int v = charAt(a[lo],d);
		int i = lo+1;
		while(i<=gt){
			int t = charAt(a[i],d);
			if(t < v) exch(a,lt++,i++);
			else if(t > v) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,d);
		if(v >= 0) sort(a,lt,gt,d+1);//当前位置非空，在中间此为相同部分继续下一位
		sort(a,gt+1,hi,d);
	}
	private static int charAt(String a,int d){
		if(d>a.length()-1) return -1;
		else return a.charAt(d);
	}
	private static void exch(String[] a,int v,int w){
		String s = a[v];
		a[v] = a[w];
		a[w] = s;
	}
	public static void main(String[] args){
		String[] a = new String[]{
			"absg",
			"ija",
			"absdgn",
			"abcsbd",
			"abcv",
			"Abcfj",
			"aBsfgcd",
			"1sg",
			"1234"
		};
		sort(a);
		for(String s:a)
			System.out.println(s);
	}
}
