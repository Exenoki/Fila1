package org.academia.gta.gameobject.people;

import org.academia.gta.Destructable;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 01/06/16.
 */
public class PersonClean extends GameObject implements Destructable {

    private boolean isDead;
    private int health;

    public PersonClean(Representable representation) {
        super(representation);
        setRadius(10); // TODO remove hard coding radius person
        health = 100;
    }

    @Override
    public boolean isDestroyed() {
        return isDead;
    }

    @Override
    public void setDestroyed() {
        this.isDead = true;
    }

    @Override
    public int getX() {
        return getRepresentation().getX();
    }

    @Override
    public int getY() {
        return getRepresentation().getY();
    }

    @Override
    public void merge() {

    }
}
