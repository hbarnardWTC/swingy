package com.hbarnard.app.views;

public class Display {
	
	public Display(){}

	public static void print(String s){
		System.out.println("\033[0;95m" + s + "\033[0m");
	}

	public static void startup(){
		Display.print("1:New Hero");
		Display.print("2:Load Hero");
		Display.print("Select the number of the option");
	}

	public static void undeathSelection(){
		Display.print("Undead Available:");
		Display.print("1: Graveknight");
		Display.print("2: Vampire");
		Display.print("3: Lich");
		Display.print("4: Skeleton(Hard mode)");
		Display.print("Select the number of the option.");
	}

	public static void blankLine(){
		System.out.println("\033[0;91m" + "----------------------------------------" + "\033[0m");
	}
}
