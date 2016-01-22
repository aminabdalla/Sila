package at.app.sila.places;

/**
 * Created by AAbdalla on 07.01.2016.
 */
public enum Places {

    HOME("Home"),
    SALMAS("Salma's place");


    private final Place place;

    Places(String designator) {
        this.place = new Place(designator);
    }
    public Place place() { return place; }
}
