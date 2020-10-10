package com.hbarnard.app.model;

import javax.validation.constraints.Min;

public class Artefact {

	@Min(value = 1)
	private int stat;
	private String type;

	//private static final String[] types = {"weapon","armor","helmet"};
	
	public Artefact(String type, int stat){
		this.stat=stat;
		this.type = type;
		// if(level < 1) {
		// 	level = 1;
		// }
		// int rand = (int)(Math.random() * 10) + 1;
		// if (rand <= 5){
		// 	this.stat = level;
		// } else if ( 5 < rand && rand <= 7) {
		// 	this.stat = (int)(level * 1.25);
		// } else if ( 7 < rand && rand <= 9) {
		// 	this.stat = (int)(level * 1.5);
		// } else {
		// 	this.stat = (int)(level * 2);
		// }
	}

	public int getStat(){
		return this.stat;
	}

	public String getType(){
		return this.type;
	}

	//For loading purposes mostly
	public void setStat(int stat){
		this.stat = stat;
	}
}
