package de.oev;

import java.util.ArrayList;

/**
 * Created by magsumbol on 18.12.14.
 */
public class SimulationFahrgeschaeft {

    Fahrgeschaeft fahrgeschaeft;
    ArrayList<SimulationPerson> totalPersonen;

    public SimulationFahrgeschaeft(Fahrgeschaeft fg) {
        fahrgeschaeft = fg;
        totalPersonen = new ArrayList<SimulationPerson>(fahrgeschaeft.getMax_gaeste());
    }

    public Boolean fillFahrgeschaeft(SimulationPerson sim){
        if(totalPersonen.size() < fahrgeschaeft.getMax_gaeste()) {
            totalPersonen.add(sim);
            return true;
        }
        return false;
    }

    //Fahrgeschäft fährt eine Runde - Geld, Übelkeit und Spass werden angerechnet
    public void operate(){
        int count = 0;

        while(count<totalPersonen.size()){
            SimulationPerson rider = totalPersonen.get(count);
            rider.pay(fahrgeschaeft.getKosten());
            rider.enjoy(fahrgeschaeft.getSpass_level());
            rider.setSick(fahrgeschaeft.getUebelkeit_level());

            this.fahrgeschaeft.setEinnahmen(fahrgeschaeft.getKosten()+fahrgeschaeft.getEinnahmen());
            count++;
        }
    }

    public ArrayList<SimulationPerson> getTotalPersonen() {
        return totalPersonen;
    }

    public String getName(){
        return fahrgeschaeft.getId_name();
    }

    public int getPreis(){
        return  fahrgeschaeft.getKosten();
    }

    public int getUmsatz(){
        return fahrgeschaeft.getEinnahmen();
    }

    public void printGaeste(){
        for (SimulationPerson sp : totalPersonen){
            System.out.println(sp.getId());
        }
    }

    public void clearFahrgeschaeft(){
        totalPersonen.clear();
    }
}