package org.academia.gta.people;

import org.academia.gta.*;

/**
 * Created by codecadet on 24/05/16.
 */
abstract public class Person extends GameObject implements Movable, Destructable {

    private Weapon weapon;
    private int numAmmo;
    private boolean dead;
    private int health;

    public void shoot() {

        weapon.shoot();

    }

    public void reload() {
        if (numAmmo > 0) {
            weapon.reload();
            numAmmo--;
        }
    }

    public void setAmmo() {
        numAmmo++;
    }

    public void setWeapon(Weapon weapon) {

        this.weapon = weapon;

    }

    public boolean isDestroyed() {
        return dead;
    }

    public void setDestroyed() {
        this.dead = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int bulletDamage) {
        health -= bulletDamage;
    }

}
