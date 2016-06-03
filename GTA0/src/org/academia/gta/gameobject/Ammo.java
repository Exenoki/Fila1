package org.academia.gta.gameobject;

import org.academia.gta.Grabbable;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.people.Person;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.BulletSGFX;

/**
 * Created by codecadet on 25/05/16.
 */
public class Ammo extends GameObject implements Grabbable {

    public static final int MAX_NUM_BULLETS = 12;
    private int numBullets = MAX_NUM_BULLETS;
    private boolean grabbed;
    private int radius;

    public Ammo(Representable representation) {
        super(representation);
        this.radius = 5; //TODO alterar valor;
    }

    public void shoot() {

        if(numBullets > 0){
            /*
            bullet.move();
            numBullets--;
            */
        }


    }

    public void setNumBullets(int numBullets) {
        this.numBullets = numBullets;
    }

    public int getNumBullets() {
        return numBullets;
    }

    public boolean isGrabbed() {
        return grabbed;
    }

    @Override
    public void pickedBy(GameObject go) {
        ((Person) go).setAmmo();
        this.grabbed = true;

    }

    @Override
    public int getRadius() {
        return radius;
    }
}
