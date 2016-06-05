package org.academia.gta.gameobject.people;

import org.academia.gta.components.Animator;
import org.academia.gta.components.CollisionChecker;
import org.academia.gta.controls.Direction;
import org.academia.gta.controls.PlayerControls;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.gameobjectsgfx.BulletSGFX;

/**
 * Created by codecadet on 01/06/16.
 */
public class Player extends Person {

    private int counter = 0;
    private boolean isDriving;
    private Animator playerAnimation;
    public static final int MAX_NUM_BULLETS = 12;

    private boolean hasWeapon = true;
    private int totalAmmo = 0;
    private int numBullets = MAX_NUM_BULLETS;
    private PlayerControls playerControls = new PlayerControls();

    private Direction currentDirection = Direction.NULL;
    private Direction lastDirection = Direction.NULL;
    private CollisionChecker collisionChecker;

    public Player(Representable representation, CollisionChecker collisionChecker) {
        super(representation);
        playerAnimation = new Animator();
        this.collisionChecker = collisionChecker;

    }

    public void move() {
        setCurrentDirection();

        int dx = playerControls.getDx();
        int dy = playerControls.getDy();

        if (!isDriving) {

            if (currentDirection != Direction.NULL) {

                lastDirection = currentDirection;

                if (currentDirection == Direction.RIGHT_DOWN) {
                    playerAnimation.animationMoveDownRight(this);
                } else if (currentDirection == Direction.UP_RIGHT) {
                    playerAnimation.animationMoveUpRight(this);
                } else if (currentDirection == Direction.LEFT_UP) {
                    playerAnimation.animationMoveUpLeft(this);
                } else if (currentDirection == Direction.DOWN_LEFT) {
                    playerAnimation.animationMoveDownLeft(this);
                } else if (currentDirection == Direction.RIGHT) {
                    playerAnimation.animationMoveRight(this);
                } else if (currentDirection == Direction.DOWN) {
                    playerAnimation.animationMoveDown(this);
                } else if (currentDirection == Direction.LEFT) {
                    playerAnimation.animationMoveLeft(this);
                } else if (currentDirection == Direction.UP) {
                    playerAnimation.animationMoveUp(this);
                }

            }

        }

        if(collisionChecker.isBetweenEdges(this, dx, dy))
            ((MovableRepresentable)getRepresentation()).move(dx, dy);
    }

    public void setDriving(boolean driving) {
        isDriving = driving;
    }

    private void setCurrentDirection() {
        currentDirection = playerControls.getCurrentDirection();
    }

    public Bullet shoot() {

        if(playerControls.isShooted()  && hasWeapon) {

            playerControls.setShooted(false);

            if (numBullets > 0) {

                Bullet bullet = null;

                if (lastDirection != Direction.NULL) {

                    if (lastDirection == Direction.UP && playerControls.getMouseY() < getY() - getRadius()) {
                        bullet = new Bullet(new BulletSGFX(getX() + getWidth() / 2, getY()));
                        bullet.shooted(getX() + getWidth() / 2, getY(), playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.UP_RIGHT && (playerControls.getMouseY() - getY() < playerControls.getMouseX() - (getX() + getWidth()))) {
                        bullet = new Bullet(new BulletSGFX(getX() + getWidth(), getY()));
                        bullet.shooted(getX() + getWidth(), getY(), playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.RIGHT && (playerControls.getMouseX() > getX() + getWidth())) {
                        bullet = new Bullet(new BulletSGFX(getX() + getWidth(), getY() + getHeight() / 2));
                        bullet.shooted(getX() + getWidth(), getY() + getHeight() / 2, playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.RIGHT_DOWN && (playerControls.getMouseY() - (getY() + getHeight()) > (getX() + getWidth()) - playerControls.getMouseX())) {
                        bullet = new Bullet(new BulletSGFX(getX() + getWidth(), getY() + getHeight()));
                        bullet.shooted(getX() + getWidth(), getY() + getHeight(), playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.DOWN && (playerControls.getMouseY() > getY() + getHeight())) {
                        bullet = new Bullet(new BulletSGFX(getX() + getWidth() / 2, getY()+getHeight()));
                        bullet.shooted(getX() + getWidth() / 2, getY()+getHeight(), playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.DOWN_LEFT && (playerControls.getMouseY() - (getY() + getHeight()) > playerControls.getMouseX() - getX())) {
                        bullet = new Bullet(new BulletSGFX(getX(), getY() + getHeight()));
                        bullet.shooted(getX(), getY() + getHeight(), playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.LEFT && (playerControls.getMouseX() < getX())) {
                        bullet = new Bullet(new BulletSGFX(getX() , getY() + getHeight() / 2));
                        bullet.shooted(getX(), getY() + getHeight() / 2, playerControls.getMouseX(), playerControls.getMouseY());
                    } else if (lastDirection == Direction.LEFT_UP && (playerControls.getMouseY() - getY() < getX() - playerControls.getMouseX())) {
                        bullet = new Bullet(new BulletSGFX(getX(), getY()));
                        bullet.shooted(getX(), getY(), playerControls.getMouseX(), playerControls.getMouseY());
                    }

                    if (bullet != null) {
                        numBullets--;
                        return bullet;
                    }

                }

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

    public void resetEntry() {
        playerControls.entred();
    }

    public boolean entry() {
        return playerControls.isEntry();
    }

    public int getTotalAmmo() {
        return totalAmmo;
    }

    public void setTotalAmmo() {
        this.totalAmmo++;
    }

    public int getNumBullets() {
        return numBullets;
    }

}
