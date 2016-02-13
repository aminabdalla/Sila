package at.app.sila.service;

import java.util.List;

import at.app.sila.people.Person;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public interface CRUDService<Entity> {

    boolean addEntity(Entity entity);

    boolean rmvEntity(Entity entity);

    Entity updateEntity(Entity entity);

    Person getEntity(String key);

    List<Person> getAllEntities();
}
