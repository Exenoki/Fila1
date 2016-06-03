package org.academia.gta.gameobject.people;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.representation.Representable;
import org.academia.gta.simplegfx.BulletSGFX;


/**
 * Created by codecadet on 24/05/16.
 */
public class Enemy extends Person {

    private Direction dir;
    private boolean condition;
    private Bullet bullet;
    private long betweenShoot = System.currentTimeMillis();

    public Enemy(Representable representation, Direction dir) {
        super(representation);
        this.dir = dir;//TODO criar classe que extende timertask e meter ali no schedule
    }

    public Bullet shoot(Player player) {

        bullet = null;

        switch (dir) {
            case UP:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 200 &&
                        player.getY() < getY() && (player.getY() - getY() < 0.5*(player.getX() - getX()) && (player.getY() - getY() < 0.5*(getX() - player.getX())));
                break;

            case DOWN:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 100 &&
                        player.getY() > getY();
                break;

            case LEFT:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 100 &&
                        player.getX() < getX();
                break;

            case RIGHT:
                condition = Math.sqrt(Math.pow((double)(this.getX() - player.getX()),2) + Math.pow((double)(this.getY() - player.getY()),2)) < 100 &&
                        player.getX() > getX();
        }

        System.out.println(System.currentTimeMillis() + " " + betweenShoot);

        if (condition && System.currentTimeMillis() >= betweenShoot) {
            bullet = new Bullet(new BulletSGFX(getX()+getWidth()/2, getY()+getHeight()/2));
            bullet.shooted(getX()+getWidth()/2, getY()+getHeight()/2, player.getX()+player.getWidth()/2, player.getY()+player.getHeight()/2);
            betweenShoot += 10000;
        }

        return bullet;

    }

}
