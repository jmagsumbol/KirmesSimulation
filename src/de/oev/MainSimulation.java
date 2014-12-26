package de.oev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * Created by magsumbol on 19.12.14.
 */

public class MainSimulation {

    private ArrayList<Fahrgeschaeft>fahrgeschaefte;
    private ArrayList<Person>personen;

    private ArrayList<SimulationFahrgeschaeft>simFahrgeschaefte;
    private ArrayList<SimulationPerson>simPersonen;
    private ArrayList<SimulationPerson>exitPersonen;

    private RoundCreator roundCreator;


    public MainSimulation(ArrayList<Fahrgeschaeft> fahrgeschaefte, ArrayList<Person> personen) {
        this.fahrgeschaefte = fahrgeschaefte;
        this.personen = personen;
        simFahrgeschaefte = new ArrayList<SimulationFahrgeschaeft>();
        simPersonen = new ArrayList<SimulationPerson>();
        exitPersonen = new ArrayList<SimulationPerson>();
    }

    public void prepSimulation(){
        simPersonen = prepSimulationPersonen();
        simFahrgeschaefte = prepSimulationFahrgeschaefte();
    }

    public void startSimulation(){

        System.out.println("******** START SIMULATION *****");
        int round = 1;
        while(simPersonen.size()>0) {
            System.out.println("************RUNDE "+ round +"************");

            roundCreator = new RoundCreator(simPersonen, simFahrgeschaefte);
            roundCreator.createRound();
            roundCreator.startRound();
            roundCreator.endRound();
            roundCreator.clearRound();

            simPersonen = roundCreator.getAllGuests();

            // Personen output
            System.out.println("Gäste auf der Kirmes:");

            //sortiere Personen
            List<SimulationPerson> list = simPersonen;
            Collections.sort(list, new Comparator<SimulationPerson>() {
                @Override public int compare(SimulationPerson p1, SimulationPerson p2) {
                    return p1.getId() - p2.getId(); // Ascending
                }

            });            for (SimulationPerson item : list) {
                System.out.println("Person:" + item.getId() + " Geld:" + item.getGeld() + " Spass:" + item.getSpass() + " Übelkeit:" + item.getUebelkeit());
            }

            System.out.println("*********RUNDE ENDE *********");
            exitPersonen.addAll(roundCreator.getExitGuests());

            round++;
        }
        System.out.println("******** END SIMULATION *****");
        System.out.println("*****************************");
        System.out.println("******** ERGEBNIS ***********");
        System.out.println("Anzahl Gäste: "+exitPersonen.size());
        System.out.println("Anzahl gekotzte Gäste: "+getPukeSims(exitPersonen));
        System.out.println("Anzahl bankrotter Gäste: "+getNoMoneySims(exitPersonen));
        System.out.println("Tageseinnahmen: "+getTagesEinnahmen());
        System.out.println("mögliche zusätzliche Einnahmen: " + getPukeMoney(exitPersonen));

    }

    private int getPukeSims(ArrayList<SimulationPerson> simList){
         int count = 0;

        for(SimulationPerson s : simList){

            if(s.getSimStatus() == Person.PUKE){
                count++;
            }
        }

        return count;
    }

    private int getNoMoneySims(ArrayList<SimulationPerson> simList){
        int count = 0;

        for(SimulationPerson s : simList){

            if(s.getSimStatus() == Person.NOMONEY){
                count++;
            }
        }

        return count;
    }

    private int getTagesEinnahmen(){

        int geld = 0;
        for(SimulationFahrgeschaeft fg : simFahrgeschaefte){
            System.out.println(fg.getName()+" - "+fg.getUmsatz());
            geld += fg.getUmsatz();
        }
        return geld;
    }

    private int getPukeMoney(ArrayList<SimulationPerson> simList){
        int geld = 0;

        for(SimulationPerson s : simList){

            if(s.getSimStatus() == Person.PUKE){
                geld += s.getGeld();
            }
        }

        return geld;
    }

    private ArrayList<SimulationPerson> prepSimulationPersonen(){

        // erstelle aus Personen Objekte aus SimulationPersonen
        PrepSimPersonen prepPerson = new PrepSimPersonen(this.personen);
        prepPerson.createSims();
        return prepPerson.getSims();
    }

    private ArrayList<SimulationFahrgeschaeft> prepSimulationFahrgeschaefte(){

        //erstelle aus Fahrgeschäfte Objekte von SimulationFahrgeschäfte
        PrepSimFahrgeschaefte prepPerson = new PrepSimFahrgeschaefte(this.fahrgeschaefte);
        prepPerson.createSimFahrgeschaefte();
        return prepPerson.getSimsFahrgeschaefte();

    }

}
