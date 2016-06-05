package org.academia.gta.components;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.EnemyType;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.terrainsgfx.Terrain;
import org.academia.gta.simplegfx.gameobjectsgfx.ImmovableGOSGFX;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by andre on 02/06/2016.
 *
 * Class of the collision checker
 */
public class CollisionChecker {

    private Terrain terrain;
    private LinkedList<ImmovableGameObject> staticGOCollision; // List of static objects which the player can collide against
    private boolean isInverted = false; // Verifies if the collision system was inverted (Used when the player sails the boat)

    public CollisionChecker(Terrain terrain, LinkedList<ImmovableGameObject> staticGOCollision) {
        this.terrain = terrain;
        this.staticGOCollision = staticGOCollision;
    }

    /**
     * Checks collision with the objects in the scenario
     * If the game object is ammo grab it and increments the ammo counter of the player
     * If it is the boat it will invert the collision system and enter the boat
     *
     * @param player Player
     * @param gameObjects Objects which the player can interact with
     */
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

    /**
     * Checks when the bullets collide with enemies and bunkers
     *
     * @param player Player
     * @param bullets The bullets instantiated in the game
     * @param enemies Enemies
     * @param staticGOCollision The static objects which takes health from the player
     */
    public void bulletsCollision(Player player, LinkedList<Bullet> bullets, LinkedList<Enemy> enemies, LinkedList<ImmovableGameObject> staticGOCollision) {

        Iterator<Bullet> bulletsIterator = bullets.iterator();
        Iterator<Enemy> enemyIterator;
        Iterator<ImmovableGameObject> staticGOIterator;

        int playerCenterX = player.getX() + Math.round(player.getWidth() / 2);
        int playerCenterY = player.getY() + Math.round(player.getHeight() / 2);

        while (bulletsIterator.hasNext()) {
            Bullet bullet = bulletsIterator.next();

            enemyIterator = enemies.iterator();
            staticGOIterator = staticGOCollision.iterator();

            boolean bulletHit = false; // When the bullet is removed by collision, not to be accessed again

            int bulletCenterX = bullet.getX() + Math.round(bullet.getWidth() / 2);
            int bulletCenterY = bullet.getY() + Math.round(bullet.getHeight() / 2);

            // Collision between player and bullet
            if(Math.sqrt(Math.abs(bulletCenterX - playerCenterX) * Math.abs(bulletCenterX - playerCenterX) +
                    Math.abs(bulletCenterY - playerCenterY) * Math.abs(bulletCenterY - playerCenterY)) < 15 + 1) {
                player.giveDamage(10);
                bullet.getRepresentation().delete();
                bulletsIterator.remove();

                bulletHit = true;
            }

            // Collision with the barbedwire
            if (!bulletHit) {
                while (staticGOIterator.hasNext()) {
                    ImmovableGameObject immovableGameObject = staticGOIterator.next();

                    if (immovableGameObject.getGot() == GameObjectType.BUNKER) {

                        if ((bulletCenterX >= immovableGameObject.getX() && bulletCenterX <= immovableGameObject.getX() + immovableGameObject.getWidth()) &&
                                (bulletCenterY >= immovableGameObject.getY() && bulletCenterY <= immovableGameObject.getY() + immovableGameObject.getHeight())) {

                            bullet.getRepresentation().delete();
                            bulletsIterator.remove();
                            bulletHit = true;

                            break;
                        }
                    }
                }
            }

            // Collision with the enemies
            if(!bulletHit) {
                while (enemyIterator.hasNext()) {
                    Enemy enemy = enemyIterator.next();

                    int enemyCenterX = enemy.getX() + Math.round(enemy.getWidth() / 2);
                    int enemyCenterY = enemy.getY() + Math.round(enemy.getHeight() / 2);

                    if (Math.sqrt(Math.abs(bulletCenterX - enemyCenterX) * Math.abs(bulletCenterX - enemyCenterX) +
                            Math.abs(bulletCenterY - enemyCenterY) * Math.abs(bulletCenterY - enemyCenterY)) < 15 + 1) {
                        enemy.giveDamage(10);
                        bullet.getRepresentation().delete();
                        bulletsIterator.remove();

                        if (enemy.isDead()) {
                            if(enemy.getType()== EnemyType.CAPTAIN) {
                                enemy.getRepresentation().load("resources/enemy_sprites/captain_dead.png");
                            } else if (enemy.getType()== EnemyType.SOLDIER) {
                                enemy.getRepresentation().load("resources/enemy_sprites/soldier_dead.png");
                            }
                            enemyIterator.remove();
                        }

                        break;
                    }
                }
            }

        }
    }

    /**
     * Restricts where the player can go to or against with
     *
     * @param gameObject Game object that we want to move
     * @param dx X delta movement
     * @param dy Y delta movement
     * @return If the game object can move
     */
    public boolean isBetweenEdges(GameObject gameObject, int dx, int dy) {

        int goXWidth = gameObject.getX() + gameObject.getWidth();
        int goX = gameObject.getX();
        int goY = gameObject.getY();
        int goYHeight = gameObject.getY() + gameObject.getHeight();

        Iterator<ImmovableGameObject> staticObjectIterator = staticGOCollision.iterator();

        if (gameObject instanceof Player){

            int playerCenterX = gameObject.getX() + Math.round(gameObject.getWidth() / 2);
            int playerCenterY = gameObject.getY() + Math.round(gameObject.getHeight() / 2);

            while (staticObjectIterator.hasNext()) {

                GameObject go = staticObjectIterator.next();

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

        return goX + dx >= 0 && goXWidth + dx <= terrain.getWidth()
                && goY + dy >= 0 && goYHeight + dy <= terrain.getHeight() ;

    }

}
