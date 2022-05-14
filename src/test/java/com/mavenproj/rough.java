package com.mavenproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class rough {
	public static void main (String[] args) {
		String str="india is my country";
		String temp="";
		String[] arrstr=str.split(" ");
		int count=0;
		for(String s:arrstr) {
		temp=temp+String.valueOf(Character.toUpperCase(s.charAt(0)))+s.substring(1)+" ";
		count++;
		  if(count!=arrstr.length)   { temp=temp+" "; }
			 
		}
		boolean b=Character.isUpperCase(temp.charAt(0));
		char[] c=str.toCharArray();
		Map<Character,Integer>map=new HashMap<Character,Integer>();
		for(char c1:c) {
			if(map.containsKey(c1)) {
				map.put(c1, (map.get(c1))+1);
			}else {
				map.put(c1, 1);
			}
		}
		for(Character s:map.keySet()) {
			System.out.println(s+":"+map.get(s));
		}
		
}}
