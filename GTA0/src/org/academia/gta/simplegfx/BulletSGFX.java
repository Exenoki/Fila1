package org.academia.gta.simplegfx;

import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 28/05/16.
 */
public class BulletSGFX extends SGFXRepresentation {

    private int radius;
    private int speed;

    public BulletSGFX(int x, int y) {
        super(new Rectangle(x, y, 3, 3));
        this.speed = 5;
        this.radius = 1;
    }

    public void move(int dx, int dy) {



    }

}
