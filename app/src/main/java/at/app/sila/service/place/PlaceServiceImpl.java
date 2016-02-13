package at.app.sila.service.place;

import at.app.sila.places.Place;
import at.app.sila.service.AbstractCrudService;

/**
 * Created by AAbdalla on 13.02.2016.
 */
public class PlaceServiceImpl extends AbstractCrudService<Place> implements PlaceService {

    private static PlaceServiceImpl placeService = new PlaceServiceImpl();

    public static PlaceService getPlaceService() {
        placeService.addEntity(new Place("Home"));
        placeService.addEntity(new Place("Work"));
        placeService.addEntity(new Place("Hofer"));
        placeService.addEntity(new Place("Hammerfestweg"));
        return placeService;}

    private PlaceServiceImpl(){
        super();
    }

}
