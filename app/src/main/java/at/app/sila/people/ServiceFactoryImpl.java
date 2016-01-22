package at.app.sila.people;


import java.util.HashSet;
import java.util.Set;

import at.app.sila.places.Places;
import at.app.sila.things.Thing;
import at.app.sila.things.Things;

/**
 * Created by AAbdalla on 04.01.2016.
 */
public class ServiceFactoryImpl implements ServiceFactory<PeopleService>{

    PeopleService peopleService;

    public PeopleService getPeopleService(){
            peopleService = new PeopleServiceImpl();
            Set<Thing> saraNeeds = new HashSet<Thing>();
            saraNeeds.add(Things.MILK.thing());
            Set<Thing> yumnaNeeds = new HashSet<Thing>();
            yumnaNeeds.add(Things.INKPEN.thing());
            peopleService.addEntity(new Person("Sarah", Relation.WIFE,Sex.FEMALE, Places.HOME.place(),saraNeeds ));
            peopleService.addEntity(new Person("Yumna", Relation.DAUGHTER,Sex.FEMALE, Places.HOME.place(), yumnaNeeds));
            peopleService.addEntity(new Person("Habiba", Relation.DAUGHTER,Sex.FEMALE, Places.HOME.place(), new HashSet<Thing>()));
            peopleService.addEntity(new Person("Salma", Relation.SISTER,Sex.FEMALE, Places.SALMAS.place(), new HashSet<Thing>()));
        return peopleService;
    }


    @Override
    public PeopleService createService() {
        if(peopleService == null) {
            this.getPeopleService();
        }
        return peopleService;
    }
}
