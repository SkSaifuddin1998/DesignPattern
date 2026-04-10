package com.design.creational;

class House {
	private String walls;
	private String roofs;
	private String windows;
	private String door;
	
	
	@Override
	public String toString() {
		return "House [walls=" + walls + ", roofs=" + roofs + ", windows=" + windows + ", door=" + door + "]";
	}
	public String getWalls() {
		return walls;
	}
	public void setWalls(String walls) {
		this.walls = walls;
	}
	public String getRoofs() {
		return roofs;
	}
	public void setRoofs(String roofs) {
		this.roofs = roofs;
	}
	public String getWindows() {
		return windows;
	}
	public void setWindows(String windows) {
		this.windows = windows;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		this.door = door;
	}	
}

interface HouseBuilder {
	void buildWalls();
	void buildRoofs();
	void buildDoors();
	void buildWindows();
	House getHouse();
}

class ConcreateHouseBuilder implements HouseBuilder{
	private House house;
	
	public ConcreateHouseBuilder() {
		this.house=new House();
	}

	@Override
	public void buildWalls() {
		house.setWalls("set the wallas");		
	}
	@Override
	public void buildRoofs() {
		house.setRoofs("set the House Roofs");		
	}
	
	@Override
	public void buildDoors() {
	 house.setDoor("Set the Doors");
		
	}
	@Override
	public void buildWindows() {
		house.setWindows("Set the Windows");	
	}
	@Override
	public House getHouse() {
		return this.house;
	}	
}

class HouseDecorator {
	private HouseBuilder builder;

	public HouseDecorator(HouseBuilder builder) {
		super();
		this.builder = builder;
	}
	
	House constrtucHouse() {
		builder.buildWalls();
		builder.buildRoofs();
		builder.buildDoors();
		builder.buildWindows();
		return builder.getHouse();
	}	
}
public class BuilderDP_01_HouseBuild {
	
	public static void main(String[] args) {
		HouseBuilder builder=new ConcreateHouseBuilder();
		HouseDecorator decorator=new HouseDecorator(builder);
		House house=decorator.constrtucHouse();
		System.out.println(house);

	}

}
