package at.app.sila.service.things;

import at.app.sila.service.AbstractCrudService;
import at.app.sila.things.Thing;

/**
 * Created by AAbdalla on 13.02.2016.
 */
public class ThingServiceImpl extends AbstractCrudService<Thing> implements ThingService {
    private static ThingServiceImpl thingServiceInstance = new ThingServiceImpl();

    public static ThingServiceImpl getInstance() {
        return thingServiceInstance;
    }


}
