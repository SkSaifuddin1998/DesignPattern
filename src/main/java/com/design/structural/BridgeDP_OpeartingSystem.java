package com.design.structural;

interface OS {
	public void runApp(String app);
}

class MACOS implements OS {
	@Override
	public void runApp(String app) {
		System.out.println("Macos running application " + app);

	}
}

class Windows implements OS {
	@Override
	public void runApp(String app) {
		System.out.println("Windows running application " + app);

	}
}

interface Device {
	void openApp(String app);
}

class Desktop implements Device {

	private OS os;

	Desktop(OS os) {
		this.os = os;
	}

	@Override
	public void openApp(String app) {
		os.runApp(app);
	}
}

class Laptop implements Device {

	private OS os;
	
	public Laptop(OS os) {
		this.os=os;
	}

	@Override
	public void openApp(String app) {
		os.runApp(app);

	}
}

public class BridgeDP_OpeartingSystem {

	public static void main(String[] args) {
		OS macos=new MACOS();
		OS windows=new Windows();
		
		Device desktop=new Desktop(macos);
		desktop.openApp("photoshot");
		
		Device laptop=new Laptop(windows);
		laptop.openApp("Notepad");

	}

}
