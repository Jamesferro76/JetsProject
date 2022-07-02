package com.skilldistillery.jets.entities;


public class FighterPlane extends Jet implements CombatReady {
	
	private int misCapacity;

	public FighterPlane(String model, int speedMPH, long range, double price) {
		super(model, speedMPH, range, price);
		System.out.println(combatReady);
		
	}

	private void fight() {
		System.out.println("Missiles ready");
		
	}

	public FighterPlane() {
	}

	public int getMisCapacity() {
		return misCapacity;
	}

	public void setMisCapacity(int misCapacity) {
		this.misCapacity = misCapacity;
	}

	
	

}
