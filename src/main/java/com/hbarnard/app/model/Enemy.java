package com.hbarnard.app.model;

public class Enemy {

	private int hp;
	private int atk;
	private int def;
	private int level;

	private String type;

	public Enemy(int level, String type){
		this.level = level;
		this.type = type;
		switch (type.toLowerCase()){
			case "paladin" :
				this.hp = 5 + level;
				this.def = 5 + level;
				this.atk = 3 + level;
				break;
			case "cleric" :
				this.hp = 6 + level;
				this.def = 3 + level;
				this.atk = 2 + level;
				break;
			case "oracle" :
				this.hp = 4 + level;
				this.def = 2 + level;
				this.atk = 5 + level;
				break;
			default:
				this.type = "Peasant";
				this.hp = 2 + level;
				this.def = 2 + level;
				this.atk = 2;
		}
	}

	public int getAtk() {
		return this.atk;
	}

	public int getDef() {
		return this.def;
	}

	public int getHp() {
		return this.hp;
	}

	public int getLevel(){
		return this.level;
	}

	public String getType(){
		return this.type;
	}
}
