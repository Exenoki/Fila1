package org.academia.gta.gameobject;

import org.academia.gta.components.SoundFx;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject {

    private int x;
    private int y;

    private int d = 0;
    private int speed = 10;
    private double dt;

    private int x0;
    private int y0;
    private int xf;
    private int yf;

    public Bullet(Representable representation) {
        super(representation, GameObjectType.BULLET);
    }

    public Bullet shooted(int x0, int y0, int xf, int yf) {
        this.x0 = x0;
        this.y0 = y0;
        this.xf = xf;
        this.yf = yf;

        dt = Math.sqrt((xf - x0)*(xf - x0) + (yf - y0)*(yf -  y0));
        new SoundFx().shootSound();

        return this;
    }

    public void move() {

        d += speed;

        x = (int) Math.floor((1 - d / dt) * x0 + d / dt * xf);
        y = (int) Math.floor((1 - d / dt) * y0 + d / dt * yf);

        ((MovableRepresentable) getRepresentation()).move(x, y);
    }
}
