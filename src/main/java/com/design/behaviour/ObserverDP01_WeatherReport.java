package com.design.behaviour;

import java.util.ArrayList;
import java.util.List;


//Claim status updates (Approved / Rejected / Pending)
//Email + SMS notification systems
//Event-driven microservices (Kafka, RabbitMQ)
//Observer Interface
interface Observer {
	void update(String weather);
}

class PhoneDisplay implements Observer {

	private String weather;
	@Override
	public void update(String weather) {
		this.weather = weather;
		display();
	}

	private void display() {
		System.out.println("Phone Display: Weather updated - " + weather);
	}
}

class TVDisplay implements Observer {

	private String weather;
	@Override
	public void update(String weather) {
		this.weather = weather;
		display();

	}

	private void display() {
		System.out.println("Tv Display: Weather updated - " + weather);
	}
}

//Subject Interface
interface Subject {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}

class WeatherStation implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private String message;

	public void setMessage(String message) {
		this.message = message;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(message);
		}
	}
}

public class ObserverDP01_WeatherReport {

	public static void main(String[] args) {
		WeatherStation weather=new WeatherStation();
		
     Observer ph=new PhoneDisplay();
     Observer tv=new TVDisplay();
     weather.addObserver(ph);
     weather.addObserver(tv);
     weather.setMessage("Sunny");
	}

}
