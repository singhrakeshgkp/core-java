package com.java.dsa.qa;

public class CalculatingGCD {
	/*1. Calculate GCD of two numbers using Basic Euclidean Algorithm
	 * 	1.1 GCD(a,b)
	 *	1.2 if(a == 0) return b;
	 *	1.3 return gcd(b%a,a)
	 *
	 *2. Calcualte GCD of multiple numbers using Extended Euclidean Algorithm
	 *	2.1
	 *	2.1
	 *	2.3
	 *	2.4
	 *	2.5
	 * */

	
	public static void main(String[] args) {
		
		/*
		int a = 45;
		int b = 9;0
		int gcd = gcdBasicApproach(a, b);
		System.out.println(gcd);
		int c=-41%45;
		System.out.println("modulo "+c);
		*/
		
		int a =45, b= 25, x=1, y=1;
		int gcd = gcdExtendedApproach(a, b, x, y);
		System.out.println(gcd);
	}
	
	//1. Approach
	public static int gcdBasicApproach(int a, int b) {
		if(a==0)
			return b;
		return gcdBasicApproach(b%a,a);
	}
	
  //2. Approach 2 Extended
  public static int gcdExtendedApproach(int a, int b, int x, int y) {
	  
	  //base case
	  if(a==0) {
		  x=0;
		  y=1;
		  return b;
	  }
	  
	  int x1 =1;
	  int y1=1;// to store the result of recursive calls
	  int gcd = gcdExtendedApproach(b%a, a, x1, y1);
	  x= y1-(b/a)*x1;
	  y = x1;
	  return gcd;
	  
  }
	
	
}
