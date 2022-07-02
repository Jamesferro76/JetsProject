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
import com.skilldistillery.jets.entities.PassangerPlane;

public class JetsApplication {
	
	private AirField af= new AirField();
	
	public static void main(String[] args) {
			
			Scanner sc= new Scanner(System.in);

			JetsApplication ja= new JetsApplication();
			ja.run(sc);
			
		}

		private void run(Scanner sc) {
			constructingPlanes();
			menuChoice(sc);
			
		}
		
		private void menuChoice(Scanner sc) {
			boolean trigger=true;
			while(trigger) {
			menu();
			int userChoice=sc.nextInt();
			sc.nextLine();
			
			try {
				System.out.println("You made it to the try!");
				switch(userChoice) {
				
				case 1:
					fleet();
					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					trigger=false;
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
			System.out.println("1. List");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a jet from Fleet");
			System.out.println("9. Quit");
		}
		
		private void fleet(){
			//How do I get the jets in here
			List<Jet> jets= af.getFleet();
			System.out.println("You made it to the method fleet!");
			for (Jet jet : jets) {
				System.out.println(jet);
			}
			}
			
		
//		private void flyJets() {
//			(int i=0; i<Jet[]; i++){
//			System.out.println(jet[i].toString + " "+ Jet.fly());
//			}
//		}
//		
//		
//		private void fastestJet() {
//			String fastestJet="none";
//			int fastestSpeed=0;
//			int counter=0;
//			
//			for(int i=0; i<jet[].size; i++) {
//				if(jet[i]==null) {
//					break;
//				}
//				if (fastestSpeed < jet[i].getspeedMPH()) {
//					 fastestJet= jet[i].getmodel();
//					fastestSpeed = jet[i].getSpeedMPH();
//					counter=i;
//				}
//				
//		}
//			System.out.println("The fastest Jet was: " + fastestJet + " with a speed of: " + fastestSpeed + " MPH!");
//			System.out.println(jet[c1ounter].toString());
//		
//
//		}
		
		private void constructingPlanes() {
			try ( BufferedReader bufIn = new BufferedReader(new FileReader("myJets.txt")) ) {
				  String line;
				  while ((line = bufIn.readLine()) != null) {
					  String[] lineArray= new String[5];
					  lineArray=line.split(",");
					  	parseJets(lineArray);	
				    
				  }
				}
				catch (IOException e) {
				  System.err.println(e);
				}
		}
		
		public void parseJets(String[] lineArray) {
			System.out.println("Made it to parseJets");
			
			//lineArray[0] is the category fighter/cargo/passanger
			String model=lineArray[1];
			int speedMPH= Integer.parseInt(lineArray[2]);
			long range= Long.parseLong(lineArray[3]);
			double price= Double.parseDouble(lineArray[4]);

			if(lineArray[0].equals("Cargo")) {
			//How do I get this to correctly add a jet into the jet class and into the arraylist
			 CargoPlane cp= new CargoPlane(model, speedMPH, range, price);
			 System.out.println(cp);
			} else if(lineArray[0].equals("Fighter")) {
				FighterPlane fp= new FighterPlane(model, speedMPH, range, price);
				System.out.println(fp);
		}else if(lineArray[0].equals("Passanger")) {
			PassangerPlane pp= new PassangerPlane(model, speedMPH, range, price);
			System.out.println(pp);
		}

}
}
