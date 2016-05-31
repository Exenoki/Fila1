package org.academia.gta.gameobject.people;

import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Player extends Person implements MovableRepresentable {

    public Player(MovableRepresentable representation) {

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

    @Override
    public void move(int dx, int dy) {
        ((MovableRepresentable) getRepresentation()).move(dx, dy);
    }

}
