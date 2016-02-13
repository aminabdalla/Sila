package at.app.sila.service.people;

import java.util.List;

import at.app.sila.people.Person;
import at.app.sila.service.CRUDService;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public interface PeopleService extends CRUDService<Person> {

    List<Person> getCloseFamily();

    List<Person> getGreatFamily();

    List<Person> getFriends();



}
