package de.oev;

import java.util.ArrayList;

/**
 * Created by magsumbol on 18.12.14.
 */
public class SimulationFahrgeschaeft {

    Fahrgeschaeft typ;
    ArrayList<Person> totalPersonen;

    public SimulationFahrgeschaeft(Fahrgeschaeft typ) {
        this.typ = typ;
    }

    //Fahrgeschäft fährt eine Runde - Geld, Übelkeit und Spass werden angerechnet
    public void operate(){
        int count = 0;
        while(count<this.totalPersonen.size()){
            Person rider = totalPersonen.get(count);
            rider.setGeld(rider.getGeld()-typ.getKosten());
            rider.setSpass(rider.getSpass() + typ.getSpass_level());
            rider.setUebelkeit(rider.getUebelkeit()+typ.getUebelkeit_level());
            this.typ.setEinnahmen(typ.getKosten());
            count++;
        }
    }

}