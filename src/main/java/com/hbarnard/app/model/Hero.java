package com.hbarnard.app.model;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Hero implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private int hp;
	@NotNull
	private int atk;
	@NotNull
	private int def;

	@NotNull(message = "Job cannot be null")
	private String job;

	@NotNull(message = "Name cannot be null")
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 letters long")
	private String name;

	@NotNull(message = "Level cannot be null")
	@Min(value = 1, message = "Level cannot be below 1")
	private int level;

	@NotNull
	@Min(value = 1000, message = "Experience cannot be below 1000")
	private int xp; 

	@NotNull (message = "Missing weapon on hero")
	private int weapon;

	@NotNull (message = "Missing armor on hero!")
	private int armor;

	@NotNull (message = "Missing helmet on hero!")
	private int helmet;

	private int x = 0;

	private int y = 0;

	private int map = 0;

	public Hero(@NotNull String name){
		this.name = name;
		this.level = 1;
		this.xp = 0;
		this.armor = 1;
		this.helmet = 1;
		this.weapon = 1;
	}

	public void setJob(@NotNull String job){
		this.job = job;
		if (job.equalsIgnoreCase("Graveknight")){
			this.hp = 12;
			this.atk = 5;
			this.def = 8;
		} else if (job.equalsIgnoreCase("Lich")){
			this.hp = 6;
			this.atk = 12;
			this.def = 7;
		} else if (job.equalsIgnoreCase("Vampire")){
			this.hp = 9;
			this.atk = 9;
			this.def = 7;
		} else {
			this.hp = 5;
			this.atk = 6;
			this.def = 5;
			this.job = "skeleton";
		}
	}

	public void addExperience(int xp){
		this.xp += xp;
		while(this.xp >= (this.level * 1000 + Math.pow((this.level - 1), 2) * 450)){
			this.levelUp();
		}
	}

	private void levelUp(){
		this.level++;
		this.atk++;
		this.def++;
		this.hp++;
	}

	public int getArmor(){
		return this.armor;
	}

	public int getHelmet(){
		return this.helmet;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public int getWeapon(){
		return this.weapon;
	}

	public int getAtk(){
		return (this.atk + this.weapon);
	}

	public int getDef(){
		return (this.def + this.armor);
	}

	public int getHealth(){
		return (this.hp + this.helmet);
	}

	public String getName(){
		return this.name;
	}

	public int getXp(){
		return this.xp;
	}

	public int getLevel(){
		return this.level;
	}

	public int getMap(){
		return this.map;
	}

	public void setXp(int xp){
		this.xp = xp;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setArmor(int armor){
		this.armor = armor;
	}

	public void setHelmet(int helmet){
		this.helmet = helmet;
	}
	public void setWeapon(int weapon){
		this.weapon = weapon;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	public void setMap(int map){
		this.map = map;
	}

	public String toString(){
		return ("Hero name: " + this.name +
				"\nHero job: " + this.job +
				"\nHero level: " + Integer.toString(this.level) + 
				"\nSize of map: " + Integer.toString(this.map) + 
				"\nHero attack: " + Integer.toString(this.atk) +
				"\nHero defence: " + Integer.toString(this.def) +
				"\nHero health: " + Integer.toString(this.hp) +
				"\nHero weapon: " + Integer.toString(this.weapon) +
				"\nHero armor: " + Integer.toString(this.armor) +
				"\nHero helmet: " + Integer.toString(this.helmet));
	}
}
