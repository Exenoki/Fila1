package org.academia.gta.gameobject;

import org.academia.gta.gameobject.GameObject;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Building extends GameObject {


    public Building(Representable representation) {
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
