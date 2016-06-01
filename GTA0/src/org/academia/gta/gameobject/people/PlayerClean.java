package org.academia.gta.gameobject.people;

import org.academia.gta.controls.PlayerControls;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.AnimationArrays;
import org.academia.gta.simplegfx.BulletSGFX;

/**
 * Created by codecadet on 01/06/16.
 */
public class PlayerClean extends PersonClean {

    public static final int MAX_NUM_BULLETS = 12;

    private boolean hasWeapon;
    private int totalAmmo;
    private int numBullets;
    private PlayerControls playerControls = new PlayerControls();

    //AnimationArrays teste = new AnimationArrays();


    public PlayerClean(Representable representation) {
        super(representation);
    }

    public void move() {

        //teste.animationArrays(playerControls.getDx(), playerControls.getDy());

        ((MovableRepresentable)getRepresentation()).move(playerControls.getDx(), playerControls.getDy());
    }

    public Bullet shoot() {
        if(playerControls.isShooted()) {
            playerControls.setShooted(false);
            //System.out.println(getX() + " " + getY());
            Bullet bullet = new Bullet(new BulletSGFX(getX(), getY())); // TODO mudar origem da bala
            //System.out.println(playerControls.getMouseX() + " " + playerControls.getMouseY());
            bullet.shooted(getX(), getY(), playerControls.getMouseX(), playerControls.getMouseY());
            numBullets--;

            return bullet;
        }

        return null;
    }

    public void reload() {
        if(hasWeapon && totalAmmo > 0 && playerControls.isReload()) {
            playerControls.setToReload(false);
            numBullets = MAX_NUM_BULLETS;
            totalAmmo--;
        }
    }

}
