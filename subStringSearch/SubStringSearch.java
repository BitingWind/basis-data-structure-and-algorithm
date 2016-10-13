/*
 * @copyright BitingWind  6/27 2016
 *  
 * �������ַ������� ��ʱ�临�Ӷ�  O(N*M)
 */
package subStringSearch;

public class SubStringSearch {
	public static int search(String a,String pat){
		int i,N = a.length();
		int j,M = pat.length();
		for(i = 0; i< N - M;i++){
			for(j = 0;j < M;j++){
				if(pat.charAt(j)!=a.charAt(i+j))break;
			}
			if(j==M) return i;
		}
		return N;
	}
	public static void main(String[] args){
		String a = new String("abcd��&ef7ki*");
		System.out.println(search(a,"d��"));
		System.out.println(a.charAt(4));
	}
}
