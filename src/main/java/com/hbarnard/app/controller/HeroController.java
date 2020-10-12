package com.hbarnard.app.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hbarnard.app.model.Hero;
import com.hbarnard.app.views.Display;

public class HeroController {

	//Save hero using serialisation
	public static void saveHero(Hero hero) throws IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(hero.getName() + ".ser"));
		objectOutputStream.writeObject(hero);
		objectOutputStream.close();
	}

	//Load hero using serialization
	public static Hero loadHero(String name){
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name + ".ser"));
			Hero hero = (Hero) objectInputStream.readObject();
            objectInputStream.close();
            return (hero);
		} catch (FileNotFoundException e) {
			Display.errorMessage("That hero does not exist. Try creating a hero with that name");
			System.exit(0);
		} catch (IOException e) {
			Display.errorMessage("There was an error reading in the name of your hero");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			Display.errorMessage("That hero is from an older build. Pls create a new one");
			System.exit(0);
		}
		return null;
	}
}
