package com.hbarnard.app.controller;

import java.util.Scanner;
import com.hbarnard.app.model.Hero;
import com.hbarnard.app.views.Display;

public class GameController {
	
	public Hero hero;
	public Scanner scanner;

	public GameController (){
		this.scanner = new Scanner(System.in);
		this.hero = new Hero("Default");
	}

	public void gameEnd(){
		System.exit(1);
	}

	public void startGame(){
		Display.print("Welcome to swingy! Choose whether to load a hero or create a new hero");
		Display.startup();

		String command = "";
		while (!(command.equals("1") || command.equals("2"))){
			command = scanner.nextLine().trim();
			if (!(command.equals("1") || command.equals("2"))){
				Display.print("");
				Display.print("That is an invalid input! Your options are as follows:");
				Display.startup();
			}
		}
		if (command.equals("1")){
			String name = naming();
			this.hero = new Hero(name);
			this.hero.setJob(undeath());
		} else {
			this.hero = HeroController.loadHero("Hello");
		}
		Display.print("Progress");
	}

	private String naming(){
		Display.print("Enter Hero Name: ");
		String name = scanner.nextLine();
		return name;
	}

	private String undeath(){
		Display.undeathSelection();

		String undead = scanner.nextLine().trim();
		switch (undead){
			case "1":
				return "Graveknight";
			case "2":
				return "Vampire";
			case "3":
				return "Lich";
			case "4":
				return "Skeleton";
			default:
				Display.print("Invalid class selection");
				return undeath();
		}
	}
}
