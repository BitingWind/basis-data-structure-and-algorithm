package subStringSearch;

import java.util.Random;

public class Prime {
	//���һ����Χ�ڵ��������˷�����Ϊlong��������
	public static long randomQ(){
		Random r = new Random();
		long Q;
		while(true){
			Q = r.nextLong();
			if(Q > (long)Math.pow(10.0,10.0) && isPrime(Q)) break;
		}////3457997856585973039 �˷�������ʱ��̫�����˼�¼һ������ֵ������������
		return Q;
	}
	//�ж��Ƿ�Ϊ����
	public static boolean isPrime(long n){
		if(n <= 1)return false;
		for(long i = 2;i <= (long)Math.pow(n, 0.5);i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
}
