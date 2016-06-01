package org.academia.gta.gameobject.people;

import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Enemy extends Person {

    public Enemy(Representable representation) {
        super(representation);
    }

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
}
