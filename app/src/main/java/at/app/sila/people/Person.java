package at.app.sila.people;

import java.util.Random;
import java.util.Set;

import at.app.sila.dbo.DBO;
import at.app.sila.places.Place;
import at.app.sila.things.Thing;

;

/**
 * Created by AAbdalla on 03.01.2016.
 */
public class Person extends DBO {

    private Sex sex;

    private String name;

    private Relation relation;

    private Place home;

    private Set<Thing> needs;

    public Person(String name, Relation relation, Sex sex, Place home, Set<Thing> needs) {
        super(String.valueOf(new Random().nextDouble()));
        this.name = name;
        this.relation = relation;
        this.sex = sex;
        this.home = home;
        this.needs = needs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }


    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Place getHome() {
        return home;
    }

    public void setHome(Place home) {
        this.home = home;
    }

    public Set<Thing> getNeeds() {
        return needs;
    }

    public void setNeeds(Set<Thing> needs) {
        this.needs = needs;
    }


    @Override
    public String toString() {
        StringBuilder strBldr = new StringBuilder();

        strBldr.append("Name: "+this.getName())
                .append("\nRelation: "+this.getRelation())
                .append("\nNeeds:");

        for(Thing t : this.getNeeds()){
            strBldr.append(t.getDesignator());
        }
        return strBldr.toString();
    }
}
