package com.design.creational;

interface MotorVehicle {
	void build();
}

class MotorCycle implements MotorVehicle {
	@Override
	public void build() {
		System.out.println("manufacture the MotorCycle ");		
	}
}

class FourWheelerCar implements MotorVehicle {
	@Override
	public void build() {
		System.out.println("manufacture the FourWheelerCar ");		
	}
}

 abstract class MotorVehicleFactory {
	 abstract MotorVehicle buildFactory();
	 
	 void SupplyCar() {
		 MotorVehicle motor= buildFactory();
		 motor.build();
	 }
 }
 
 class MotorCycleFactory extends MotorVehicleFactory{
	 
	 @Override
	MotorVehicle buildFactory() {
		return new MotorCycle();
	}
 }
 
class FourWheelerFactory extends MotorVehicleFactory{
	 
	 @Override
	MotorVehicle buildFactory() {
		 return new FourWheelerCar();
	}
 }

public class FactoryDP_02_MotorVehicle {

	public static void main(String[] args) {
		MotorVehicleFactory build;
		
		build=new MotorCycleFactory();
		build.SupplyCar();
		
		build=new FourWheelerFactory();
		build.SupplyCar();
	}

}
