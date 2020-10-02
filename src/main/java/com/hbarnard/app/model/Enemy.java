package com.hbarnard.app.model;

import javax.validation.constraints.NotNull;

public class Enemy {

	@NotNull
	private int hp;
	@NotNull
	private int atk;
	@NotNull
	private int def;
}
