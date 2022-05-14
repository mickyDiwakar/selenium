package com.mavenproj;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class testngclassforAssignment {
	public static void main(String[] args) {
		Set<String> s=new HashSet<String>();
		s.add("ram");
		s.add("mohan");
		Set<String> s1=new HashSet<String>();
		s1.add("ram");
		s1.add("mohan");
		String[] arr=s.toArray(new String[s.size()]);
		boolean b=s.equals(s1);
		System.out.println(b);
		Iterator<String>it=s1.iterator();
		it.next();
		
	}
	
	

}
