package com.mavenproj;

public class ToolsQA {
	public static void main(String[] args) {
		String str="india is my country";
		String temp="";
		String[] arr=str.split(" ");
		for(String s:arr) {
			System.out.println(s);
		}
		for(int i=arr.length-1;i>=0;i--)	{
			temp=temp+arr[i]+" ";
			//System.out.println("temp is="+temp);
		}
		System.out.println("temp is="+temp);
	}
			
}
