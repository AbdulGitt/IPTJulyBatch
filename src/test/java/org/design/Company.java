package org.design;

public class Company {
	
	public static void main(String[] args) {
		
			Employee e1 = Employee.getInstance();	
			System.out.println(System.identityHashCode(e1));
			
			
	}

}
