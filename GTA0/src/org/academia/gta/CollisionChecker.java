package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.Grid;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by andre on 02/06/2016.
 */
public class CollisionChecker {

    private Grid grid;
    private LinkedList<ImmovableGameObject> staticGOCollision;

    public CollisionChecker(Grid grid, LinkedList<ImmovableGameObject> staticGOCollision) {
        this.grid = grid;
        this.staticGOCollision = staticGOCollision;
    }

    public void scenarioCollisions(Player player, LinkedList<GameObject> gameObjects) {
        Iterator gameObjectsIterator = gameObjects.iterator();

        int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
        int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

        while (gameObjectsIterator.hasNext()) {

            GameObject gameObject = (GameObject) gameObjectsIterator.next();

            if(gameObject.getGot() == GameObjectType.AMMO) {
                if((playerCenterX >= gameObject.getX() && playerCenterX <= gameObject.getX() + gameObject.getWidth()) &&
                        (playerCenterY >= gameObject.getY() && playerCenterY <= gameObject.getY() + gameObject.getHeight())) {
                    gameObject.getRepresentation().delete();
                    gameObjectsIterator.remove();
                    player.setTotalAmmo();
                }
            }

            if(gameObject.getGot() == GameObjectType.BOAT) {
                if((playerCenterX >= gameObject.getX() && playerCenterX <= gameObject.getX() + gameObject.getWidth()) &&
                        (playerCenterY >= gameObject.getY() && playerCenterY <= gameObject.getY() + gameObject.getHeight())) {

                    if(player.entry()) {

                        System.out.println("Entry");
                    }

                }
            }
        }
    }

    public void bulletsCollision(Player player, LinkedList<Bullet> bullets, LinkedList<Enemy> enemies) {

        Iterator<Bullet> bulletsIterator = bullets.iterator();
        Iterator<Enemy> enemyIterator = enemies.iterator();

        int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
        int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

        while (bulletsIterator.hasNext()) {
            Bullet bullet = bulletsIterator.next();

            int bulletCenterX = bullet.getX() + Math.round(bullet.getWidth() / 2);
            int bulletCenterY = bullet.getY() + Math.round(bullet.getHeight() / 2);

            // Collision radius
            if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                    Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 15 + 1) {
                player.giveDamage(10);
                bullet.getRepresentation().delete();
                bulletsIterator.remove();
            }

            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();

                // Collision radius
                if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                        Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 15 + 1) {
                    enemy.giveDamage(10);
                    bullet.getRepresentation().delete();
                    bulletsIterator.remove();

                    if (enemy.isDestroyed()) {
                        enemies.remove();

                        System.out.println("enemy death");
                    }
                }
            }

        }
    }

    public boolean isBetweenEdges(GameObject gameObject, int dx, int dy) {

        int goXWidth = gameObject.getX() + gameObject.getWidth();
        int goX = gameObject.getX();
        int goY = gameObject.getY();
        int goYHeight = gameObject.getY() + gameObject.getHeight();

        Iterator<ImmovableGameObject> goInSuperable = staticGOCollision.iterator();

        if (gameObject instanceof Player){

            int playerCenterX = gameObject.getX() + Math.round(gameObject.getWidth() / 2);
            int playerCenterY = gameObject.getY() + Math.round(gameObject.getHeight() / 2);

            while (goInSuperable.hasNext()) {

                GameObject go = goInSuperable.next();

                if ((playerCenterX + dx >= go.getX() && playerCenterX + dx <= go.getX() + go.getWidth()) &&
                        (playerCenterY + dy>= go.getY() && playerCenterY + dy <= go.getY() + go.getHeight())) {

                    if (go.getGot() == GameObjectType.BARBEDWIRE) {
                        ((Player) gameObject).giveDamage(1);
                    }

                    if (go.getGot() == GameObjectType.BRIDGE) {

                        int bridgeY = go.getY();

                        if((playerCenterY + dy >= bridgeY + 30 && playerCenterY + dy <= bridgeY + go.getHeight() - 70)) {
                            return true;
                        }
                    }

                    return false;
                }
            }

            // Water collision
            if(playerCenterX + dx >= 620 && playerCenterX + dx <= 825) {
                return false;
            }
        }

        return goX + dx >= 0 && goXWidth + dx <= grid.getWidth()
                && goY + dy >= 0 && goYHeight + dy <= grid.getHeight() ;

    }

}
