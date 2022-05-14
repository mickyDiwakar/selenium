package com.mavenproj;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class hashset {
	public static void main(String[] args) throws MalformedURLException, IOException {
		Set<String> s=new HashSet<String>();
		Set<String> e=new HashSet<String>();
		//String arr1[]=new String[s.size()];
		String arr[]=new String[] {"ram","shyam","ram",null};
		
		for(int i=0;i<arr.length;i++) {
			s.add(arr[i]);
		}
		//s.toarray return object array but if u want string or other type
		//then passin toarary
		 Object[] arr1=s.toArray();
		String[] arrstr= s.toArray(new String[s.size()]);
		 for(Object i:arr1) {
			 System.out.println(i);
		 }
		 e.addAll(s);
		 for(String d:e) {
			 System.out.println(d);
		 }
		 
		 boolean b=s.containsAll(e);
		 System.out.println(b);
		Iterator<String>it=s.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//maintain insertio ordrr
		Set<String> ls=new LinkedHashSet<String>();
		ls.add("ram");
		ls.add(null);
		ls.add("shyam");
		ls.add("mohan");
		//ls.addAll(s);
		System.out.println("*************linkedhasset**********");
		for(String i:ls) {
			
			System.out.println(i);
		}
		SortedSet<String> ss=new TreeSet<String>();
		ss.add("diwakar");
		ss.add("prabhakar");
		ss.add("sandhya");
		ss.add("lovely");
		System.out.println("___________****treeset***____________");
		for(String i:ss) {
			System.out.println("treeset"+i);
			/*
			 * treesetdiwakar treesetlovely treesetprabhakar treesetsandhya
			 */
		}
		System.out.println("first set:"+ss.first());
		System.out.println("lastset"+ss.last());
		System.out.println("headset is"+ss.headSet("sandhya"));
		System.out.println("tailset is"+ss.tailSet("prabhakar"));
		System.out.println("subsetis"+ss.subSet("diwakar", "sandhya"));;
		//check broken link
		String url="htts//google.com";
		HttpURLConnection huc=null;
		huc=(HttpURLConnection)(new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();
		int responsecode=huc.getResponseCode();
		if(responsecode>=400) {
			System.out.println("link is broken");
			
		}
		
		
	}
	
	
	
	
	

}
