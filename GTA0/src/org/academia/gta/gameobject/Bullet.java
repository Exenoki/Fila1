package org.academia.gta.gameobject;

import org.academia.gta.components.SoundFx;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject {

    private int d = 0;
    private int speed = 10;
    private double dt;

    private int x0;
    private int y0;
    private int xf;
    private int yf;
    private int x;
    private int y;

    /**
     * Construct the bullet game object
     *
     * @param representation The bullet representation
     */
    public Bullet(Representable representation) {
        super(representation, GameObjectType.BULLET);
    }

    /**
     *  When the bullet is shooted it calculates the distance to where the mouse was clicked
     *
     * @param x0 X origin of the movement
     * @param y0 Y origin of the movement
     * @param xf X final (mouse clicked)
     * @param yf Y final (mouse clicked)
     * @return Bullet with a is direction
     */
    public Bullet shooted(int x0, int y0, int xf, int yf) {
        this.x0 = x0;
        this.y0 = y0;
        this.xf = xf;
        this.yf = yf;

        dt = Math.sqrt((xf - x0)*(xf - x0) + (yf - y0)*(yf -  y0));
        new SoundFx().shootSound();

        return this;
    }

    /**
     * Move the bullet
     */
    public void move() {

        d += speed;

        x = (int) Math.floor((1 - d / dt) * x0 + d / dt * xf);
        y = (int) Math.floor((1 - d / dt) * y0 + d / dt * yf);

        ((MovableRepresentable) getRepresentation()).move(x, y);
    }
}
