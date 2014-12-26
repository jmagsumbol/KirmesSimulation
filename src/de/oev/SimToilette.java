package de.oev;

/**
 * Created by magsumbol on 26.12.14.
 */
public class SimToilette extends SimulationFahrgeschaeft {

    public SimToilette(Fahrgeschaeft fg) {
        super(fg);
    }

    @Override
    public void operate() {
        super.operate();

        int count = 0;

        while(count<totalPersonen.size()){
            SimulationPerson rider = totalPersonen.get(count);
            double _level = rider.getUebelkeit();
            rider.setSick(-_level+_level*0.5);
            count++;
        }
    }
}
