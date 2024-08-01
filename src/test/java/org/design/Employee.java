package org.design;

public class Employee {
	
	public static Employee e;//null
	
	private Employee() {
		
	}
	
	public static Employee getInstance() {
		if(e==null) {
		 e=new Employee();
		}
		return e;

	}
	
	
	public static void main(String[] args) {
		
		Employee e = getInstance();
		System.out.println(System.identityHashCode(e));
		
		Employee e1 = getInstance();
		System.out.println(System.identityHashCode(e1));
		
		
	}
	
	
	

}
