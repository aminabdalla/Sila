package at.app.sila.things;


import java.io.Serializable;
import java.util.Random;

import at.app.sila.dbo.DBO;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public class Thing extends DBO implements Serializable{

    private String designator;

    public Thing(String designator){
        super(String.valueOf(new Random().nextDouble()));
        this.designator = designator;
    }

    public String getDesignator() {
        return designator;
    }

    public void setDesignator(String designator) {
        this.designator = designator;
    }

}
