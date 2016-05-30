package org.academia.gta.gameobject.people;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.SGFXRepresentationFactory;

/**
 * Created by codecadet on 24/05/16.
 */
public class Player extends Person implements MovableRepresentable {

    public Player(MovableRepresentable representation) {

        super(representation);

    }

    @Override
    public void move(int dx, int dy) {
        ((MovableRepresentable) getRepresentation()).move(dx, dy);
    }

}
