package firstExercise;
import java.util.Scanner;
public class ScannerEx {
	public static void main(String[] args){
		Scanner scan  = new Scanner(System.in);
		while(scan.hasNext()){
			String s = scan.next();
			if(s!="#"){
				System.out.println(s.length());
			}
		}	
	}
}
