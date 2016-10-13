package subStringSearch;

//import java.util.Random;

public class HashSearch {
	private String pat;
	private long hashOfPat;
	private long Q = 997;//方便实验其他方法，此处给一定值！
	private int M;
	private int R = 256; //字母表取扩展的ASCII码,共256个,将字符转化为256进制数！！！
	private long RM;  //R^(M-1) mod Q
	
	public HashSearch(String pat){
		this.pat = pat;
		M = pat.length();
		RM = 1;
		for(int i = 1;i < M;i++){
			RM = (RM * R) % Q;
		}
		hashOfPat = hash(pat,M);
	}
	public boolean isContainedIn(String a){
		return search(a) <a.length();
	}
	public int search (String a){
		int N = a.length();
		long hashOfTxt = hash(a,M);
		if(hashOfTxt == hashOfPat) return 0;
		for(int i=M;i<N;i++){
			hashOfTxt = (hashOfTxt-a.charAt(i-M)*RM %Q + Q) % Q;
			hashOfTxt = (hashOfTxt*R + a.charAt(i)) % Q;
			if(hashOfTxt == hashOfPat) return i-M+1;
		}
		return N;
	}
	private long hash(String s,int l){
		long hash = 0;
		for(int i = 0;i < l;i++){
			hash = ( hash*R + s.charAt(i) ) % Q;
		}
		return hash;
	}
	public static void main(String[] args){
		HashSearch kmp = new HashSearch("*d");
		String a = new String("abcd&ef7ki*dsfgafgaergergeagevdafgegergergergtergergqergefger");
		System.out.println(kmp.isContainedIn(a));
		System.out.println(kmp.search(a));
	}
}
