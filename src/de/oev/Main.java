package de.oev;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.io.IOException;
import java.util.Enumeration;

public class Main {

    static Properties properties;
    static MainSimulation mainSimulation;

    private final static String CONFIG_PATH_FAHRGESCHAEFT =  "/Users/magsumbol/Development/Java/workspace/KirmesSimulation/out/production/KirmesSimulation/de/oev/resources/fahrgeschaeftConfig.properties";

    public static void main(String[] args) {

        System.out.println("******** MAIN START *****");

        getPropertyFile();
        ArrayList<Fahrgeschaeft>fahrgeschaefte = createFahrgeschaefte();
        ArrayList<Person>personen = createPersonen(Integer.parseInt(args[0]));

        mainSimulation = new MainSimulation(fahrgeschaefte, personen);
        mainSimulation.prepSimulation();
        mainSimulation.startSimulation();


    }

    /*
        Textdatei mit Fahrgeschäften wird ausgelesen
     */

    private static void getPropertyFile(){
        BufferedInputStream stream;

         properties = new Properties();
        try {
            stream = new BufferedInputStream(new FileInputStream(CONFIG_PATH_FAHRGESCHAEFT));
            properties.load(stream);
            stream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    /*
        Fahrgeschäfte werden generiert und in eine ArrayList gelegt
     */

    private static ArrayList<Fahrgeschaeft> createFahrgeschaefte(){
        ArrayList<Fahrgeschaeft>tmpFahrgeschaefte = new ArrayList<Fahrgeschaeft>();

        Enumeration e = properties.propertyNames();

        while (e.hasMoreElements())
        {
            //get keys / names from property file
            String key = (String) e.nextElement();

            String[] keyArray = properties.getProperty(key).split(",");

            int _uebelkeit = Integer.parseInt(keyArray[0]);
            int _kosten = Integer.parseInt(keyArray[1]);
            int _gaeste = Integer.parseInt(keyArray[2]);
            int _spass = Integer.parseInt(keyArray[3]);


            Fahrgeschaeft tmp = new Fahrgeschaeft(key, _uebelkeit, _kosten, _gaeste, _spass);
            tmpFahrgeschaefte.add(tmp);

        }

        // Fahrgeschäft output
        for (Fahrgeschaeft item : tmpFahrgeschaefte) {
            System.out.println("Fahrgeschäft:"+item.getId_name()+" Kosten:"+item.getKosten());
        }

        return tmpFahrgeschaefte;
    }

    /*
        Personen werden generiert und in eine ArrayList gelegt
     */
    private static ArrayList<Person> createPersonen(int totalPersonen){

        ArrayList<Person>tmpPersonen = new ArrayList<Person>();
        for(int i=0;i<totalPersonen;i++){
            int geld =  (int) randomNumber(10,100);
            int uebelkeit =  (int) randomNumber(1,10);
            int spass =  (int) randomNumber(1,10);
            tmpPersonen.add(new Person(i, geld, uebelkeit, spass));
        }

        // Personen output
        for (Person item : tmpPersonen) {
            System.out.println("Person:"+item.getId()+" Geld:"+item.getGeld()+" Spass:"+item.getSpass()+" Übelkeit:"+item.getUebelkeit());
        }
        System.out.println("*************");

        return tmpPersonen;
    }

    /*
        Hilfsfunktion für Zufallszahlen
     */
    private static double randomNumber(double low, double high) {
        return Math.random() * (high - low) + low;
    }
}
