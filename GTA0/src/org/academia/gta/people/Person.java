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
    private int radius;
    private boolean hasWeapon;

    public Person() {
        this.radius = 10; //TODO a mudar o valor 10
        this.health = 100;
        this.
    }

    public void shoot() {
        if(hasWeapon()) {
            weapon.shoot();
        }
    }

    public void reload() {
        if(hasWeapon()) {
            if (numAmmo > 0) {
                if (weapon.getAmmo().getNumBullets() < Ammo.MAX_NUM_BULLETS) {
                    weapon.reload();
                    numAmmo--;
                }
            }
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

    public boolean hasWeapon(){
        return hasWeapon;
    }

    public void setHasWeapon() {
        this.hasWeapon = true;
    }
}
