package at.app.sila.things;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public enum Things {

    MILK("Milk"),
    INKPEN("InkPen");

    private Thing thing;

    private Things(String designator){
    this.thing = new Thing(designator);
    }

    public Thing thing(){return thing;}
}
