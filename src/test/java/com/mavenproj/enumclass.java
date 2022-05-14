package com.mavenproj;
//emnum is a dataType
//enum can be inside a class but not inisde a metd
//values() give the value of enum  //return arrary
//ordinal() gve index of value of enum / return int
public class enumclass {
	enum Days{
		//declare a enum with constructor thaty ()
		Sunday(1,"First"),Monday(2),Tuesday(3) ; //Public static final 
		private int value;
		private String weekdays;
		private Days(int index) {
			this.value=index;
		}
		//take value by gettterof each varable
		private Days(int index,String s) {
			this.value=index;
			this.weekdays=s;
		}
		public int getvalue() {
			return value;
			
		}
		public String getweekdays() {
			return weekdays;
		}
		
	}
	
		
	
	
	public static void main(String[] args) {
		
		Days d=Days.Monday;
		System.out.println(d); //monday
		
		Days[] arr=Days.values();
		
		//get the index of particular enum
		
	
		int value=arr[0].getvalue();
		System.out.println(value+"from sunday");
		
		for(Days f: Days.values()) {
			System.out.println(f); //iterate all and print
			System.out.println("orignal value ie index of each:"+f.ordinal()); //give the index
			System.out.println("value of each"+f.getvalue());
			System.out.println("value of searial week"+f.getweekdays());
		}
		
		Days f=Days.Sunday;
		switch(f) {
		case Sunday:
			System.out.println("switch to "+Days.valueOf("Sunday"));
						break;
		case Monday:
			System.out.println("switch to"+Days.valueOf("Monday"));
				break;
		
		case Tuesday:
			System.out.println("switch to "+f);
				break;
		
			
		}
		
	}
}

