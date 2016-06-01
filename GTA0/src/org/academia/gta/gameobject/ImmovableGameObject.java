package org.academia.gta.gameobject;

import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 01/06/16.
 */
public class ImmovableGameObject extends GameObject {

    public ImmovableGameObject(Representable representation) {
        super(representation);
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
