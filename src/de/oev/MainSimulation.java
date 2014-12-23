


package de.oev;

import java.util.ArrayList;

/**
 * Created by magsumbol on 19.12.14.
 */

/*
    TODO
    1. aus Personen bestimmte Anzahl von Personen zufällig für Fahrgeschäft auswählen - bis alle auf einem Fahrgeschäft sind
    2. Fahrgeschäft füllen - abhängig von Limit
    3. Exit Option für Personen, die kein Geld oder Übelkeitlevel > 10
    4. Abbruchbedingung Personenanzahl = 0
    5. Output: wieviel Geld wurde eingenommen, wieviele Leute haben Übelkeitslevel > 10, Anzahl des Gelds dieser Leute
 */

public class MainSimulation {

    private ArrayList<Fahrgeschaeft>fahrgeschaefte;
    private ArrayList<Person>personen;

    private ArrayList<SimulationFahrgeschaeft>simFahrgeschaefte;
    private ArrayList<SimulationPerson>simPersonen;



    private RoundCreator roundCreator;


    public MainSimulation(ArrayList<Fahrgeschaeft> fahrgeschaefte, ArrayList<Person> personen) {
        this.fahrgeschaefte = fahrgeschaefte;
        this.personen = personen;
        simFahrgeschaefte = new ArrayList<SimulationFahrgeschaeft>();
        simPersonen = new ArrayList<SimulationPerson>();
    }

    public void startSimulation(){


        simPersonen = prepSimulationPersonen();
        simFahrgeschaefte = prepSimulationFahrgeschaefte();

        roundCreator = new RoundCreator(simPersonen, simFahrgeschaefte);

    }

    private ArrayList<SimulationPerson> prepSimulationPersonen(){

        // erstelle aus Personen Objekte aus SimulationPersonen
        PrepSimPersonen prepPerson = new PrepSimPersonen(this.personen);
        prepPerson.createSims();
        return prepPerson.getSims();
    }



    private void runSimulationPersonen(){

    }

    private ArrayList<SimulationFahrgeschaeft> prepSimulationFahrgeschaefte(){

        //erstelle aus Fahrgeschäfte Objekte von SimulationFahrgeschäfte
        PrepSimFahrgeschaefte prepPerson = new PrepSimFahrgeschaefte(this.fahrgeschaefte);
        prepPerson.createSims();
        return prepPerson.getSimsFahrgeschaefte();

    }

    private void runSimulationFahrgeschaefte(){
        for(int i=0;i<simFahrgeschaefte.size();i++) {
            simFahrgeschaefte.get(i).operate();
        }

    }
}
