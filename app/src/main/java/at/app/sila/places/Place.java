package at.app.sila.places;


import java.util.Random;

import at.app.sila.dbo.DBO;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public class Place extends DBO {

    String name;

    public Place(String name){
        super(String.valueOf(new Random().nextDouble()));
        this.name = name;
    }


}
