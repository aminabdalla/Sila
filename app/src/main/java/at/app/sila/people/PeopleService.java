package at.app.sila.people;

import java.util.List;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public interface PeopleService extends CRUDService<Person> {

    List<Person> getCloseFamily();

    List<Person> getGreatFamily();

    List<Person> getFriends();



}
