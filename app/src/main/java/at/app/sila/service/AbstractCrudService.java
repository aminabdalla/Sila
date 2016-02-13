package at.app.sila.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AAbdalla on 13.02.2016.
 */
public abstract class AbstractCrudService<TYPE> implements CRUDService<TYPE> {

    private List<TYPE> placeContainer = new ArrayList<>();

    @Override
    public boolean addEntity(TYPE entity) {
        return placeContainer.add(entity);
    }

    @Override
    public boolean rmvEntity(TYPE entity) {
        int i = placeContainer.indexOf(entity);
        placeContainer.remove(i);
        return true;
    }

    @Override
    public TYPE updateEntity(TYPE place) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TYPE getEntity(String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TYPE> getAllEntities() {
        return placeContainer;
    }
}
