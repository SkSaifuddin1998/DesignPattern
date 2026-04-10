package com.design.creational;

interface Car {
	void assemble();
}

class Sedan implements Car{
	
	@Override
	public void assemble() {
		System.out.println("Asembly Sedan Car");	
	}
}

class HatchBreak implements Car{
	
	@Override
	public void assemble() {
		System.out.println("Asembly HatchBreak Car");	
	}
}

interface CarSpecification {
	void display();
}

class NorthAmericaSpecifcation implements CarSpecification {
	
	@Override
	public void display() {
        System.out.println("North America Car Specification: Safety features compliant with local regulations.");	
	}
}

class EuropeCarSpecifcation implements CarSpecification {
	
	@Override
	public void display() {
        System.out.println("Europe Car Specification: Fuel efficiency and emissions compliant with EU standards.");
	}
}

interface CarFactory {
	Car createCar();
	CarSpecification carSpecification();
}

class NorthAmericaCarFactory implements CarFactory {
	@Override
	public Car createCar() {
		return new Sedan();
	}
	
	@Override
	public CarSpecification carSpecification() {
		return new NorthAmericaSpecifcation();
	}
}

class EuropeCarFactory implements CarFactory {
	@Override
	public Car createCar() {
		return new HatchBreak();
	}
	
	@Override
	public CarSpecification carSpecification() {
		return new EuropeCarSpecifcation();
	}
}

public class AbstractFactoryDP01_CarDelivery {

	public static void main(String[] args) {
		CarFactory factory=new NorthAmericaCarFactory();
		Car car=factory.createCar();
		CarSpecification specification=factory.carSpecification();
		car.assemble();
		specification.display();
		
		
		
		CarFactory factory1=new EuropeCarFactory();
		Car car1=factory1.createCar();
		CarSpecification specification1=factory.carSpecification();
		car1.assemble();
		specification1.display();

	}

}
