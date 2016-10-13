package subStringSearch;

public class BackSearch {
	public static int search(String a,String pat){
		int i,N = a.length();
		int j,M = pat.length();
		for(i = 0,j = 0;i < N && j<M;i++){
			if(a.charAt(i)==pat.charAt(j)) //���ַ����Ĳ�ͬ�����ڱȽ��ַ�ʱ��������ͬ  ��������
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
		String a = new String("abcd��&ef7ki*");
		System.out.println(search(a,"cd��"));
		//System.out.println(a.charAt(5));
	}
}
