package org.academia.gta.gameobject.people;

import org.academia.gta.CollisionChecker;
import org.academia.gta.controls.Direction;
import org.academia.gta.controls.PlayerControls;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.BulletSGFX;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 01/06/16.
 */
public class Player extends Person {

    Picture imageLeft = new Picture(this.getX(),this.getY(),"resources/player_sprites/rambo_idle_shoot_l.png");

    private int counter = 0;

    public static final int MAX_NUM_BULLETS = 12;

    private boolean hasWeapon = true;
    private int totalAmmo = 0;
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

        if(currentDirection==Direction.RIGHT_DOWN) {
            moveDownRight();
        } else if (currentDirection==Direction.UP_RIGHT) {
            moveUpRight();
        } else if(currentDirection==Direction.LEFT_UP) {
           moveUpLeft();
        } else if(currentDirection==Direction.DOWN_LEFT) {
            moveDownLeft();
        } else if(currentDirection==Direction.RIGHT){
            moveRight();
        } else if(currentDirection==Direction.DOWN){
            moveDown();
        } else if(currentDirection==Direction.LEFT){
            moveLeft();
        } else if(currentDirection==Direction.UP){
            moveUp();
        }

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
                Bullet bullet = new Bullet(new BulletSGFX(getX()+getWidth()/2, getHeight()));
                bullet.shooted(getX()+getWidth()/2, getY() + getHeight(), playerControls.getMouseX(), playerControls.getMouseY());
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

    public boolean entry() {
        return playerControls.entry();
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

    private void moveRight() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_r.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_r.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_r.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_r.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
            counter = 0;
        }
    }

    private void moveLeft() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_l.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_l.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_l.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_l.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
            counter = 0;
        }
    }

    private void moveUp() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_u.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_u.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_u.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_u.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
            counter = 0;
        }
    }

    private void moveDown() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_d.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_d.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_d.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_d.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
            counter = 0;
        }
    }

    private void moveUpRight() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_ur.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_ur.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_ur.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_ur.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
            counter = 0;
        }
    }

    private void moveUpLeft() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_ul.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_ul.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_ul.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_ul.png");
        } else if (counter >= 30){
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
            counter = 0;
        }
    }

    private void moveDownLeft() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_dl.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_dl.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_dl.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_dl.png");
        } else if (counter >= 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
            counter = 0;
        }

    }

    private void moveDownRight() {
        counter++;
        if (counter >= 0 && counter < 5) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
        } else if (counter >= 5 && counter < 10) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_dr.png");
        } else if (counter >= 10 && counter < 15) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_dr.png");
        } else if (counter >= 15 && counter < 20) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
        } else if (counter >= 20 && counter < 25) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_dr.png");
        } else if (counter >= 25 && counter < 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_dr.png");
        } else if (counter >= 30) {
            this.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
            counter = 0;
        }

    }
}
