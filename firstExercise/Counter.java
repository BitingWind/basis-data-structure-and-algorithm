package firstExercise;

public class Counter {
	private final String name;
	private  int count;
	public Counter(String name){
		this.name = name;
	}
	public void increment(){
		count++;
	}
	public int tally(){
		return count;
	}
	//@override
	public String toString(){
		return "Counter-"+name+"  value:"+count;
	}
	public static  void main(String[] args){
		Counter coun = new Counter("myCounter");
		for(int i=0;i<10;i++){
			coun.increment();
			System.out.println(coun.tally());
		}
		System.out.println(coun);
	}
}
