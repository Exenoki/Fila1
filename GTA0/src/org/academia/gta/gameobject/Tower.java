package org.academia.gta.gameobject;

import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 29/05/16.
 */
public class Tower extends GameObject {

    public Tower(Representable representation) {
        super(representation);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public Representable getY() {
        return 0;
    }

    @Override
    public void merge() {

    }

}