package com.design.structural;

interface Coffie {
	String getDescription();

	Double getCost();
}

class PlainCoffie implements Coffie {

	@Override
	public Double getCost() {
		return 10.5;
	}

	@Override
	public String getDescription() {

		return "Plain Coffie";
	}
}

class CoffeeDecorator implements Coffie {

	private Coffie coffie;

	public CoffeeDecorator(Coffie coffeeDecorator) {
		this.coffie = coffeeDecorator;
	}

	@Override
	public String getDescription() {
		return coffie.getDescription();
	}

	@Override
	public Double getCost() {
		return coffie.getCost();
	}
}

class MilkDecorator extends CoffeeDecorator{
	
	public MilkDecorator(Coffie decoratedCoffie) {
		super(decoratedCoffie);
	}
	@Override
	public String getDescription() {
		return super.getDescription()+" with Milk";
	}
	@Override
	public Double getCost() {
		return super.getCost()+50.0;
	}
}

class SugarDecorator extends CoffeeDecorator{
	
	public SugarDecorator(Coffie decoratedCoffie) {
		super(decoratedCoffie);
	}
	@Override
	public String getDescription() {
		return super.getDescription()+" with Sugar";
	}
	@Override
	public Double getCost() {
		return super.getCost()+10.0;
	}
}
public class DecoratorDP_CoffeShop {

	public static void main(String[] args) {
		
		Coffie plainCoffie=new PlainCoffie();
		System.out.println("Description: "+plainCoffie.getDescription());
		System.out.println("Cost: "+plainCoffie.getCost());
		
		Coffie milkCoffee=new MilkDecorator(new PlainCoffie());
		System.out.println("MilkCoffie Description: "+milkCoffee.getDescription());
		System.out.println("Milk Coffie :"+milkCoffee.getCost());
		
		Coffie sugarCoffie=new SugarDecorator(milkCoffee);
		System.out.println("Sugar Coffie :"+sugarCoffie.getDescription());
		System.out.println("Cost :"+sugarCoffie.getCost());

	}

}
