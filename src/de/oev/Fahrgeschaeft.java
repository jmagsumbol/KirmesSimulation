package de.oev;

/**
 * Created by magsumbol on 27.11.14.
 */
public class Fahrgeschaeft {

    private String id_name;
    private int uebelkeit_level;
    private int kosten;
    private int anzahl_gaeste;
    private int spass_level;
    private int einnahmen;

    public Fahrgeschaeft(String _id_name, int _uebelkeit_level, int _kosten, int _anzahl_gaeste, int _spass_level){
        this.id_name = _id_name;
        this.uebelkeit_level = _uebelkeit_level;
        this.kosten = _kosten;
        this.anzahl_gaeste = _anzahl_gaeste;
        this.spass_level = _spass_level;
    }

    public String getId_name() {
        return id_name;
    }

    public int getUebelkeit_level(){
        return this.uebelkeit_level;
    }

    public void setUebelkeit_level(int val){
        this.uebelkeit_level = val;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    public int getSpass_level() {
        return spass_level;
    }

    public void setSpass_level(int spass_level) {
        this.spass_level = spass_level;
    }

    public int getAnzahl_gaeste() {

        return anzahl_gaeste;
    }

    public void setAnzahl_gaeste(int anzahl_gaeste) {
        this.anzahl_gaeste = anzahl_gaeste;
    }

    public int getEinnahmen() {
        return einnahmen;
    }

    public void setEinnahmen(int einnahmen) {
        this.einnahmen = einnahmen;
    }
}