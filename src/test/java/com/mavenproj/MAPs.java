package com.mavenproj;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MAPs {
		
	public static void main(String[] args) {
		Map<String,String> m=new HashMap<String,String>();
		m.put("Name", "Diwakar");
		m.put("last", "Kumar");
		m.put("las", "kumar");
		m.put("surname", "choudhary");
		m.put(null, "k");//hashmap one key ca be null
		m.remove("surname");
		String s=m.get("Name");
		System.out.println(s);
		String s1=m.remove("surname");
		System.out.println("s1 is"+s1);
		//m.putAll(m);
		//contains key or not check
		boolean b=m.containsKey("last");
		System.out.println(b); //true
		boolean k=m.containsValue("Diwakar");
		System.out.println(k);//true
		//"all key will display using keyset"
		//get keys
		Set<String> set =m.keySet();
		System.out.println("_________________display the key___________________"+set);
		for(String i:set) {
			System.out.println("key="+i);
		}
		//or
		Iterator<String>it=set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//onlye values
		
		Collection<String> collectionofmapvalue =m.values();
		for(String value:m.values()) {
			System.out.println("value="+value);
		}
		//get key value pair
		for(String name:m.keySet()) {
			System.out.println(name+":"+m.get(name));
			
		}
		Set<Map.Entry<String, String>> kv=m.entrySet();
		for(Map.Entry<String,String> v:kv) {
			System.out.println(v.getKey()+":"+v.getValue());
			
		}
		
		Hashtable<String, String> hs=new Hashtable<String, String>();
		hs.put("name", "hashdiwakat:");
		//hs.put(null, "bal"); //hastable not accept null key or value
		Set<String> ks=hs.keySet();
		Set<Map.Entry<String,String>> mtable=hs.entrySet();
		
		
		for (Map.Entry<String, String> h:mtable) {
			h.getKey();
			h.getValue();
			
		}
		System.out.println("kya ye sahi hai"+m.equals(m));
		System.out.println("********linkedmap**********");
		Map<String,String> lmap=new LinkedHashMap<String, String>();
		lmap.putAll(m);
		for(String s2:lmap.keySet()) {
			System.out.println(s2);
		}
		
		TreeMap<String,String>tm=new TreeMap<String,String>();
		//tm.put(null, "ram"); tree map caanot take null key
		tm.putAll(m);
		
		
	
		for(String s2:lmap.keySet()) {
			System.out.println(s2);
		}
		
		
		
		
	}
}
