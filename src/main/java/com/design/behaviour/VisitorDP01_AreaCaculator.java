package com.design.behaviour;

import java.util.ArrayList;
import java.util.List;

//visitor Interface 
interface ShapeVisitor {
	void visit(Circle circle);

	void visit(Square square);

	void visit(Triangle triangle);
}

class AreaCalculator implements ShapeVisitor {
	private double totalArea = 0;
	double radiusOfCircle = 5;
	double sideOfSquare = 4;
	double baseOfTriangle = 3;
	double heightOfTriangle = 6;

	@Override
	public void visit(Circle circle) {
		 totalArea += Math.PI * Math.pow(radiusOfCircle, 2);

	}

	@Override
	public void visit(Square square) {
		 totalArea += Math.pow(sideOfSquare, 2);

	}

	@Override
	public void visit(Triangle triangle) {
		 totalArea += (baseOfTriangle * heightOfTriangle) / 2;

	}
	public double totalAreaInSerface() {
		return totalArea;
	}
}

//Element Interface
interface Shape {
	void accept(ShapeVisitor visitor);
}

class Circle implements Shape {

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visit(this);
	}
}

class Square implements Shape {
	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visit(this);
	}
}

class Triangle implements Shape {
	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visit(this);
	}
}

public class VisitorDP01_AreaCaculator {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        shapes.add(new Triangle());
             
		AreaCalculator areaCalculator=new AreaCalculator();
		
		 for (Shape shape : shapes) {
	            shape.accept(areaCalculator);
	        }
		System.out.println("Total Area is :"+areaCalculator.totalAreaInSerface());
	}

}
