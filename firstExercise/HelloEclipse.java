package firstExercise;

import java.math.BigDecimal;
class Hello{
	public Hello(String s){
		System.out.println(s+"super");
	}
	public void say(){System.out.println("super");}
	public static void main(){
		System.out.println("Hello ,Welcom To Access Me");
	}
}
public class HelloEclipse extends Hello{
	private  String V = "zhang";
	//@override
	public void say(){System.out.println("this");}
	public HelloEclipse(String V){
		super(V);
		this.V = V;
		System.out.println(V);
		
		
	}
	public static void main(String[] args){
		HelloEclipse he = new HelloEclipse("li");
		he.say();
	}

}
