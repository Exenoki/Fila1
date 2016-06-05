package org.academia.gta;

import org.academia.gta.controls.Direction;
import org.academia.gta.controls.PlayerControls;
import org.academia.gta.controls.MouseControl;
import org.academia.gta.gameobject.*;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 29/05/16.
 */
public class Game {

    /**
     * Graphical Car field
     */
    private Grid grid;
    private PropsGenerator propsGenerator;
    private PlayerControls playerControls;
    private MouseControl mouse;

    /**
     * Animation delay
     */
    private int delay;

    private int width;
    private int height;
    private Player player;

    Game(int width, int height, int delay) {

        grid = new SimpleGfxGrid();
        this.delay = delay;
        this.width = width;
        this.height = height;
        mouse = new MouseControl();

    }

    LinkedList<Bullet> bulletsInstantiated = new LinkedList<>();
    LinkedList gameObjectInstantiated = new LinkedList<>();
    LinkedList<Enemy> enemiesInstantiated = new LinkedList<>();
    LinkedList<ImmovableGameObject> staticGOCollision = new LinkedList<>();

    public void start() throws InterruptedException {
        Picture background = new Picture(0, 0, "resources/background_gta_rambo_start2.jpg");
        Picture logo = new Picture(225, 100, "resources/gta_rambo_logo.png");
        Picture start = new Picture(370, 400, "resources/bt_start_normal.png");
        Picture mouseOver = new Picture(370, 400, "resources/bt_start_over.png");

        background.draw();
        logo.draw();
        start.draw();

        new SoundFx().playSound();
        while (true) {

            if (mouse.getMouseXmove() > 370 && mouse.getMouseXmove() < 570 &&
                    mouse.getMouseYmove() > 400 && mouse.getMouseYmove() < 480) {
                start.delete();
                mouseOver.draw();
                if (/*playerControls.isShooted() &&*/ mouse.getMouseXclicked() > 370 && mouse.getMouseXclicked() < 570 &&
                        mouse.getMouseYclicked() > 400 && mouse.getMouseYclicked() < 480) {
                    //playerControls.setShooted(false);
                    init(7, 3);
                }
            } else {
                mouseOver.delete();
                start.draw();
            }

//        if(playerControls.getMouseX() > 200 && playerControls.getMouseX() < 300 && playerControls.getMouseY() > 200 && playerControls.getMouseY() < 300) {
//            start.delete();
//            mouseOver.draw();
//        } else {
//            mouseOver.delete();
//            start.draw();
//        }


        }

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init(int tree, int amo) throws InterruptedException {

        GameObjectFactory gameObjectFactory = new GameObjectFactory(new SGFXRepresentationFactory());
        HeadsUpDisplay myHud = new HeadsUpDisplay();

        propsGenerator = new PropsGenerator();

        grid.init(width, height);

        propsGenerator.ammoGenerator(this.grid, amo);
        propsGenerator.treeGenerator(this.grid, tree);

        propsGenerator.getAmmoArray(gameObjectInstantiated);

        ImmovableGOSGFX boat = new ImmovableGOSGFX(600, 120, GameObjectType.BOAT);
        gameObjectInstantiated.add(boat);

        ImmovableGameObject bardedwire = new ImmovableGameObject(new ImmovableGOSGFX(500, 500, GameObjectType.BARBEDWIRE), GameObjectType.BARBEDWIRE);
        ImmovableGameObject bunker = new ImmovableGameObject(new ImmovableGOSGFX(300, 500, GameObjectType.BUNKER), GameObjectType.BUNKER);
        ImmovableGameObject bridge = new ImmovableGameObject(new ImmovableGOSGFX(595, 320, GameObjectType.BRIDGE), GameObjectType.BRIDGE);

        staticGOCollision.add(bardedwire);
        staticGOCollision.add(bunker);
        staticGOCollision.add(bridge);

        enemiesInstantiated.add(new Enemy(new EnemySGFX(200, 200, Direction.UP), Direction.UP));
        enemiesInstantiated.add(new Enemy(new EnemySGFX(400, 100, Direction.DOWN), Direction.DOWN));

        CollisionChecker collisionChecker = new CollisionChecker(grid, staticGOCollision);
        player = (Player) gameObjectFactory.createObject(100, 100, GameObjectType.PLAYER, collisionChecker);

        while (true) {
            Thread.sleep(25);
            player.reload();
            Bullet b = player.shoot();

            if (b != null)
                bulletsInstantiated.add(b);

            enemyShootRound(bulletsInstantiated);

            moveBullets();
            player.move();

            collisionChecker.bulletsCollision(player, bulletsInstantiated, enemiesInstantiated);
            collisionChecker.scenarioCollisions(player, gameObjectInstantiated);

            myHud.hud(player.getHealth());
            myHud.getHudAmmo().setText(player.getTotalAmmo()+"");
            myHud.getHudBullets().setText(player.getNumBullets()+"");

            propsGenerator.reDraw();

            if(player.isDestroyed()) {
                player.getRepresentation().load("resources/player_sprites/rambo_dead.png");
                break;
            }
        }

        System.out.println("Game over");

    }

    public void enemyShootRound(LinkedList<Bullet> bulletsInstantiate) {
        Iterator enemyInterator = enemiesInstantiated.iterator();

        while (enemyInterator.hasNext()) {
            Bullet bullet = ((Enemy) enemyInterator.next()).shoot(player);

            if(bullet != null)
                bulletsInstantiated.add(bullet);
        }
    }

    public void moveBullets() {
        Iterator it = bulletsInstantiated.iterator();

        while (it.hasNext()) {
            Bullet b = ((Bullet) it.next());

            b.move();

            if(b.getX() > grid.getWidth() - (b.getWidth() * 3) || b.getY() > grid.getHeight() - (b.getHeight() * 3) ||
                    b.getX() < 0 || b.getY() < 0) {
                b.getRepresentation().delete();
                it.remove();
            }
        }
    }

}