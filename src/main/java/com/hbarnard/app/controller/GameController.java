package com.hbarnard.app.controller;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.hbarnard.app.model.Enemy;
import com.hbarnard.app.model.Hero;
import com.hbarnard.app.views.Display;

public class GameController {
	
	public Hero hero;
	public Scanner scanner;
	private int mapsize;

	public GameController (){
		this.scanner = new Scanner(System.in);
		this.hero = new Hero("Default");
	}

	//Game finished
	public void gameEnd(){
		this.hero.addExperience(1000);
		this.hero.setX(0);
		this.hero.setY(0);
		this.hero.setMap(0);
		Display.blankLine();
		Display.print("You finished the level!");
		Display.blankLine();
		try{
			HeroController.saveHero(this.hero);
		}catch(IOException e){
			Display.errorMessage("Your hero was not saved successfully");
		}
		System.exit(1);
	}

	//Losing to an enemy
	private void loss(){
		Display.loss();
		System.exit(1);
	}

	private void exitGame(){
		Display.blankLine();
		try {
			Display.print("See you again soon!");
			HeroController.saveHero(this.hero);
		} catch (IOException e){
			Display.errorMessage("Your hero was not saved successfully");
		}
		System.exit(1);
	}

	//Hero inititalisation
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
			Display.blankLine();
			this.naming();
			this.hero.setJob(this.undeath());
			try {
				HeroController.saveHero(this.hero);
			} catch (IOException e){
				Display.errorMessage("There was an error saving your hero");
			}
		} else {
			Display.blankLine();
			Display.print("What is the name of the hero you wish to load?");
			String heroName = scanner.nextLine();
			this.hero = HeroController.loadHero(heroName);
		}
	}

	//The following two parts are too reduce the size of 
	private void naming(){
		//validatorfactery function should be implemented again
        Display.print("Enter Hero Name: ");
		String name = scanner.nextLine();
		while (name.equals("")) {
			Display.namingError();
		}
		this.hero.setName(name);
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

	public void runGame(){
		this.createMap();
		Display.errorMessage("Mapsize:" + Integer.toString(this.mapsize));
		Display.errorMessage("Mapsize 2:" + Integer.toString(this.hero.getMap()));
		Display.errorMessage("X:" + Integer.toString(this.hero.getX()));
		Display.errorMessage("Y:" + Integer.toString(this.hero.getY()));
		if (this.hero.getX() <= 0  || this.hero.getY() <= 0) {
			Display.errorMessage("Mapsize:" + Integer.toString(this.mapsize));
			Display.errorMessage("Mapsize 2:" + Integer.toString(this.hero.getMap()));
			this.hero.setX(this.mapsize/2);
			this.hero.setY(this.mapsize/2);
			Display.errorMessage("X:" + Integer.toString(this.hero.getX()));
			Display.errorMessage("Y:" + Integer.toString(this.hero.getY()));
		}
		Display.print(this.hero.toString());

		while ((this.hero.getX() < this.mapsize && this.hero.getX() > 0) 
			&& (this.hero.getY() < this.mapsize && this.hero.getY() > 0)) {
			Display.showLocation(this.hero.getX(),this.hero.getY());
			String dir = scanner.nextLine().trim().toLowerCase();
			this.moveHero(dir);
			try {
				HeroController.saveHero(this.hero);
			} catch (IOException e) {
				Display.errorMessage("Your hero was not saved successfully");
			}
		}
		this.gameEnd();
	}

	private void createMap(){
		if (this.hero.getMap() == 0) {
			this.mapsize = (this.hero.getLevel()-1)*5 + 10-(this.hero.getLevel()%2);
			this.hero.setMap(this.mapsize);
		} else {
			this.mapsize = this.hero.getMap();
		}
	}

	//movehero
	private void moveHero(String dir){
		switch (dir) {
			case "1":
				this.hero.setY(this.hero.getY() + 1);
				break;
			case "2":
				this.hero.setX(this.hero.getX() - 1);
				break;
			case "3":
				this.hero.setX(this.hero.getX() + 1);
				break;
			case "4":
				this.hero.setY(this.hero.getY() - 1);
				break;
			case "5":
				this.exitGame();
				break;
			default:
				Display.errorMessage("You entered an invalid command");
				Display.blankLine();
				Display.showLocation(this.hero.getX(), this.hero.getY());
				String direction = scanner.nextLine().trim().toLowerCase();
				moveHero(direction);
				return;
		}
		this.event(dir);
	}

	//Generate event and handle call combat
	private void event(String dir){
		Random rand = new Random();
		int chance = rand.nextInt(100) + 1;
		int level = rand.nextInt(3) - 2 + this.hero.getLevel();
		int type = rand.nextInt(3) + 1;
		if (chance > 79){
			Enemy foe = new Enemy(level, type);
			Display.monsterEncounter(foe);
			if (this.combat(foe)) {
				Display.heroVictory(foe);
				this.loot(foe);
			} else {
				this.loss();
			}
		}
	}

	//Compare combat stats
	private boolean combat(Enemy foe){
		Random rand = new Random();
		int victory = this.hero.getAtk() + this.hero.getHealth() + this.hero.getDef() + rand.nextInt(6);
		int loss = foe.getAtk() + foe.getDef() + foe.getHp();
		if (victory >= loss) {
			return true;
		} else {
			return false;
		}
	}

	//Generate item and handle equipping
	private void loot(Enemy foe) {
		Random rand = new Random();
		int chance = rand.nextInt(100) + 1;
		String equip = "";
		if (chance > 40 && chance < 60) {
			Display.loot(foe.getLevel(), "Weapon");
			while (!(equip.equals("1") || equip.equals("2"))) {
				equip = scanner.nextLine().toLowerCase().trim();
				if (!(equip.equals("1") || equip.equals("2"))) {
					Display.print("");
					Display.print("That is an invalid input! Your options are as follows:");
					Display.loot(foe.getLevel(), "Weapon");
				}
			}
			if (equip.equals("1")) {
				this.hero.setWeapon(foe.getLevel());
				Display.print("The hero equipped a new weapon!");
			} else {
				Display.print("The weapon is discarded");
			}
		} else if (chance > 60 && chance < 80) {
			Display.loot(foe.getLevel(), "Armor");
			while (!(equip.equals("1") || equip.equals("2"))) {
				equip = scanner.nextLine().toLowerCase().trim();
				if (!(equip.equals("1") || equip.equals("2"))) {
					Display.print("");
					Display.print("That is an invalid input! Your options are as follows:");
					Display.loot(foe.getLevel(), "Armor");
				}
			}
			if (equip.equals("1")) {
				this.hero.setArmor(foe.getLevel());
				Display.print("The hero equipped a new Armor!");
			} else {
				Display.print("The armor is discarded");
			}
		} else if (chance > 80 && chance < 100) {
			Display.loot(foe.getLevel(), "Helmet");
			while (!(equip.equals("1") || equip.equals("2"))) {
				equip = scanner.nextLine().toLowerCase().trim();
				if (!(equip.equals("1") || equip.equals("2"))) {
					Display.print("");
					Display.print("That is an invalid input! Your options are as follows:");
					Display.loot(foe.getLevel(), "Helmet");
				}
			}
			if (equip.equals("1")) {
				this.hero.setHelmet(foe.getLevel());
				Display.print("The hero equipped a new Helmet!");
			} else {
				Display.print("The Helmet is discarded");
			}
		} else {
			Display.print("The enemy dropped no good items");
		}
	}

}
