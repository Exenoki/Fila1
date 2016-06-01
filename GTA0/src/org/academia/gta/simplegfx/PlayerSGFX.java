package org.academia.gta.simplegfx;

import org.academia.gta.representation.MovableRepresentable;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class PlayerSGFX extends SGFXRepresentation implements MovableRepresentable {


    public PlayerSGFX(int x, int y) {
        super(new Picture(x, y, "resources/player_sprites/idle_d.png"));



    }

    @Override
    public void move(int dx, int dy) {
        ((Movable) getShape()).translate(dx, dy);
    }
}
