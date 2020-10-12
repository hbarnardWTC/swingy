package com.hbarnard.app.model;

public class Enemy {

	private int hp;
	private int atk;
	private int def;
	private int level;

	private String type;

	public Enemy(int level, int type){
		this.level = level;
		switch (type){
			case 1 :
				this.hp = 5 + level;
				this.def = 5 + level;
				this.atk = 3 + level;
				this.type = "Paladin";
				break;
			case 2 :
				this.hp = 6 + level;
				this.def = 3 + level;
				this.atk = 2 + level;
				this.type = "Cleric";
			case 3 :
				this.hp = 4 + level;
				this.def = 2 + level;
				this.atk = 5 + level;
				this.type = "Oracle";
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
