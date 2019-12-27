package com.yc.java.d1220;

/**
6、写一个类用来模拟栈这种数据结构，要求底层使用数组存储数据，并给出相应的
   进栈和出栈的方法
 */
public class StackTest {
	
	public static void main(String[] args) {
		
		/**
		 * 一个类在定义了有参数的构造方法之后，
		 * 原有的无参数的（系统默认提供的）构造方法就失效了
		 */
		Stack stack = new Stack(10);
		
		stack.push(5);
		stack.push(8);
		stack.push(10);
		
		System.out.println(stack.pop());   // ==> 10
		System.out.println(stack.pop());   // ==> 8
		
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		stack.push(8);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
		
	}

}
