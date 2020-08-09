package com.sourcelamdaExpressions2;

public class Runable {
	public static void main(String[] args) {
	// Using anonymous innerclass 
	new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("Hello world !");
		}
	}).start();
	 
	// Using lambda expression
	new Thread(() -> System.out.println("Hello world !")).start();
	 
	// Using anonymous innerclass
	Runnable race1 = new Runnable() {
		@Override
		public void run() {
			System.out.println("Hello world !");
		}
	};
	 
	// Using lambda expression
	Runnable race2 = () -> System.out.println("Hello world !");
	 
	// Run em!
	race1.run();
	race2.run();

}
}