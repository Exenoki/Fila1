package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
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

    public CollisionChecker(Grid grid) {
        this.grid = grid;
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
            }

            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();

                // Collision radius
                if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                        Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 15 + 1) {
                    enemy.giveDamage(10);

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

        return goX + dx >= 0 && goXWidth + dx <= grid.getWidth()
                && goY + dy >= 0 && goYHeight + dy <= grid.getHeight();

    }

}
