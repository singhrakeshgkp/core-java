package com.java.ds.sorting;

import java.util.Arrays;

public class MergeSort {
	
	private static void megeSort(int [] arr, int p,int r) {
		if(p<r) {
			int q = (p+r)/2;
			megeSort(arr, p, q);
			megeSort(arr,q+1,r);
			merge(arr,p,q,r);

	}
		
	}
	private static void merge(int[] arr, int p, int q, int r) {
		/*1. n1 = q-p+1
		 *2. n2 = r-q
		 *3. Let L[1..n1+1], R[1...n2+1] to be new array
		 *4. for i=1 to n1
		 *5. 	L[i] = arr[p+i-1]
		 *6. for j=1 to n2
		 *7. 	R[j] = arr[q+j]
		 *8. i=1
		 *9  j=1
		 *10.k=p to r
		 *11.	if L[i]<=R[j]
		 *12.		K[p] = L[i]
		 *13.		i = i+1
		 *14.	else  K[p] = R[j]
		 *15.		  j =  j+1
		 *  */
		int n1 = q-p+1;
		int n2 = r-q;
		int [] left = new int[n1];
		int [] right = new int [n2];
		for(int i =0; i<n1; i++) {
			left[i] = arr[p+i-1];
		}
		for(int j =0; j<n2; j++) {
			right[j] = arr[q+j];
		}
		
		//made k=p-1 instead k= p and k<r-1 instead of k<r java array index start from 0;
		int i=0, j =0, k = p-1;
		
		while(n1>i && n2>j) {

			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i = i+1;
			}else {
				arr[k] = right[j];
				j = j+1;
			}
		k++;
		}
		
		/*
		 * as here we are not initializing array with infinite value so copy the
		 * remaining element of leftArr copy the remaining element of reightArr
		 */
		while(n1>i) {
			arr[k] = left[i];
			i = i+1;
			k = k+1;
		}
		
	   while(n2>j) {
		   arr[k] = right[j];
		   j = j+1;
		   k = k+1;
	   }
	}
	public static void main(String[] args) {
	
		int[] arr = {9,4,10,3,20,5,30,222,111,23,1};
		megeSort(arr, 1, arr.length);
		Arrays.stream(arr).forEach(System.out::println);
	}

}
