package de.oev;

import java.util.ArrayList;

/**
 * Created by magsumbol on 23.12.14.
 */
public class PrepSimFahrgeschaefte {

    private ArrayList<SimulationFahrgeschaeft> simsFahrgeschaefte;
    private ArrayList<Fahrgeschaeft>fg;

    public PrepSimFahrgeschaefte(ArrayList<Fahrgeschaeft> fg) {
        this.fg = fg;
        simsFahrgeschaefte = new ArrayList<SimulationFahrgeschaeft>();
    }

    public void createSims(){

        for(Fahrgeschaeft fahr: this.fg){
            SimulationFahrgeschaeft s = new SimulationFahrgeschaeft(fahr);
            simsFahrgeschaefte.add(s);
        }
    }

    public ArrayList<SimulationFahrgeschaeft> getSimsFahrgeschaefte() {
        return simsFahrgeschaefte;
    }
}