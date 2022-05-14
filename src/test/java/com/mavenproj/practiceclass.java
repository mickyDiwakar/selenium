package com.mavenproj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.stream.events.Characters;

public class practiceclass {
	public static void main(String[] args) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("firstName", "diwakar");
		map.put("lastname", "kumar");
		map.put("age",null);
		map.put(null, 12);
		System.out.println(map.containsKey(null));;
		System.out.println(map.containsValue(null));
		
		for(String s:map.keySet()) {
			System.out.println(s+":="+map.get(s));
		}
		
		for(Object t:map.values()) {
			System.out.println(t);
		}
		Collection<Object>c=map.values();
		
		 String str="india is india is my country is";
		 String[] arr=str.split(" ");
		 Map<String,Integer> word=new HashMap<String,Integer>();
		for(String s:arr) {
		if(word.containsKey(s)) {
			word.put(s,word.get(s)+1 );
		}else {
			word.put(s, 1);
		}
		}
		Set<Map.Entry<String, Integer>>worcound=word.entrySet();
		for(Map.Entry mapword:worcound) {
			System.out.println(mapword.getKey()+":"+mapword.getValue());
		}
		//Set<Map.Entry<String, Integer>>m=mapp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		//		.collect(Collectors.toSet());
		System.out.println("********************sortedmap****************888");
		 SortedMap<String,Integer> sm=new TreeMap<String, Integer>();
		sm.putAll(word);
		Set<Map.Entry<String,Integer>>tree=sm.entrySet();
		for(Map.Entry maptree:tree) {
			System.out.println(maptree.getKey()+":"+maptree.getValue());
			
		}
		System.out.println("****************************************************");
		
		//String practice
		String str1="india";
		String str2="";
		char[] ch=str1.toCharArray();
		for(int i=0;i<ch.length;i++) {
			
		}
		for(int i=0;i<str1.length();i++) {
			//System.out.println(str1.lastIndexOf('a'));
			
			if(!str2.contains(Character.toString(str1.charAt(i)))) {
				//str2=str2+str1.charAt(i);
			}
			
		}
		//contain salways take string and there is 2 methd 
		for(int i=0;i<str1.length();i++) {
			//System.out.println(str1.lastIndexOf('a'));
			
			if(!str2.contains(String.valueOf(str1.charAt(i)))) {
				str2=str2+str1.charAt(i);
			}
			
		}
		
		System.out.println("str2"+str2);
		System.out.println("*************************************************theend **********************");
		String pstr="india is is my county my";
		Map<String,Integer> mapp=new HashMap<String,Integer>();
		String arrp[]=pstr.split(" ");
		for(String s:arrp) {
			if(mapp.containsKey(s)) {
				mapp.put(s, mapp.get(s)+1);
				
			}else {
				mapp.put(s, 1);
			}
		}
		
		/*
		 * for(Map.Entry<String, Integer> pmapp:m) { //pmapp.setValue(5);
		 * System.out.println(pmapp.getKey()+":"+pmapp.getValue()); }
		 */
		String s="india is my country";
		String temp = "";
		//s=s.replace('i', 'x');
		//s.inte
		String arrs[]=s.split(" ");
		System.out.println(arrs.length);
		int count=0;
		for(String word1:arrs) {
			String charfirst=String.valueOf(word1.charAt(0));
			temp=temp+charfirst.toUpperCase()+word1.substring(1);
			count++;
			 if(count!=arrs.length)   { temp=temp+" "; }
		}

		System.out.println(temp.trim());
	}

	
}
