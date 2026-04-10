package com.design.behaviour;

//Abstract class representing the character
abstract class Character {

	// Template method that defines the common sequence of actions
	public void takeTurn() {
		startTurn();
		performAction();
		endTurn();
	}

	protected abstract void startTurn();

	protected abstract void performAction();

	protected abstract void endTurn();
}

class Warrior extends Character {

	@Override
	protected void startTurn() {
		System.out.println("Warrior is preparing for the turn.");
	}

	@Override
	protected void performAction() {
		System.out.println("Warrior is attacking with a sword.");
	}

	@Override
	protected void endTurn() {
		System.out.println("Warrior is resting after the turn.");
	}
}

//Concrete subclass representing a mage character
class Mage extends Character {

	@Override
	protected void startTurn() {
		System.out.println("Mage is focusing energy for the turn.");
	}

	@Override
	protected void performAction() {
		System.out.println("Mage is casting a spell.");
	}

	@Override
	protected void endTurn() {
		System.out.println("Mage is recovering after the turn.");
	}
}

public class TemplateDP01_GameDevelopment {

	public static void main(String[] args) {
		System.out.println("===========Warrior Specifcation:==================  ");
		Character warrior=new Warrior();
		warrior.takeTurn();
		
		System.out.println("============Mage specification game================= :");
		Character mage=new Mage();
		mage.takeTurn();
	}

}
