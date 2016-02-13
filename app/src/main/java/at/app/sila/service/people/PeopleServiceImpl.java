package at.app.sila.service.people;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.app.sila.people.Person;
import at.app.sila.people.Relation;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public class PeopleServiceImpl implements PeopleService {

    final Map<String, Person> personMap;

    final static Relation[] CLOSE_FAMILY = {Relation.FATHER,Relation.BROTHER, Relation.CHILD, Relation.SON, Relation.SISTER, Relation.SIBLING, Relation.DAUGHTER, Relation.WIFE};

    final static Relation[] GREAT_FAMILY = {Relation.NEPHEW, Relation.NIECE, Relation.GRANDCHILD, Relation.GRANDDAUGHTER, Relation.GRANDSON};



    public PeopleServiceImpl() {
        personMap = new HashMap<String,Person>();
    }


    @Override
    public boolean addEntity(Person person) {
        personMap.put(person.getName(),person);
        return true;
    }

    @Override
    public boolean rmvEntity(Person person) {
        personMap.remove(person.getName());
        return true;
    }

    @Override
    public Person updateEntity(Person person) {
        Person oldPerson = personMap.get(person.getName());
        oldPerson = person;
        return oldPerson;
    }

    @Override
    public Person getEntity(String key) {
        return personMap.get(key);
    }

    @Override
    public List<Person> getAllEntities()
    {
        List<Person> pL = new ArrayList<Person>();
        pL.addAll(personMap.values());
        return pL;
    }


    @Override
    public List<Person> getCloseFamily() {
        List<Person> closeFamily = new ArrayList<Person>();
        for(Person p : this.personMap.values()) {
            if(isCloseFamily(p.getRelation())) {
                closeFamily.add(p);
            }
        }
        return closeFamily;
    }

    @Override
    public List<Person> getGreatFamily() {
        List<Person> greatFamily = new ArrayList<Person>();
        for(Person p : this.personMap.values()) {
            if(isCloseFamily(p.getRelation()) || isGreatFamily((p.getRelation()))) {
                greatFamily.add(p);
            }
        }
        return greatFamily;
    }

    @Override
    public List<Person> getFriends() {
        List<Person> nonFamily = new ArrayList<Person>();
        for(Person p : this.personMap.values()) {
            if(!isCloseFamily(p.getRelation()) && !isGreatFamily((p.getRelation()))) {
                nonFamily.add(p);
            }
        }
        return nonFamily;

    }


    private boolean isCloseFamily(Relation relation) {
        int i = 0;
        while(i < CLOSE_FAMILY.length) {
            if(CLOSE_FAMILY[i].equals(relation)){
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean isGreatFamily(Relation relation) {
        int i = 0;
        while(i < GREAT_FAMILY.length) {
            if(GREAT_FAMILY[i].equals(relation)){
                return true;
            }
            i++;
        }
        return false;
    }

}
