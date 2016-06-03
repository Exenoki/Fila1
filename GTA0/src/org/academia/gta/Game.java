package org.academia.gta;

import org.academia.gta.controls.Direction;
import org.academia.gta.controls.PlayerControls;
import org.academia.gta.controls.MouseControl;
import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectFactory;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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


    Game(int width, int height, int delay) {

        grid = new SimpleGfxGrid();
        this.delay = delay;
        this.width = width;
        this.height = height;
        mouse = new MouseControl();

    }

    LinkedList<Bullet> bulletsInstantiated = new LinkedList<>();
    LinkedList<GameObject> gameObjectInstantiated = new LinkedList<>();

    public void start() throws InterruptedException {
        Picture background = new Picture(0, 0, "resources/background_gta_rambo_start2.jpg");
        Picture logo = new Picture(225, 100, "resources/gta_rambo_logo.png");
        Picture start = new Picture(370, 400, "resources/bt_start_normal.png");
        Picture mouseOver = new Picture(370, 400, "resources/bt_start_over.png");

        background.draw();
        logo.draw();
        start.draw();

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
        CollisionChecker collisionChecker = new CollisionChecker();

        propsGenerator = new PropsGenerator();

        grid.init(width,height);

        Picture bridge = new Picture(595,320,"resources/game_sprites/bridge_complete.png");
        bridge.draw();

        Picture boat = new Picture(615,120,"resources/game_sprites/boat.png");
        boat.draw();

        propsGenerator.ammoGenerator(this.grid, amo);
        propsGenerator.treeGenerator(this.grid, tree);

        propsGenerator.getAmmoArray(gameObjectInstantiated);

        Player player = (Player) gameObjectFactory.createObject(100, 100, GameObjectType.PLAYER);
        Enemy enemy = new Enemy(new EnemySGFX(200, 200), Direction.UP);

        while (true) {
            Thread.sleep(25);
            player.reload();
            Bullet b = player.shoot();
            Bullet b2 = enemy.shoot(player);

            if(b != null)
                bulletsInstantiated.add(b);

            if(b2 != null)
                bulletsInstantiated.add(b2);

            moveBullets();
            player.move();

            collisionChecker.checkCollision(player, gameObjectInstantiated, bulletsInstantiated);

            propsGenerator.reDraw();
        }
    }

    public void moveBullets() {
        Iterator it = bulletsInstantiated.iterator();

        while (it.hasNext()) {
            Bullet b = ((Bullet) it.next());

            b.move();

            if(b.getX() > grid.getWidth() || b.getY() > grid.getHeight() ||
                    b.getX() < 0 || b.getY() < 0) {
                b.getRepresentation().delete();
                it.remove();
            }
        }

    }

}
