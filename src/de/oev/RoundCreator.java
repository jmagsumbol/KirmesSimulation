package de.oev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by magsumbol on 23.12.14.
 */
public class RoundCreator {

    private static final int TOILET_LEVEL = 7;

    private ArrayList<SimulationPerson> simPersonen;
    private ArrayList<SimulationFahrgeschaeft>simFahrgeschaefte;

    private ArrayList<SimulationPerson> remainingRideGuests;
    private ArrayList<SimulationPerson> currentRideGuests;
    private ArrayList<SimulationPerson> exitGuests;


    public RoundCreator(ArrayList<SimulationPerson> simPersonen, ArrayList<SimulationFahrgeschaeft> simFahrgeschaefte) {
        this.simPersonen = simPersonen;
        this.simFahrgeschaefte = simFahrgeschaefte;

        remainingRideGuests = new ArrayList<SimulationPerson>(simPersonen);
        currentRideGuests = new ArrayList<SimulationPerson>();
        exitGuests = new ArrayList<SimulationPerson>();
    }

    public void createRound(){

       //gehe durch remainingGuests und prüfe wohin sie gehen können
        int total = remainingRideGuests.size();

        for(int i=0; i<total;i++) {


            // hole eine Person aus der Liste
            SimulationPerson tmpSim = getSimFromAll();

            // erhöhe pro Runde Übelkeitslevel um 1
            tmpSim.setSick(1);
            //prüfe ob er Sim auf Toilette muss
            checkToilet(tmpSim);

            //prüfe ob er noch Geld hat oder Übelkeit zu hoch
            Boolean _check = checkSim(tmpSim);

            if(_check == true)
                currentRideGuests.add(tmpSim);
            else {
                remainingRideGuests.remove(tmpSim);
                continue;
            }

            // per Zufall ein Fahrgeschäft anzeigen
            SimulationFahrgeschaeft tmpSimFahrgeschaeft = getSimFahrgeschaeft();

            // prüfe ob Fahrgeschaft noch frei ist
            if (tmpSimFahrgeschaeft != null)
                    tmpSimFahrgeschaeft.fillFahrgeschaeft(tmpSim);
            else {
                continue;
            }
        }
    }

    /*
        starte die Runde
     */

    public void startRound(){
        for (SimulationFahrgeschaeft s: simFahrgeschaefte){
            s.operate();
        }
    }

    /*
        beende die Runde
     */

    public void endRound(){
        // Listen sauber machen
        // Listen abgleichen und kopieren
        remainingRideGuests.addAll(currentRideGuests);
    }

    /*
        entferne die Gäste von Fahrgeschäft
     */

    public void clearRound(){
        for(SimulationFahrgeschaeft fg : simFahrgeschaefte){
            fg.clearFahrgeschaeft();
        }
    }

    /*
        prüfe, ob Gast bezahlen kann
     */

    private Boolean checkLiquidity(SimulationPerson sim, SimulationFahrgeschaeft simFg){

        int balance = sim.getGeld()-simFg.getPreis();

        if(balance <= 0){
            return false;
        }

        return true;
    }

    private void checkToilet(SimulationPerson s){
        if(s.getUebelkeit() >= SimulationPerson.TOILET_LIMIT){
            for(SimulationFahrgeschaeft t : this.simFahrgeschaefte){
                if(t.getName().startsWith("Toilette")){
                    if(t.getTotalPersonen().size() <= t.fahrgeschaeft.getMax_gaeste())
                        t.fillFahrgeschaeft(s);
                }
            }
        }
    }

    /*
        prüfe ob Person kein Geld mehr hat, oder kotzen muss
     */

    private Boolean checkSim(SimulationPerson s){
        if(s.getGeld() <= 0){
            s.setSimStatus(Person.NOMONEY);
            exitGuests.add(s);
            System.out.println("Person: "+s.getId()+" Nomoney");

            return false;
        }
        else if(s.getUebelkeit() > SimulationPerson.MAX_PUKE_LEVEL){
            s.setSimStatus(Person.PUKE);
            exitGuests.add(s);
            System.out.println("Person: " + s.getId() + " Puke");
            return false;
        }
        /*
        else if(s.getUebelkeit() > SimulationPerson.TOILET_LIMIT){
            // schicke auf Toilette
            return false;
        }
        */

        return true;
    }



    /*
        zufällig eine Person aus der Gesamtlist wird ausgewählt und direkt entfernt
     */

    private SimulationPerson getSimFromAll(){

        Random rndGenerator = new Random();
        int index = rndGenerator.nextInt(this.remainingRideGuests.size());
        SimulationPerson tmpSim = this.remainingRideGuests.get(index);

        this.remainingRideGuests.remove(index);

        return tmpSim;
    }

    /*
        zufällig ein Fahrgeschäft aussuchen, welches noch frei ist
     */

    private SimulationFahrgeschaeft getSimFahrgeschaeft(){

        long seed = System.nanoTime();
        Collections.shuffle(this.simFahrgeschaefte, new Random(seed));

        for(SimulationFahrgeschaeft s: this.simFahrgeschaefte) {
            if(s.getTotalPersonen().size() < s.fahrgeschaeft.getMax_gaeste())
                return s;
        }

        return null;
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

    public ArrayList<SimulationPerson> getExitGuests() {
        return exitGuests;
    }
}
