package de.oev;

import java.util.ArrayList;

/**
 * Created by magsumbol on 23.12.14.
 */
public class PrepSimPersonen {

    private ArrayList<SimulationPerson>sims;
    private ArrayList<Person>personen;

    public PrepSimPersonen(ArrayList<Person> personen) {
        this.personen = personen;
        sims = new ArrayList<SimulationPerson>();
    }

    public void createSims(){

        for(Person pers: this.personen){
            SimulationPerson s = new SimulationPerson(pers);
            sims.add(s);
        }
    }

    public ArrayList<SimulationPerson> getSims() {
        return sims;
    }


}
