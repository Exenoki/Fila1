package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.people.Player;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by andre on 02/06/2016.
 */
public class CollisionChecker {

    public void checkCollision(Player player, LinkedList<GameObject> gameObjects, LinkedList bullets) {

        Iterator iteratorBullets = bullets.iterator();
        Iterator iteratorGameObjects = gameObjects.iterator();

        while(iteratorBullets.hasNext()) {
            Bullet bullet = (Bullet) iteratorBullets.next();

            int bulletCenterX = bullet.getX() + Math.round(bullet.getWidth() / 2);
            int bulletCenterY = bullet.getY() + Math.round(bullet.getHeight() / 2);

//            int playerXR = player.getX() + player.getWidth();
//            int playerXL = player.getX();
//            int playerYU = player.getY();
//            int playerYD = player.getY() + player.getHeight();

            // Collision rectangles
//            if((bulletCenterX >= playerXL && bulletCenterX <= playerXR) &&
//                    (bulletCenterY >= playerYU && bulletCenterY <= playerYD)) {
//                System.out.println("Player death");
//            }

            int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
            int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

            // Collision radius
            if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                    Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 50 + 1) {
                System.out.println("Player death");
            }
        }

        while (iteratorGameObjects.hasNext()) {

            GameObject go = (GameObject) iteratorGameObjects.next();

            int gameObjectXL = go.getX();
            int gameObjectXR = go.getX() + go.getWidth();
            int gameObjectYU = go.getY();
            int gameObjectYD = go.getY() + go.getHeight();

//            int playerXL = player.getX();
//            int playerXR = player.getX() + player.getWidth();
//            int playerYU = player.getY();
//            int playerYD = player.getY() + player.getHeight();

            int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
            int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

            // if we use the four points change the && to || between points and compare the 4 points?
            if((playerCenterX >= gameObjectXL && playerCenterX <= gameObjectXR) &&
                    (playerCenterY >= gameObjectYU && playerCenterY <= gameObjectYD)) {
                System.out.println("Player Ammo grab");
            }

        }

    }

}
