package org.academia.gta.gameobject;

import org.academia.gta.Destructable;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject implements Destructable, MovableRepresentable {

    private int speed;
    private int x;
    private int y;
    private boolean destroyed;
    private int radius;


    public Bullet(Representable representation) {
        super(representation);
        this.radius = 1;
    }

    public void move(int x, int y) {


    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
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

    @Override
    public int getRadius() { return radius; }
}
