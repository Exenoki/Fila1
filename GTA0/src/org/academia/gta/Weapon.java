package org.academia.gta;

import org.academia.gta.people.Person;

/**
 * Created by codecadet on 24/05/16.
 */
public class Weapon extends GameObject implements Grabbable {

    //TODO arma vem com "x" ammo, cada reload gasta uma ammo até 0

    private Ammo ammo;
    private boolean grabbed;
    private int radius;

    public Weapon(int x, int y) {
        super(x, y);
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

    @Override
    public int getRadius() {
        return radius;
    }
}