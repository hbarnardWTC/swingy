package com.hbarnard.app;

import com.hbarnard.app.controller.GameController;

public class App 
{
    public static void main(String[] args)
    {
      if (args.length < 1 || !args[0].toLowerCase().equals("console") ){
        System.out.println("Please input a version of either console or gui(GUI not currently supported)");
        System.exit(0);
      }

      if(args[0].toLowerCase().equals("console")){
        GameController game = new GameController();
        game.startGame();
      }
    }
}
