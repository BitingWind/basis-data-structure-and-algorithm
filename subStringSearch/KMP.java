/*
 * @copyright  BitingWind 6/27 2016
 * 基于确定有限状态自动机（DFA）的子字符串查找，KMP算法
 * 依赖字母表实现
 */
package subStringSearch;

public class KMP {
	private String pat;
	private int[][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;  //字母表取扩展的ASCII码,共256个，不用UniCode
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int X = 0,j = 1;j < M;j++){
			for(int c = 0;c<R;c++)
				dfa[c][j] = dfa[c][X];    //匹配失败，复制
			dfa[pat.charAt(j)][j] = j+1;  //匹配成功
			X = dfa[pat.charAt(j)][X];    //更新重启状态
		}
	}
	public int search(String a){
		int  i, j, N = a.length(),M = pat.length();
		for(i = 0,j = 0;i < N && j < M;i++)
			j = dfa[a.charAt(i)][j];
		if(j == M) return i - M;
		else return N;
	}
	public static void main(String[] args){
		KMP kmp = new KMP("d&");
		String a = new String("abcd&ef7ki*");
		System.out.println(kmp.search(a));
		//System.out.println(a.charAt(4));
	}
}
