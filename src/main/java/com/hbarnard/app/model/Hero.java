package com.hbarnard.app.model;


import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Hero implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	private int hp;
	@NotNull
	private int atk;
	@NotNull
	private int def;

	@NotNull(message = "Job cannot be null")
	@NotEmpty(message = "Job cannot be empty")
	private String job;

	@NotNull(message = "Name cannot be null")
	@Length(min = 3, max = 15, message = "Name must be between 3 and 15 letters long")
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

	public Hero(@NotNull @NotEmpty String name, String job){
		this.name = name;
		this.job = job;
		this.level = 1;
		this.xp = 1000;

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
		}

		this.armor = 1;
		this.helmet = 1;
		this.weapon = 1;
	}

	public void addExperience(int xp){
		this.xp += xp;
	}

	public int getArmor(){
		return this.armor;
	}

	public int getHelmet(){
		return this.helmet;
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
		return this.getName();
	}

	public int getXp(){
		return this.xp;
	}

	public int getLevel(){
		return this.level;
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
}
