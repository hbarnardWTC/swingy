package com.hbarnard.app.views;

import com.hbarnard.app.model.Enemy;

public class Display {
	
	public Display(){}

	//Add colour to normal output
	public static void print(String s){
		System.out.println("\033[0;95m" + s + "\033[0m");
	}

	//Default startup text
	public static void startup(){
		Display.print("1:New Hero");
		Display.print("2:Load Hero");
		Display.print("Select the number of the option");
	}

	//Job selection text
	public static void undeathSelection(){
		Display.print("Undead Available:");
		Display.print("1: Graveknight");
		Display.print("2: Vampire");
		Display.print("3: Lich");
		Display.print("4: Skeleton(Hard mode)");
		Display.print("Select the number of the option.");
	}

	//Spacing
	public static void blankLine(){
		System.out.println("\033[0;93m" + "----------------------------------------\n" + "\033[0m");
	}

	//Annotation Failure
	public static void errorMessage(String s){
		System.out.println("\033[0;91m" + s + "\033[0m");
	}

	//Display location
	public static void showLocation(int x, int y){
		Display.print("You are at this location:\nX:" + Integer.toString(x) + "\nY:" + Integer.toString(y));
		Display.print("You may head in the following directions:");
		Display.print("1 : North");
		Display.print("2 : East");
		Display.print("3 : South");
		Display.print("4 : West");
		Display.print("5 : Exit");
		Display.print("Select the corresponding number of the option you wish to pick.");
	}

	public static void namingError(){
		Display.errorMessage("Name cannot be blank!");
		Display.blankLine();
		Display.print("Enter Hero Name: ");
	}

	public static void monsterEncounter(Enemy foe){
		Display.blankLine();
		Display.print("You have encountered a " + foe.getType() + "!");
		// Display.print("You have encountered a " + foe.getType() + "! Will you fight or run away?");
		// Display.print("F: Fight");
		// Display.print("R: Run");
	}

	public static void heroVictory(Enemy foe) {
		Display.blankLine();
		Display.print("You have defeated a " + foe.getType() + "!");
	}

	public static void loot(int level, String type){
		Display.print("You have found a " + type + "with a power level of " + Integer.toString(level));
		Display.print("Do you wish to equip this item?");
		Display.print("1: Equip");
		Display.print("2: Discard");
	}

	public static void loss(){
		Display.print("You have died! The game will now end. Your previous save will still remain though!");
	}
}
