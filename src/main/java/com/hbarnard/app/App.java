package com.hbarnard.app;
import  com.hbarnard.app.model.Artefact;

public class App 
{
    public static void main( String[] args )
    {
        for(int i = 0; i < 100; i++){
          new Artefact(1,"weapon");
        }
    }
}
