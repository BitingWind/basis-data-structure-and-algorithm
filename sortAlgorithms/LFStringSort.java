package sortAlgorithms;

/*
 * 低位优先排序（基数排序）
 * 先计算字符出现频率
 * 在按频率重排数组
 * 回写
 * @StringIndexOutOfBoundsException 
 *   the length of Strings must be larger than d !!
 */
public class LFStringSort {
	public static void sort(String[] a,int d){
		int R = 256;
		for(int w = d-1;w>=0;w--){
			int[] count = new int[R+1];
			for(int i=0;i<a.length;i++){
				count[a[i].charAt(w)+1]++;
			}
			for(int i=1;i<R;i++){
				count[i+1] += count[i];
			}
			String[] aux = new String[a.length];
			for(int i=0;i<a.length;i++){
				aux[count[a[i].charAt(w)]++] = a[i];
			}
			for(int i=0;i<a.length;i++){
				a[i] = aux[i];
			}
		}
	}
	public static void sort(String[] a){
		sort(a,3);
	}
	public static void main(String[] args){
		String[] a = new String[]{
			"abcd",
			"ijka",
			"abcn",
			"abcd",
			"abcv",
			"Abcf",
			"aBcd",
			"1234"
		};
		sort(a);
		for(String s:a)
			System.out.println(s);
	}
}
