package dataType;

public class Student implements Comparable<Student>{
	public static Student newStu(String s,int id){
		return new Student(s,id);
	}
	private volatile int hashCode;
	private String name;
	private int id;
	public Student(String name,int id){
		this.name = name;
		this.id = id;
	}
	//@override
	public int compareTo(Student that){
		if( this.name.compareTo(that.name) == 0){
			if(this.id<that.id)return -1;
			else if(this.id>that.id)return 1;
			else return 0;
		}
		else return this.name.compareTo(that.name);
	}
	//@override
	public boolean equals(Object o){
		if(!(o instanceof Student))return false;
		Student that = (Student)o;
		if(!(this.name.equals(that.name)))return false;
		if(this.id!=that.id) return false;
		return true;
	}
	//@override
	public String toString(){
		return ""+name+" : "+id;
	}
	public int hasCode(){
		int result = hashCode;
		if(result == 0){
			result = 17;
			result = result*31 + name.hashCode();
			result = result*31 + ((Integer)id).hashCode();
			hashCode  = result;
		}
		return result;
	}
}