package org.academia.gta.simplegfx.gameobjectsgfx;

import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 * This class is responsible for assigning an picture to the bullet and move it.
 */

public class BulletSGFX extends SGFXRepresentation implements MovableRepresentable {

    private int x0;
    private int y0;

    /**
     * Bullet constructor.
     * @param x The X position of the bullet when instantiated.
     * @param y The Y position of the bullet when instantiated.
     */
    public BulletSGFX(int x, int y) {
        super(new Picture(x, y, "resources/game_sprites/bullet.jpg")); //Image used to represent the bullet
        this.x0 = x;
        this.y0 = y;
    }


    /**
     * Moves the picture (representation) of the bullet acordingly to its last position and new X, Y.
     * @param x The X new position of the bullet when instantiated.
     * @param y The Y position of the bullet when instantiated.
     */
    public void move(int x, int y) {

        if (shape instanceof Movable) {
            ((Movable) getShape()).translate(x - x0, y - y0); //Move the representation of the bullet
            x0 = x;
            y0 = y;
        }
    }

}
