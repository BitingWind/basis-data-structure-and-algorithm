/*
 * @copyright  BitingWind 6/27 2016
 * ����ȷ������״̬�Զ�����DFA�������ַ������ң�KMP�㷨
 * ������ĸ��ʵ��
 */
package subStringSearch;

public class KMP {
	private String pat;
	private int[][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;  //��ĸ��ȡ��չ��ASCII��,��256��������UniCode
		dfa = new int[R][M];
		dfa[pat.charAt(0)][0] = 1;
		for(int X = 0,j = 1;j < M;j++){
			for(int c = 0;c<R;c++)
				dfa[c][j] = dfa[c][X];    //ƥ��ʧ�ܣ�����
			dfa[pat.charAt(j)][j] = j+1;  //ƥ��ɹ�
			X = dfa[pat.charAt(j)][X];    //��������״̬
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
