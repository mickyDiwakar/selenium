package com.mavenproj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class arraylist {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//finding missing elelment
		try {
			int num=5;
			num=5/0;
			
			
		}catch(Exception e){
			//e.printStackTrace();
		}
		Integer[] arr= {1,3,4,5,5};
		List<Integer>list=	Arrays.asList(arr);
		
		list=new ArrayList<Integer>(list);
		
		//remove duplicate from list
		Set<Integer>set=new HashSet<Integer>(list);
		list.clear();
		
		list=new ArrayList<Integer>(set);
		ListIterator<Integer>l=list.listIterator(list.size());
		System.out.println("-------------------print in revser order listiterator travse in both direction");
		while(l.hasPrevious()) {
			
			System.out.println(l.previous());
		}
		
		
		Iterator<Integer>it=list.iterator();
		Collections.reverse(list);
		//Collections.sort(list, Comparator.reverseOrder());
		Collections.unmodifiableList(list);//now we cannot add or delete any thing form loist
		//list.add(8);
		while(it.hasNext()) {
			System.out.println("iterator"+it.next());
		}
		for(Integer i:list) {
			System.out.println(i);
		}
		System.out.println("index of any number"+list.indexOf(1));
		for(int i=1;i<=5;i++) {
			System.out.println(list.contains(i));
			if(!list.contains(i)) {
				
				System.out.println("it is mising"+i);
			}
			
		}
		
		//linklist
		List<Integer> list1=new LinkedList<Integer>();
		for(Integer i=0;i<10;i++) {
			list1.add(i);
		}
		
		list1.remove(9);
		//vector is dynamic array
		Vector<String>vector=new Vector<String>();
		vector.add("9");
		
		System.out.println(vector.indexOf("9"));
		//stack subclass of vetcor and support lastin dirst out
		Stack<String>stack=new Stack<String>();
		stack.add("dil");
		stack.push("diwa");
		stack.push("ram");
		stack.pop();//remove ram
		System.out.println("show topvalue in stack out not remove"+stack.peek());
		System.out.println("seach"+stack.search("diwa"));
		Iterator<String>itstack=stack.iterator();
		while(itstack.hasNext()){
			System.out.println(itstack.next());
		}
		
		Queue<String>queue=new PriorityQueue<String>();
		queue.add("jay");
		queue.add("ram1");
		queue.add("shoan2");
		//retrive top of the queu but not remove
		System.out.println("element:"+queue.element());
		//retrive top and delete from queue
		System.out.println("poll:"+queue.poll());
		
		System.out.println("size of the queue"+queue.size());
		for(String queue1:queue) {
			System.out.println(queue1);
		}
		
		List<Integer>listforsort=new ArrayList<Integer>();
		listforsort.add(2);
		listforsort.add(1);
		listforsort.add(9);
		System.out.println("***************asencding order*************");
		Collections.sort(listforsort);
			for(Integer i:listforsort) {
				System.out.println(i);
			}
			System.out.println("***************desendng order*************");
			@SuppressWarnings("rawtypes")
			Comparator comp=Collections.reverseOrder();
			
			Collections.sort(listforsort,Comparator.reverseOrder());
			//or
			Collections.sort(listforsort,comp);
			for(Integer i:listforsort) {
				System.out.println(i);
			}
			
	}

	


}
