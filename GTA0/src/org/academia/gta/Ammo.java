package org.academia.gta;

import org.academia.gta.people.Person;

/**
 * Created by codecadet on 25/05/16.
 */
public class Ammo extends GameObject implements Grabbable {

    public static final int MAX_NUM_BULLETS = 12;
    private int numBullets = MAX_NUM_BULLETS;
    private boolean grabbed;
    private Weapon weapon;


    public void shoot() {

        //new Bullet().move();
        numBullets--;

    }

    public void setNumBullets(int numBullets) {
        this.numBullets = numBullets;
    }

    public int getNumBullets() {
        return numBullets;
    }

    public boolean isGrabbed() {
        return grabbed;
    }

    public void pickedBy(Person person) {
        person.setAmmo();
    }

    public void erase() {

    }

}
