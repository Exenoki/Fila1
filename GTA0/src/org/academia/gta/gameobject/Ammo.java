package org.academia.gta.gameobject;

import org.academia.gta.Grabbable;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.people.Person;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.BulletSGFX;
import org.academia.gta.simplegfx.SGFXRepresentationFactory;

/**
 * Created by codecadet on 25/05/16.
 */
public class Ammo extends GameObject implements Grabbable {

    public static final int MAX_NUM_BULLETS = 12;
    private int numBullets = MAX_NUM_BULLETS;
    private boolean grabbed;
    private int radius;
    private Bullet[] bullets;

    public Ammo(Representable representation) {
        super(representation);
        bullets = new Bullet[MAX_NUM_BULLETS];
        this.radius = 5;
    }

    public Bullet shoot(int x0, int y0, int xf, int yf) {

        if(numBullets > 0){
            bullets[numBullets - 1] = new Bullet(new BulletSGFX(x0, y0));
            bullets[numBullets - 1].shooted(x0, y0, xf, yf);
            numBullets--;

            return bullets[numBullets];
        }

        return null;
    }

    public void reload() {
        bullets = new Bullet[MAX_NUM_BULLETS];

        /*for (Bullet bullet : bullets) {
            if (bullet != null) {
                bullet = new Bullet(null);
            }
        }*/

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

    public int getRadius() {
        return radius;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void merge() {

    }
}
