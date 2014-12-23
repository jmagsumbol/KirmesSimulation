package de.oev;

/**
 * Created by magsumbol on 18.12.14.
 */
public class Person {

    public static final int NOMONEY = 0;
    public static final int TOILET = 1;
    public static final int PUKE = 2;

    private int id;
    private int geld;
    private int uebelkeit;
    private int spass;
    private int status;

    public Person(int id, int geld, int uebelkeit, int spass) {
        this.id = id;
        this.geld = geld;
        this.uebelkeit = uebelkeit;
        this.spass = spass;
    }

    public int getId() {
        return id;
    }

    public int getUebelkeit() {
        return uebelkeit;
    }

    public void setUebelkeit(int uebelkeit) {
        this.uebelkeit = uebelkeit;
    }

    public int getSpass() {
        return spass;
    }

    public void setSpass(int spass) {
        this.spass = spass;
    }

    public int getGeld() {
        return geld;
    }

    public void setGeld(int geld) {
        this.geld = geld;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
