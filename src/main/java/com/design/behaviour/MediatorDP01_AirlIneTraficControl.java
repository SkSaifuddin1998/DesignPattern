package com.design.behaviour;

// Mediator Interface
interface AirTrafficControlTower {
	void requestTakeoff(Airplane airplane);

	void requestLanding(Airplane airplane);
}

class AirportControlTower implements AirTrafficControlTower {
	@Override
	public void requestTakeoff(Airplane airplane) {
		// Logic for coordinating takeoff
		airplane.notifyAirTrafficControl("Requesting takeoff clearance.");
	}

	@Override
	public void requestLanding(Airplane airplane) {
		// Logic for coordinating landing
		airplane.notifyAirTrafficControl("Requesting landing clearance.");
	}
}

// Colleague Interface
interface Airplane {
	void requestTakeoff();

	void requestLanding();

	void notifyAirTrafficControl(String message);
}

class CommercialAirplane implements Airplane {
	private AirTrafficControlTower mediator;

	public CommercialAirplane(AirTrafficControlTower mediator) {
		this.mediator = mediator;
	}

	@Override
	public void requestTakeoff() {
		mediator.requestTakeoff(this);
	}

	@Override
	public void requestLanding() {
		mediator.requestLanding(this);
	}

	@Override
	public void notifyAirTrafficControl(String message) {
		System.out.println("Commercial Airplane: " + message);
	}
}

public class MediatorDP01_AirlIneTraficControl {

	public static void main(String[] args) {
				
		
		AirTrafficControlTower airTrafficControlTower=new AirportControlTower();		
		Airplane airplane1=new CommercialAirplane(airTrafficControlTower);
		airplane1.requestTakeoff();
		airplane1.requestLanding();
		
		

	}

}
