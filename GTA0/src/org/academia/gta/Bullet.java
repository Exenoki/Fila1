package org.academia.gta;

/**
 * Created by codecadet on 24/05/16.
 */
public class Bullet extends GameObject implements Movable, Destructable {

    private int speed;

    public void move(int x, int y) {



    }

    public int getX() {



    }

    public int getY() {



    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int hit() {

        return (int)Math.round(Math.random()*20) + 20;

    }



}
