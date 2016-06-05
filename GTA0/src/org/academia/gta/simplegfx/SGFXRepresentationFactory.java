package org.academia.gta.simplegfx;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.Representable;
import org.academia.gta.representation.RepresentableFactory;
import org.academia.gta.simplegfx.gameobjectsgfx.ImmovableGOSGFX;
import org.academia.gta.simplegfx.gameobjectsgfx.PlayerSGFX;

/**
 * Created by codecadet on 26/05/16.
 *
 * Create the game object representation
 */
public class SGFXRepresentationFactory implements RepresentableFactory {

    @Override
    public Representable createRepresentation(int x, int y, GameObjectType got) {

        Representable representable = null;

        switch (got) {

            case PLAYER:
                representable = new PlayerSGFX(x, y);
                break;

            case AMMO:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.AMMO);
                break;

            case BARBEDWIRE:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.BARBEDWIRE);
                break;

            case TREE:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.TREE);
                break;
        }

        return representable;

    }
}
