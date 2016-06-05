package org.academia.gta.gameobject.people;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.gameobjectsgfx.BulletSGFX;


/**
 * Created by codecadet on 24/05/16.
 */
public class Enemy extends Person {

    private Bullet bullet;
    private Direction dir;
    private boolean condition;
    private long betweenShoot = System.currentTimeMillis();
    private long instant;
    private EnemyType type;

    public Enemy(Representable representation, Direction dir, EnemyType type) {
        super(representation);
        this.type = type;
        this.dir = dir;
    }

    /**
     * Enemy's shoot method:
     *
     * Depending on the enemy's direction, his shooting direction and behavior will also change.
     * Each condition creates a frontal cone of vision, which depends on the direction the enemy is turned to.
     *
     * There is also a secondary condition which compares the system current time in milliseconds with a second value
     * that increases each time the condition is allowed. This behavior causes a precise delay to the enemy's shot.
     *
     *
     * @param player
     * @return
     */
    public Bullet shoot(Player player) {

        bullet = null;

        int positionOffsetY = 0;
        int positionOffsetX = 0;

        switch (dir) {
            case UP:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 200 &&
                        player.getY() < getY() && (player.getY() - getY() < 0.5*(player.getX() - getX()) && (player.getY() - getY() < 0.5*(getX() - player.getX())));
                positionOffsetY = getY();
                positionOffsetX = getX()+getWidth()/2;
                break;

            case DOWN:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 200 &&
                        player.getY() > getY() && (player.getY() - getY() > 0.5*(player.getX() - getX()) && (player.getY() - getY() > 0.5*(getX() - player.getX())));
                positionOffsetY = getY()+getHeight();
                positionOffsetX = getX()+getWidth()/2;
                break;

            case LEFT:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 200 &&
                        player.getX() < getX() && (player.getY() - getY() > 2*(player.getX() - getX()) && (player.getY() - getY() < 2*(getX() - player.getX())));
                positionOffsetY = getY()+getHeight()/2;
                positionOffsetX = getX();
                break;

            case RIGHT:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 200 &&
                        player.getX() > getX() && (player.getY() - getY() < 2*(player.getX() - getX()) && (player.getY() - getY() > 2*(getX() - player.getX())));
                positionOffsetY = getY()+getHeight()/2;
                positionOffsetX = getX()+getWidth();
        }

        instant = System.currentTimeMillis();

        if (condition && (instant >= betweenShoot)) {


                bullet = new Bullet(new BulletSGFX(positionOffsetX, positionOffsetY));
                bullet.shooted(positionOffsetX, positionOffsetY, player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2);

                betweenShoot = System.currentTimeMillis() + 250;
                return bullet;

        }

        return null;

    }

    public EnemyType getType(){
        return type;
    }

}
