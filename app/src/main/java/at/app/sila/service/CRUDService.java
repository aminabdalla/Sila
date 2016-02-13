package at.app.sila.service;

import java.util.List;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public interface CRUDService<Entity> {

    boolean addEntity(Entity entity);

    boolean rmvEntity(Entity entity);

    Entity updateEntity(Entity entity);

    Entity getEntity(String key);

    List<Entity> getAllEntities();
}
