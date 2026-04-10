package com.design.behaviour;

interface Command {
	void execute();

}

class TurnOnCommand implements Command {
	private Device device;

	public TurnOnCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOn();

	}
}

class TurnOffCommand implements Command {
	private Device device;

	public TurnOffCommand(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOff();

	}
}

class AdjustVolumeCommand implements Command {
	private Stero stero;

	public AdjustVolumeCommand(Stero stero) {
		super();
		this.stero = stero;
	}

	@Override
	public void execute() {
		stero.adjustVolume();
	}
}

class ChangeChannelCommand implements Command {
	private TV tv;

	public ChangeChannelCommand(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.changeChannel();

	}
}

interface Device {
	void turnOn();

	void turnOff();
}

class TV implements Device {

	@Override
	public void turnOn() {
		System.out.println("TV Now on");

	}

	@Override
	public void turnOff() {
		System.out.println("TV now off");
	}

	public void changeChannel() {
		System.out.println("Change the Channel");
	}
}

class Stero implements Device {
	@Override
	public void turnOn() {
		System.out.println("Stero now is on");
	}

	@Override
	public void turnOff() {
		System.out.println("Stero now is off");
	}

	public void adjustVolume() {
		System.out.println("Adjust the volume");
	}

}

class RemoteController {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}

}

public class CommandDP01_RemoteControl {

	public static void main(String[] args) {
		TV tv=new TV();
		Stero stero=new Stero();
		
		RemoteController controller=new RemoteController();
		
		Command turnOnCommand=new TurnOnCommand(tv);
		Command turnOffCommand=new TurnOffCommand(tv);
		Command changedChanal=new ChangeChannelCommand(tv);
		
		Command onStero=new TurnOnCommand(stero);
		Command offStero=new TurnOffCommand(stero);
		Command adjustVolume=new AdjustVolumeCommand(stero);
		
		System.out.println("=============TV functionality work================");
		controller.setCommand(turnOnCommand);
		controller.pressButton();	
		controller.setCommand(turnOffCommand);
		controller.pressButton();
		controller.setCommand(changedChanal);
		controller.pressButton();
		
		System.out.println("=====================Stero Functionality=============== ");
		controller.setCommand(onStero);
		controller.pressButton();
		
		controller.setCommand(offStero);
		controller.pressButton();
		
		controller.setCommand(adjustVolume);
		controller.pressButton();
		
		
		
		
		
		
		

	}

}
