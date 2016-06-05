package org.academia.gta.simplegfx.gameobjectsgfx;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 * This class is responsible for assigning an picture to the Player and move it.
 *
 */
public class PlayerSGFX extends SGFXRepresentation implements MovableRepresentable {

    /**
     * Cons
     * @param x
     * @param y
     */
    public PlayerSGFX(int x, int y) {
        super(new Picture(x, y, GameObjectType.PLAYER.getUrl()));

    }


    /**
     * Moves (translates) the picture (representation) of the bullet acordingly to its last position and new X, Y.
     * @param dx The Delta-X(diferential) new position of the bullet when instantiated.
     * @param dy The Delta-Y(diferential) new position of the bullet when instantiated.
     */
    @Override
    public void move(int dx, int dy) {
        ((Movable) getShape()).translate(dx, dy);
    }


}
