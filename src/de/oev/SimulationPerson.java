package de.oev;

/**
 * Created by magsumbol on 22.12.14.
 */
public class SimulationPerson {

    private static final int PUKE_LEVEL = 10;

    Person person;

    public SimulationPerson(Person person) {
        this.person = person;
    }

    public void operate(){

    }



    public void gotoToilet(){
        //auf Toilette gehen
    }

    public void exitKirmes(){
        //verlasse die Kirmes
    }

    public void puke(){
        //Übelkeitslevel erreicht
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
