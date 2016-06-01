package org.academia.gta.gameobject;

import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Weapon extends GameObject {


    public Weapon(Representable representation) {
        super(representation);
        setRadius(15);
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
    public int getWidth() {
        return getRepresentation().getWidth();
    }

    @Override
    public int getHeight() {
        return getRepresentation().getHeight();
    }
    @Override
    public void merge() {

    }

}