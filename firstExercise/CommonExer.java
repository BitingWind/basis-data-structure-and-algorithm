package firstExercise;

public class CommonExer {

	public static void main(String[] args){
		int x = 500;
		int y = 500;
		//Integer x=y;
		//x+=1;
		System.out.println("x:"+ x + "  y:" + y);
		System.out.println(new Integer(x)==new Integer(y));
		System.out.println(new Integer(x).equals(new Integer(y)));
	}
}
