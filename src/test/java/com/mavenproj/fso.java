package com.mavenproj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class fso {
	
	public static void main(String args[]) throws IOException {
		String str="C:\\Users\\Admin\\Desktop\\test.txt";
		File f=new File(str);
		String readstr = "";
		Scanner scan=null;
		try {
			 scan= new Scanner(f);
			while(scan.hasNextLine()){
				readstr=readstr+scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			scan.close();
		}
		System.out.println(readstr);
		String arr[]=readstr.split("india");
		System.out.println(arr.length-1);
		
		//===========================================================
		//String Str2="";
		StringBuilder Str2=new StringBuilder();
		Map<String,Integer> wordcount=new HashMap<String,Integer>();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(str));
			String str2="";
			while((str2=reader.readLine())!=null) {
				Str2.append(str2+" ");
				//Str2=Str2+str2+" ";
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Str2);
		String[] arr1=Str2.toString().split(" ");
		//int i=arr1.length;
		//System.out.println(i);
		for(int i=0;i<arr1.length;i++) {
			if(wordcount.containsKey(arr1[i])) {
				wordcount.put(arr1[i], wordcount.get(arr1[i])+1);
				
				 
			}else {
				wordcount.put(arr1[i], 1);
			}
		}
		Set<Map.Entry<String, Integer>> word=wordcount.entrySet();
		for(Map.Entry<String, Integer>m:word) {
			System.out.println(m.getKey()+":"+m.getValue());
		}
		
	// read char by char
		BufferedReader readchar=new BufferedReader(new FileReader(str));
		int i=0;
		
		String s="";
		while((i=readchar.read())!=-1) {
			s=s+(char)i;
			
			
		}
		System.out.println("the string is"+s);
		//========================
		
			
	}
	
}
