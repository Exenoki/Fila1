package org.academia.gta.simplegfx.gameobjectsgfx;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/16.
 * This class is responsible for assigning a picture to the Immovable Objects of the game (AMMO, BARBWIRE, BUNKER and TREES).
 */
public class ImmovableGOSGFX extends SGFXRepresentation {

    /**
     * Immovable object constructor.
     * @param x The X position of the Immovable object when instantiated.
     * @param y The X position of the Immovable object when instantiated.
     * @param got The type of object to be represented when instantiated.
     */
    public ImmovableGOSGFX(int x, int y, GameObjectType got) {
        super(new Picture(x, y, got.getUrl()));
    }

}
