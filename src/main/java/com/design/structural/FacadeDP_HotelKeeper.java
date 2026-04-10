package com.design.structural;

//https://www.geeksforgeeks.org/facade-design-pattern-introduction/
interface Hotel {
	public String getMenus();
}

class VegMenu implements Hotel {

	@Override
	public String getMenus() {

		return "Veg Menu ";
	}
}

class NonVegMenu implements Hotel {

	@Override
	public String getMenus() {
		return "NonVeg Menu ";
	}
}

class NonAndVegMenu implements Hotel {

	@Override
	public String getMenus() {
		return "NonAndVegMenu";
	}
}

interface HotelKeeper {
	String getVegMenu();
	String getNonVegMenu();
	String getNonAndVegMenu();	
}

class HotelKeeperImpl implements HotelKeeper{
	
	@Override
	public String getVegMenu() {
		Hotel veg=new VegMenu();
		return veg.getMenus();	
	}
	@Override
	public String getNonVegMenu() {
		Hotel nonveg=new NonVegMenu();
		return nonveg.getMenus();
	}
	@Override
	public String getNonAndVegMenu() {
		Hotel nonandveg=new NonAndVegMenu();
		return nonandveg.getMenus();
	}
}

public class FacadeDP_HotelKeeper {

	public static void main(String[] args) {
		
		HotelKeeper keeper=new HotelKeeperImpl();
		
		System.out.println(keeper.getVegMenu());
		System.out.println(keeper.getNonVegMenu());
		System.out.println(keeper.getNonAndVegMenu());

	}
}
