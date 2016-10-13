package firstExercise;

import java.util.Scanner;

public class Date {
	private final int value;
	public Date(int year,int month,int day){
		value = year*512+month*32+day;
	}
	public int year(){
		return value/512;
	}
	public int month(){
		return (value/32)%16;
	}
	public int day(){
		return value%32;
	}
	public String toString(){
		return ""+month()+"/"+day()+"/"+year();
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
        int y=0,m=0,d=0;
		while(scan.hasNextInt()){
              y = scan.nextInt();
              m = scan.nextInt();
              d = scan.nextInt();
        
		Date date = new Date(y,m,d);
	    System.out.println(date.month());
	    System.out.println(date.day());
	    System.out.println(date.year());
	    System.out.println(date);
	    }
	}
}
