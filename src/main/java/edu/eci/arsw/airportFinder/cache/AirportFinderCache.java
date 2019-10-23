package edu.eci.arsw.airportFinder.cache;

import java.util.ArrayList;

public class AirportFinderCache {
    static ArrayList<String> guardados = new ArrayList<>();

    public static void add(String data){
        guardados.add(data);
    }

    public void remove(){

    }
}
