package com.skilldistillery.jets.entities;


public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, int speedMPH, long range, double price) {
		super(model, speedMPH, range, price);
		
	}

	public void cargo() {
		System.out.println(cargoCarrier);
//		System.out.println("Load Cargo");
		
	}

	public CargoPlane() {
	}
	

	
	
	

}

