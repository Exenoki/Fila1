package org.academia.gta.gameobject;

import org.academia.gta.Grabbable;
import org.academia.gta.gameobject.people.Person;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Weapon extends GameObject implements Grabbable {

    //TODO arma vem com "x" ammo, cada reload gasta uma ammo até 0

    private Ammo ammo;
    private boolean grabbed;
    private int radius;

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void merge() {

    }

    public Weapon(Representable representation) {
        super(representation);
        this.radius = 15; //TODO alterar valor;
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

    @Override
    public void pickedBy(GameObject go) {

        if (!((Person) go).hasWeapon()) {
            ((Person) go).setWeapon(this);
            reload();
            this.grabbed = true;
            ((Person) go).setHasWeapon();
        } else {
            ((Person)go).setAmmo();
        }


    }


    public Ammo getAmmo() {
        return ammo;
    }

    public int getRadius() {
        return radius;
    }
}