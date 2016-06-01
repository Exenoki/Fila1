package org.academia.gta.gameobject;

import org.academia.gta.Destructable;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject implements Destructable {

    private int x;
    private int y;
    private boolean destroyed;
    private int radius;

    private int d = 0;
    private int speed = 3;
    private double dt;

    private boolean flag = true;

    private int x0;
    private int y0;
    private int xf;
    private int yf;


    public Bullet(Representable representation) {
        super(representation);
        this.radius = 1;
    }

    public Bullet shooted(int x0, int y0, int xf, int yf) {
        this.x0 = x0;
        this.y0 = y0;
        this.xf = xf;
        this.yf = yf;

        return this;
    }

    public void move( ) {

        if(flag) {
            dt = Math.sqrt((xf - x0) ^ 2 + (yf - y0) ^ 2);
            flag = false;
        }

        d += speed;
        x = (int) Math.floor((1 - d / dt) * x0 + d / dt * xf);
        y = (int) Math.floor((1 - d / dt) * y0 + d / dt * yf);

        ((MovableRepresentable) getRepresentation()).move(x, y);

    }

    @Override
    public int getX() {
        return getRepresentation().getX();
    }

    @Override
    public int getY() {
        return getRepresentation().getY();
    }

    @Override
    public void merge() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int hit() { return (int)Math.round(Math.random()*20) + 20; }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void setDestroyed() {
        this.destroyed = true;
    }

    public int getRadius() { return radius; }
}
