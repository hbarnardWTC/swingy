package com.hbarnard.app.model;

import java.util.Random;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Artefact {

	@Min(value = 1)
	private int stat;

	@NotNull
	@NotEmpty
	private String type;

	@NotNull
	private String quality;

	private static final String[] qualities = {"COMMON", "RARE", "LEGENDARY", "MYTHIC"};
	//private static final String[] types = {"weapon","armor","helmet"};
	
	public Artefact(int level, String type){
		if(level < 1) {
			level = 1;
		}
		int rand = (int)(Math.random() * 10) + 1;
		if (rand <= 5){
			this.stat = level;
			quality = qualities[0];
		} else if ( 5 < rand && rand <= 7) {
			this.stat = (int)(level * 1.25);
			quality = qualities[1];
		} else if ( 7 < rand && rand <= 9) {
			this.stat = (int)(level * 1.5);
			quality = qualities[2];
		} else {
			this.stat = (int)(level * 2);
			quality = qualities[3];
		}
		this.type = type;
	}

	public int getStat(){
		return this.stat;
	}

	public String getType(){
		return this.type;
	}
}
