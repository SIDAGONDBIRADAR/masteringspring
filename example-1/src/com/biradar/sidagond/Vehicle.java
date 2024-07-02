package com.biradar.sidagond;

public class Vehicle {
	
	public void makeVehicle() {
		Speakers speakers = new BoseSpeaker();
		speakers.makeSound();
		
		
		Tyres tyres = new MichelinTyres();
		tyres.moveVehicle();
	}
	
	
	public void makeVehicle2() {
		
	}

}
