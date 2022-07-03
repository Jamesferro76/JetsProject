package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField extends Jet {
	private List<Jet> fleet = new ArrayList<>();

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

	public void constructingPlanes() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("myJets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] lineArray = new String[5];
				lineArray = line.split(",");
				parseJets(lineArray);

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void parseJets(String[] lineArray) {

		// lineArray[0] is the category fighter/cargo/passanger
		String model = lineArray[1];
		int speedMPH = Integer.parseInt(lineArray[2]);
		long range = Long.parseLong(lineArray[3]);
		double price = Double.parseDouble(lineArray[4]);

		if (lineArray[0].equals("Cargo")) {
			// How do I get this to correctly add a jet into the jet class and into the
			// arraylist
			CargoPlane cp = new CargoPlane(model, speedMPH, range, price);
			fleet.add(cp);
		} else if (lineArray[0].equals("Fighter")) {
			FighterPlane fp = new FighterPlane(model, speedMPH, range, price);
			fleet.add(fp);
		} else if (lineArray[0].equals("Passenger")) {
			PassengerPlane pp = new PassengerPlane(model, speedMPH, range, price);
			fleet.add(pp);
		}

	}

}
