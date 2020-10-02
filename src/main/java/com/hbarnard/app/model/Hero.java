package com.hbarnard.app.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Hero {

	@NotNull
	@Min(value = 0, message = "Maxhp cannot be 0 or less")
	private int maxhp;
	@NotNull
	private int currhp;
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
	private Artefact weapon;

	@NotNull (message = "Missing armor on hero!")
	private Artefact armor;

	@NotNull (message = "Missing helmet on hero!")
	private Artefact helmet;

	public Hero(@NotNull @NotEmpty String name, String job){
		this.name = name;
		this.job = job;
		this.level = 1;
		this.xp = 1000;

		if (job.equalsIgnoreCase("Graveknight")){
			this.currhp = 12;
			this.maxhp = 12;
			this.atk = 5;
			this.def = 8;
		} else if (job.equalsIgnoreCase("Lich")){
			this.currhp = 6;
			this.maxhp = 6;
			this.atk = 12;
			this.def = 7;
		} else if (job.equalsIgnoreCase("Vampire")){
			this.currhp = 9;
			this.maxhp = 9;
			this.atk = 9;
			this.def = 7;
		} else {
			this.currhp = 5;
			this.maxhp = 5;
			this.atk = 6;
			this.def = 5;
		}

		this.armor = new Artefact(1,"armor");
		this.helmet = new Artefact(1,"helmet");
		this.weapon = new Artefact(1,"weapon");
	}
}
