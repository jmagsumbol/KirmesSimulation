package de.oev;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by magsumbol on 23.12.14.
 */
public class RoundCreator {

    private ArrayList<SimulationPerson> simPersonen;
    private ArrayList<SimulationFahrgeschaeft>simFahrgeschaefte;

    private ArrayList<SimulationPerson> remainingRideGuests;
    private ArrayList<SimulationPerson> currentRideGuests;

    public RoundCreator(ArrayList<SimulationPerson> simPersonen, ArrayList<SimulationFahrgeschaeft> simFahrgeschaefte) {
        this.simPersonen = simPersonen;
        this.simFahrgeschaefte = simFahrgeschaefte;
    }

    public void createRound(){

        ArrayList<Person> remainingGuests = new ArrayList<Person>();
        ArrayList<Person> currentGuests = new ArrayList<Person>();



        /*
        for (int i=0;i<fahrgeschaefte.size();i++) {
            //hole Personen für Fahrgeschäft
            SimulationFahrgeschaeft simulationFahrgeschaeft = new SimulationFahrgeschaeft(this.fahrgeschaefte.get(i), this.personen);
            simFahrgeschaefte.add(simulationFahrgeschaeft);
            System.out.println(this.fahrgeschaefte.get(i).getId_name());
        }

        for (Person item : personen) System.out.println("Person:"+item.getId()+" Geld:"+item.getGeld()+" Spass:"+item.getSpass()+" Übelkeit:"+item.getUebelkeit());
        System.out.println("*************");

        */
    }


    private SimulationPerson getPersonForFahrgeschaeft(){

        // zufällig eine Person aus der Gesamtlist und wird direkt entfernt
        Random rndGenerator = new Random();
        int index = rndGenerator.nextInt(this.remainingRideGuests.size());
        SimulationPerson tmpSim = this.remainingRideGuests.get(index);

        this.remainingRideGuests.remove(index);

        return tmpSim;

    }


    private void distributeSims(ArrayList<SimulationPerson> sims){

        /*

        // hole Gast aus Liste

        Person currentRider = getPersonForFahrgeschaeft();

        // prüfe --> Fahrgeschäft, Geld, Übelkeit, Toilette

        int stat = currentRider.getStatus();
        switch (stat){
            case Person.NOMONEY:
                //gehe nach Hause - aus der Liste entfernen
                break;
            case Person.TOILET:
                //gehe zur Toilette
                break;
            case Person.PUKE:
                //gehe nach Hause
                break;
            default:
                break;

                //gehe zum Fahrgeschäft
        }

         */
    }
    /*
        Anzahl der restlichen Gäste, die noch nicht auf einem Fahrgeschäft sind
     */

    public ArrayList<SimulationPerson> getAllGuests() {
        return remainingRideGuests;
    }

    /*
        Anzahl der Gäste, die sich momentan auf einem Fahrschäft befinden werden
     */

    public ArrayList<SimulationPerson> getCurrentRideGuests() {
        return currentRideGuests;
    }
}
