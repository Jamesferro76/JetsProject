package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
			
			Scanner sc= new Scanner(System.in);

			JetsApplication ja= new JetsApplication();
			ja.run(sc);
			
		}

		private void run(Scanner sc) {
			
			
			
			
			
		}
		
		private void menuChoice(Scanner sc) {
			menu();
			int userChoice=sc.nextInt();
			
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

	

}
