package subStringSearch;

public class BackSearch {
	public static int search(String a,String pat){
		int i,N = a.length();
		int j,M = pat.length();
		for(i = 0,j = 0;i < N && j<M;i++){
			if(a.charAt(i)==pat.charAt(j)) //两种方法的不同就在于比较字符时，索引不同  ！！！！
				j++;
			else {
				i = i-j;
				j = 0;
			}
		}
		if(j == M) return i-j;
		else return N;
	}
	public static void main(String[] args){
		String a = new String("abcd张&ef7ki*");
		System.out.println(search(a,"cd张"));
		//System.out.println(a.charAt(5));
	}
}
