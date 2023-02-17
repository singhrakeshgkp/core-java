package com.java.ds.sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestClass {

	public static void mergeSort(int[] arr, int p, int r) {
		
	}
	
	
	private static void merge(int[] arr, int p, int q, int r) {
		
	}


	public static void main(String[] args) {
		
		Map<String, String> hashMap = new Hashtable<>();
		hashMap.put("rakesh", "singh");
		//hashMap= Collections.synchronizedMap(hashMap);
	 Iterator<Entry<String, String>> itr =	hashMap.entrySet().iterator();
	 while(itr.hasNext()) {
		 Entry<String,String> entry = itr.next();
		 System.out.println(entry.getKey());
		// hashMap.put("rohan", "kumar");
		 itr.remove();
	 }
	}
}
