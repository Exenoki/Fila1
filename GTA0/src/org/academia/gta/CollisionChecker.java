package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.Grid;
import org.academia.gta.simplegfx.ImmovableGOSGFX;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by andre on 02/06/2016.
 */
public class CollisionChecker {

    private Grid grid;
    private LinkedList<ImmovableGameObject> staticGOCollision;
    private boolean isInverted = false;

    public CollisionChecker(Grid grid, LinkedList<ImmovableGameObject> staticGOCollision) {
        this.grid = grid;
        this.staticGOCollision = staticGOCollision;
    }

    public void scenarioCollisions(Player player, LinkedList gameObjects) {
        Iterator gameObjectsIterator = gameObjects.iterator();

        int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
        int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

        while (gameObjectsIterator.hasNext()) {

            Object gameObject = gameObjectsIterator.next();

            if(gameObject instanceof ImmovableGameObject) {

                ImmovableGameObject go = (ImmovableGameObject) gameObject;

                if(go.getGot() == GameObjectType.AMMO && (playerCenterX >= go.getX() && playerCenterX <= go.getX() + go.getWidth()) &&
                        (playerCenterY >= go.getY() && playerCenterY <= go.getY() + go.getHeight())) {

                    go.getRepresentation().delete();
                    gameObjectsIterator.remove();
                    player.setTotalAmmo();
                }
            }

            if(gameObject instanceof ImmovableGOSGFX) {

                ImmovableGOSGFX go = (ImmovableGOSGFX) gameObject;

                if((playerCenterX >= go.getX() && playerCenterX <= go.getX() + go.getWidth()) &&
                        (playerCenterY >= go.getY() && playerCenterY <= go.getY() + go.getHeight())) {

                    if(player.entry()) {
                        isInverted = !isInverted;
                        player.getRepresentation().translate(go.getX() - player.getX(), go.getY() - player.getY());
                        player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
                        player.setDriving(isInverted);
                    }

                    if (isInverted) {
                        go.translate(player.getX() - go.getX(), player.getY() - go.getY());
                    }

                }
            }
        }

        player.resetEntry();
    }

    public void bulletsCollision(Player player, LinkedList<Bullet> bullets, LinkedList<Enemy> enemies, LinkedList<ImmovableGameObject> staticGOCollision) {

        Iterator<Bullet> bulletsIterator = bullets.iterator();
        Iterator<Enemy> enemyIterator = enemies.iterator();
        Iterator<ImmovableGameObject> staticGOIterator = staticGOCollision.iterator();

        int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
        int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

        while (bulletsIterator.hasNext()) {
            Bullet bullet = bulletsIterator.next();

            boolean bulletHit = false;

            int bulletCenterX = bullet.getX() + Math.round(bullet.getWidth() / 2);
            int bulletCenterY = bullet.getY() + Math.round(bullet.getHeight() / 2);

            // Collision radius
            if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                    Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 15 + 1) {
                player.giveDamage(10);
                bullet.getRepresentation().delete();
                bulletsIterator.remove();
                bulletHit = true;
            }

            if (!bulletHit) {
                while (staticGOIterator.hasNext()) {
                    ImmovableGameObject immovableGameObject = staticGOIterator.next();

                    if (immovableGameObject.getGot() == GameObjectType.BUNKER) {

                        if ((bulletCenterX >= immovableGameObject.getX() && bulletCenterX <= immovableGameObject.getX() + immovableGameObject.getWidth()) &&
                                (bulletCenterY >= immovableGameObject.getY() && bulletCenterY <= immovableGameObject.getY() + immovableGameObject.getHeight())) {

                            bullet.getRepresentation().delete();
                            bulletsIterator.remove();

                            break;
                        }

                        bulletHit = true;
                    }
                }
            }

            if(!bulletHit) {
                while (enemyIterator.hasNext()) {
                    Enemy enemy = enemyIterator.next();

                    int enemyCenterX = enemy.getX() + Math.round(enemy.getWidth() / 2);
                    int enemyCenterY = enemy.getY() + Math.round(enemy.getHeight() / 2);

                    // Collision radius
                    if (Math.sqrt(Math.abs(bulletCenterX - enemyCenterX) * Math.abs(bulletCenterX - enemyCenterX) +
                            Math.abs(bulletCenterY - enemyCenterY) * Math.abs(bulletCenterY - enemyCenterY)) < 15 + 1) {
                        enemy.giveDamage(10);
                        bullet.getRepresentation().delete();
                        bulletsIterator.remove();

                        if (enemy.isDestroyed()) {
                            enemy.getRepresentation().load("resources/enemy_sprites/captain_dead.png");
                            enemyIterator.remove();
                        }

                        break;
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
            if(playerCenterX + dx >= 620 && playerCenterX + dx <= 820 && !isInverted) {
                return false;
            }

            if (isInverted) {
                return !(playerCenterX + dx < 610 || playerCenterX + dx > 825);
            }
        }

        return goX + dx >= 0 && goXWidth + dx <= grid.getWidth()
                && goY + dy >= 0 && goYHeight + dy <= grid.getHeight() ;

    }

}
