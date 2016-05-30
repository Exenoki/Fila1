package org.academia.gta;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject implements Movable, Destructable {

    private int speed;
    private int x;
    private int y;
    private boolean destroyed;
    private int radius;


    public Bullet(int x, int y) {
        super(x, y);
        this.radius = 1;
    }

    public void move(int x, int y) {


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void setDestroyed() {

    }
}
