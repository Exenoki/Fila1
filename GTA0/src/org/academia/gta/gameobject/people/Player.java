package org.academia.gta.gameobject.people;

import org.academia.gta.controls.PlayerControls;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.MovableRepresentable;

/**
 * Created by codecadet on 24/05/16.
 */
public class Player extends Person {

    private PlayerControls playerControls = new PlayerControls();

    public Player(MovableRepresentable representation) {

        super(representation);

    }

    public void move() {
        ((MovableRepresentable)getRepresentation()).move(playerControls.getDx(), playerControls.getDy());
    }

    public Bullet shoot() {
        if(playerControls.isShooted()) {
            playerControls.setShooted(false);
            if(hasWeapon()) {
                return getWeapon().shoot(getX(), getY(), playerControls.getMouseX(), playerControls.getMouseY());
            }
            //return super.shoot(playerControls.getMouseX(), playerControls.getMouseY());
        }

        return null;
    }

    @Override
    public void reload() {
        if (playerControls.isReload()) {
            super.reload();
            playerControls.setToReload(false);
        }
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

}
