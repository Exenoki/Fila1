package org.academia.gta.gameobject.people;

import org.academia.gta.CollisionChecker;
import org.academia.gta.controls.Direction;
import org.academia.gta.controls.PlayerControls;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObjectFactory;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.BulletSGFX;
import org.academia.gta.simplegfx.SGFXRepresentationFactory;

/**
 * Created by codecadet on 01/06/16.
 */
public class Player extends Person {

    public static final int MAX_NUM_BULLETS = 12;

    private boolean hasWeapon = true;
    private int totalAmmo = 2;
    private int numBullets = MAX_NUM_BULLETS;
    private PlayerControls playerControls = new PlayerControls();

    private Direction currentDirection = Direction.NULL;
    private CollisionChecker collisionChecker;

    public Player(Representable representation, CollisionChecker collisionChecker) {
        super(representation);
        this.collisionChecker = collisionChecker;

    }

    public void move() {
        setCurrentDirection();

        int dx = playerControls.getDx();
        int dy = playerControls.getDy();

        if(collisionChecker.isBetweenEdges(this, dx, dy))
            ((MovableRepresentable)getRepresentation()).move(dx, dy);
    }

    private void setCurrentDirection() {
        currentDirection = playerControls.getCurrentDirection();
    }

    public Bullet shoot() {
        if(playerControls.isShooted()  && hasWeapon) {
            playerControls.setShooted(false);

            if (numBullets > 0) {
                Bullet bullet = new Bullet(new BulletSGFX(getX()+getWidth()/2, getY()+getHeight()/2));
                bullet.shooted(getX()+getWidth()/2, getY()+getHeight()/2, playerControls.getMouseX(), playerControls.getMouseY());
                numBullets--;

                return bullet;
            }

        }

        return null;
    }

    public void reload() {
        if(hasWeapon && totalAmmo > 0 && playerControls.isReload()) {
            numBullets = MAX_NUM_BULLETS;
            totalAmmo--;
            playerControls.setToReload(false);
        }
    }
}
