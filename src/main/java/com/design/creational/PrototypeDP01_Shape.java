package com.design.creational;

interface Shape {
	Shape clone();
	void draw();
}

class Circle implements Shape {
	
	private String color ;
	
	public Circle(String color) {
		this.color=color;
	}
	
	@Override
	public void draw() {
		System.out.println("Draw the Circle with :"+color);
		
	}
	@Override
	public Shape clone() {
		return new Circle(color);
	}
}

class ShapeClient {
	private Shape shape;
	
	public ShapeClient(Shape shape) {
		this.shape=shape;
	}
	
	public Shape cloneCircle() {
		return shape.clone();
	}
}

public class PrototypeDP01_Shape {

	public static void main(String[] args) {
		Shape shape=new Circle("Red");
		ShapeClient shapeClient=new ShapeClient(shape);
		Shape clone=shapeClient.cloneCircle();
		clone.draw();
		System.out.println(clone.hashCode());
		
		Shape shape1=new Circle("Green");
		ShapeClient shapeClient1=new ShapeClient(shape1);
		Shape clone1=shapeClient1.cloneCircle();
		clone1.draw();
		System.out.println(clone1.hashCode());
		

	}

}
