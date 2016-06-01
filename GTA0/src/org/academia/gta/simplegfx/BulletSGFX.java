package org.academia.gta.simplegfx;

import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 28/05/16.
 */
public class BulletSGFX extends SGFXRepresentation implements MovableRepresentable {

    private int radius;
    private int speed;
    private int x0;
    private int y0;

    private int size = 3;

    public BulletSGFX(int x, int y) {
        super(new Rectangle(x, y, 3, 3));
        ((Rectangle)this.getShape()).fill();
        this.x0 = x;
        this.y0 = y;
        this.speed = 5;
        this.radius = 1;
    }

    public void move(int x, int y) {

        if (shape instanceof Movable) {

            ((Movable) getShape()).translate(x - x0, y - y0);

            x0 = x;
            y0 = y;
        }

    }

    public int getSize() {
        return size;
    }

}
