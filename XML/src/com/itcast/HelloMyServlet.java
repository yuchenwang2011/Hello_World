package com.itcast;

public class HelloMyServlet {
	public void add() {
		System.out.println("no parameter add method");
	}
	public void add(int i, int j) {
		System.out.println("result = " +  (i + j));
	}
	public int add(int i) {
		int result = i + 1;
		System.out.println("result = " + result);
		return result;
	}
}
