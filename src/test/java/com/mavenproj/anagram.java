package com.mavenproj;

import java.util.Arrays;
import java.util.regex.Pattern;

//import org.apache.commons.io.input.SwappedDataInputStream;

public class anagram {
	//public String s1=" peek";
	//public String s2="keep";
	public static void anagramcheck(String s1,String s2)throws invalidinputexception{
		int flag=0;
		StringBuilder builder=new StringBuilder(s1);
		StringBuffer buffer=new StringBuffer(s2);
		int age=18;
		if(age<18){
			throw new invalidinputexception("invalid age");
		}
		if(builder.length()!=buffer.length()) {
			flag=1;
		}
		else {
			
			char[] charr1=builder.toString().toCharArray();
			Arrays.sort(charr1);
		//	Character.isLowerCase(arg0)
			//Character.toString(c)
			//String.valueOf(arg0)
			
			for(int i=0;i<charr1.length;i++) {
				if(!buffer.toString().contains(String.valueOf(charr1[i]))) {
					flag=1;
				}
			}
		}
		if(flag==1) {
			System.out.println("not anagram");
		}else {
			System.out.println(" anagram");
		}
	}
	static void swapwithwithtemp(String s1,String s2){
	String a=s1; //lovely
	String b=s2; //you
	
	a=a+" "+b; //lovely you
	b=a.substring(0, a.length()-b.length());  //lovely
	System.out.println(b.length());
	a=a.substring(b.length());
			System.out.println(a+b);
		int i=b.lastIndexOf('v');
		System.out.println(i);
		
	}
	static boolean regexpfordate(String text) {
		String regex="^(0[1-9]|[1-2][0-9]|3[0-1])(/|-)([0-1][0-9])(/|-)((19|20)[0-9]{2})$";
		return Pattern.matches(regex, text);
		
		
	}
	static boolean regexforemail(String text) {
		//+means any number of charfrom the given[a-zAz]
		String regex="^([a-zA-Z.-_])+@[a-z]+.[a-z]{2,3}$";
		return Pattern.matches(regex, text);
	}
	public static void main(String[] args) {
		try{
			anagramcheck("keep","peek");
		}catch(Exception e){
			System.out.println("expction is"+e);
		}
		//anagramcheck("keep","peek");
		swapwithwithtemp("lovely","you");
		boolean value=regexpfordate("18-10-2009");
		System.out.println(value);
		boolean valuemail=regexforemail("micky.diwakar@gmail.com");
		System.out.println("email"+valuemail);
	}
}
