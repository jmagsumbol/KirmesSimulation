package de.oev;

/**
 * Created by magsumbol on 22.12.14.
 */
public class SimulationPerson {

    public static final int MAX_PUKE_LEVEL = 10;
    public static final int TOILET_LIMIT = 7;

    Person person;

    public SimulationPerson(Person person) {
        this.person = person;
    }


    public void pay(int cost){
        int currentMoney = this.person.getGeld();
        this.person.setGeld(currentMoney-cost);
    }

    public void enjoy(int fun){
        this.person.setSpass(this.person.getSpass()+fun);
    }

    public void setSick(double sicklevel){
        this.person.setUebelkeit(Math.floor(this.person.getUebelkeit()+sicklevel));
    }

    public int getId() {
        return this.person.getId();
    }

    public double getUebelkeit() {
        return this.person.getUebelkeit();
    }


    public int getSpass() {
        return this.person.getSpass();
    }


    public int getGeld() {
        return this.person.getGeld();
    }

    public int getSimStatus() {
        return this.person.getStatus();
    }

    public void setSimStatus(int simStatus) {
        this.person.setStatus(simStatus);
    }
}
