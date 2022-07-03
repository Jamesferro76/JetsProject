package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterPlane;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerPlane;

public class JetsApplication {

	private AirField af = new AirField();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		JetsApplication ja = new JetsApplication();
		ja.run(sc);

	}

	private void run(Scanner sc) {
		af.constructingPlanes();
		menuChoice(sc);

	}

	private void menuChoice(Scanner sc) {
		boolean trigger = true;
		while (trigger) {
			menu();
			int userChoice = sc.nextInt();
			sc.nextLine();

			try {
				switch (userChoice) {

				case 1:
					fleet();
					break;
				case 2:
					flyJets();
					break;
				case 3:
					fastestJet();
					break;
				case 4:
					longestRange();
					break;
				case 5:
					loadCargo();
					break;
				case 6:
					dogFight();
					break;
				case 7:
					addJet(sc);
					break;
				case 8:
					remove(sc);
					break;
				case 9:
					System.out.println("Goodbye");
					trigger = false;
					break;
				default:
					System.out.println("That was not a readable response. Please choose a number betweeen 1-9");

				}
			} catch (Exception e) {
				System.out.println("That was not a readable response. Pleaseee type a number");
			}
		}
	}

	private void menu() {
		System.out.println();
		System.out.println("1. List");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
		System.out.println();
	}

	private void fleet() {
		// How do I get the jets in here
		List<Jet> jets = af.getFleet();
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	private void flyJets() {
		List<Jet> jets = af.getFleet();
		for (Jet jet : jets) {

			System.out.println(jet + " can fly for: " + jet.fly() + " hours until it needs more fuel.");
		}
	}

	private void fastestJet() {
		List<Jet> jets = af.getFleet();

		String fastestJet = "none";
		int fastestSpeed = 0;
		Jet fastestJetInfo = null;

		for (Jet jet : jets) {

			if (jet == null) {
				break;
			}
			if (fastestSpeed < jet.getSpeedMPH()) {
				fastestJet = jet.getModel();
				fastestSpeed = jet.getSpeedMPH();
				fastestJetInfo = jet;

			}

		}
		System.out.println("The fastest Jet was: " + fastestJet + " with a speed of: " + fastestSpeed + " MPH!");
		System.out.println(fastestJetInfo.toString());

	}

	private void longestRange() {
		List<Jet> jets = af.getFleet();

		String longestRangeJet = "none";
		long longestRange = 0;
		Jet longestRangeInfo = null;

		for (Jet jet : jets) {
			if (jet == null) {
				break;
			}
			if (longestRange < jet.getRange()) {
				longestRangeJet = jet.getModel();
				longestRange = jet.getRange();
				longestRangeInfo = jet;

			}
		}

		System.out.println(
				"The longest ranged Jet was: " + longestRangeJet + " with a range of: " + longestRange + " Miles");
		System.out.println(longestRangeInfo.toString());

	}

	public void loadCargo() {
		List<Jet> jets = af.getFleet();

		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				System.out.println(jet);
				((CargoPlane) jet).cargo();

			}
		}

	}

	public void dogFight() {
		List<Jet> jets = af.getFleet();

		for (Jet jet : jets) {
			if (jet instanceof FighterPlane) {
				System.out.println(jet);
				((FighterPlane) jet).fight();

			}
		}

	}

//		work on the functionality of this section so if the user mistypes they can continue.
	public void addJet(Scanner sc) {
		List<Jet> jets = af.getFleet();

		System.out.println("Is this a Passenger, Fighter, or Cargo plane?");
		String userChoice = sc.nextLine();

		System.out.println("What is the model of this plane?");
		String userModel = sc.nextLine();

		System.out.println("What is this plane's speed in MPH?");
		int userSpeedMPH = sc.nextInt();

		System.out.println("What is this plane's range?");
		long userRange = sc.nextLong();

		System.out.println("What is this planes price?");
		double userPrice = sc.nextDouble();

		switch (userChoice) {

		case "Passenger":
		case "passenger":
		case "1":
		case "P":
		case "p":
			PassengerPlane pp = new PassengerPlane(userModel, userSpeedMPH, userRange, userPrice);
			af.addJet(pp);
			System.out.println("Added: " + pp);
			break;
		case "Fighter":
		case "fighter":
		case "2":
		case "F":
		case "f":
			FighterPlane fp = new FighterPlane(userModel, userSpeedMPH, userRange, userPrice);
			af.addJet(fp);
			System.out.println("Added: " + fp);
			break;
		case "Cargo":
		case "cargo":
		case "3":
		case "C":
		case "c":
			CargoPlane cp = new CargoPlane(userModel, userSpeedMPH, userRange, userPrice);
			af.addJet(cp);
			System.out.println("Added: " + cp);

		default:
			System.out.println("I couldn't read what type you wanted.");
			break;

		}

	}

	public void remove(Scanner sc) {
		List<Jet> jets = af.getFleet();
		boolean trigger;
		int counter = 0;
		do {
			trigger = false;
			System.out.println("0. Cancel");
			for (Jet jet : jets) {
				counter++;
				System.out.println(counter + ". " + jet.getModel());
			}
			try {
				int userChoice = sc.nextInt();

				if (userChoice == 0) {
					System.out.println("Cancel removal protocol");
					break;

				} else if (userChoice <= jets.size()) {
					jets.remove((userChoice - 1));
					System.out.println("Jet removed.");
				} else {
					System.out.println("That was not a readable response. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("That was not a readable response. Please use a number shown.");
				trigger = true;
			}

		} while (trigger);
	}

}
