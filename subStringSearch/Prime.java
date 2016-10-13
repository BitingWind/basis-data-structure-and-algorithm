package subStringSearch;

import java.util.Random;

public class Prime {
	//随机一个范围内的素数，此方法作为long，不可用
	public static long randomQ(){
		Random r = new Random();
		long Q;
		while(true){
			Q = r.nextLong();
			if(Q > (long)Math.pow(10.0,10.0) && isPrime(Q)) break;
		}////3457997856585973039 此方法所需时间太长，此记录一个返回值！！！不可用
		return Q;
	}
	//判断是否为素数
	public static boolean isPrime(long n){
		if(n <= 1)return false;
		for(long i = 2;i <= (long)Math.pow(n, 0.5);i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}
}
