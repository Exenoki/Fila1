package org.academia.gta.people;

import org.academia.gta.GameObjectType;
import org.academia.gta.Movable;
import org.academia.gta.representation.Representable;
import org.academia.gta.representation.SGFXRepresentationFactory;

/**
 * Created by codecadet on 24/05/16.
 */
public class Player extends Person implements Movable {

    public Player(Representable shape) {

        this.setRepresentation(shape);
        SGFXRepresentationFactory.createRepresentation(GameObjectType.PLAYER);

    }

    @Override
    public void move(int x, int y) {

    }

}
