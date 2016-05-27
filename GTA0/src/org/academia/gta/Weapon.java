package org.academia.gta;

import org.academia.gta.people.Person;

/**
 * Created by codecadet on 24/05/16.
 */
public class Weapon extends GameObject implements Grabbable {

    //TODO arma vem com "x" ammo, cada reload gasta uma ammo até 0

    private Ammo ammo;
    private boolean grabbed;

    public Weapon() {



    }

    public void shoot() {

        ammo.shoot();

    }

    public void reload() {

        ammo.setNumBullets(Ammo.MAX_NUM_BULLETS);

    }

    public boolean isGrabbed() {
        return grabbed;
    }

    public void pickedBy(Person person) {
        person.setWeapon(this);
    }

    public void erase() {



    }

}