
package com.mavenproj;

public  class Bike10 {
	final int speedlimit;// blank final variable
private int a;
	public int getA() {
	return a;
}

public void setA(int a) {
	
	try {
		this.a = a;
		System.out.println("a="+a);
		a=a/0;
	} catch (ArithmeticException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//System.out.println(e.);
		
	}catch(Exception ex ) {
		System.out.println(ex.getMessage());
	}
}

	Bike10() {
		speedlimit = 70;
		System.out.println(speedlimit);
	}
	

	public static void main(String args[]) {
		 
		new Bike10();
		Bike10 b=new Bike10();
		b.setA(6);
		
		System.out.println("a"+b.getA());
	};
}

 