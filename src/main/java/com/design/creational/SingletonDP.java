package com.design.creational;

class Printer {
	private static Printer instance;

	public Printer() {
		System.out.println("0-PARAM CONSTRUCTOR");
	}

	public static Printer getInstance() {
		if (instance == null)
			instance = new Printer();
		return instance;
	}

	public String mes() {
		return "Singleton Instance Business Methods ";
	}
}
class DoubleChekingSingleton {
	private static volatile DoubleChekingSingleton instance;

	private DoubleChekingSingleton() {
		// private constructor to prevent instantiation
	}

	public static DoubleChekingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleChekingSingleton.class) {
				if (instance == null) {
					instance = new DoubleChekingSingleton();
				}
			}
		}
		return instance;
	}
}

public class SingletonDP {

	public static void main(String[] args) {
		Printer printer=Printer.getInstance();
		System.out.println(printer.hashCode());
		
		Printer printer1=Printer.getInstance();
		System.out.println(printer1.hashCode());
		
		DoubleChekingSingleton doubleChecking=DoubleChekingSingleton.getInstance();
		System.out.println(doubleChecking.hashCode());
		
		DoubleChekingSingleton doubleChecking1=DoubleChekingSingleton.getInstance();
		System.out.println(doubleChecking1.hashCode());

	}

}
