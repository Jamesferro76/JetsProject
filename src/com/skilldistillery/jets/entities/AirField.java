package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AirField extends Jet{
	private List<Jet> fleet= new ArrayList<>();

	public AirField(List<Jet> fleet) {
		super();
		this.fleet = fleet;
	}
	
	public void addJet(Jet plane) {
		this.fleet.add(plane);
	}

	public AirField() {
		super();
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
	
	
	

}
