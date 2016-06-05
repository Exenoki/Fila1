package org.academia.gta.simplegfx.gameobjectsgfx;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 02/06/16.
 */
public class ImmovableGOSGFX extends SGFXRepresentation {

    public ImmovableGOSGFX(int x, int y, GameObjectType got) {
        super(new Picture(x, y, got.getUrl()));
    }

}
