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
    private MouseControl mouse;

    /**
     * Animation delay
     */
    private int delay;

    private int width;
    private int height;
    private Player player;
    private SoundFx startMusic = new SoundFx();
    private boolean initGame = false;

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


        startMusic.playSound("resources/soundfx/bgmusic.wav");

        while (true) {

            if (mouse.getMouseXmove() > 370 && mouse.getMouseXmove() < 570 &&
                    mouse.getMouseYmove() > 400 && mouse.getMouseYmove() < 480) {
                start.delete();
                mouseOver.draw();
                if (mouse.getMouseXclicked() > 370 && mouse.getMouseXclicked() < 570 &&
                        mouse.getMouseYclicked() > 400 && mouse.getMouseYclicked() < 480) {
                    initGame = true;
                    init(13, 7);
                    break;
                }
            } else {
                mouseOver.delete();
                start.draw();
            }
        }



    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init(int tree, int amo) throws InterruptedException {

        if(initGame) {
            GameObjectFactory gameObjectFactory = new GameObjectFactory(new SGFXRepresentationFactory());
            HeadsUpDisplay myHud = new HeadsUpDisplay();

            propsGenerator = new PropsGenerator();

            grid.init(width, height);

            propsGenerator.ammoGenerator(this.grid, amo);
            propsGenerator.treeGenerator(this.grid, tree);

            propsGenerator.getAmmoArray(gameObjectInstantiated);

            ImmovableGOSGFX boat = new ImmovableGOSGFX(600, 120, GameObjectType.BOAT);
            gameObjectInstantiated.add(boat);

            ImmovableGameObject bardedwire = new ImmovableGameObject(new ImmovableGOSGFX(100, 400, GameObjectType.BARBEDWIRE), GameObjectType.BARBEDWIRE);
            ImmovableGameObject bardedwire1 = new ImmovableGameObject(new ImmovableGOSGFX(200, 300, GameObjectType.BARBEDWIRE), GameObjectType.BARBEDWIRE);
            ImmovableGameObject bardedwire2 = new ImmovableGameObject(new ImmovableGOSGFX(bardedwire1.getX() + bardedwire1.getWidth(), 300, GameObjectType.BARBEDWIRE), GameObjectType.BARBEDWIRE);
            ImmovableGameObject bardedwire3 = new ImmovableGameObject(new ImmovableGOSGFX(300, 400, GameObjectType.BARBEDWIRE), GameObjectType.BARBEDWIRE);
            ImmovableGameObject bunker = new ImmovableGameObject(new ImmovableGOSGFX(580, 320, GameObjectType.BUNKER), GameObjectType.BUNKER);
            ImmovableGameObject bunker2 = new ImmovableGameObject(new ImmovableGOSGFX(bunker.getX(), bunker.getY() + bunker.getHeight() - 10, GameObjectType.BUNKER), GameObjectType.BUNKER);
            ImmovableGameObject bridge = new ImmovableGameObject(new ImmovableGOSGFX(595, 320, GameObjectType.BRIDGE), GameObjectType.BRIDGE);

            staticGOCollision.add(bardedwire);
            staticGOCollision.add(bardedwire1);
            staticGOCollision.add(bardedwire2);
            staticGOCollision.add(bardedwire3);
            staticGOCollision.add(bunker);
            staticGOCollision.add(bunker2);
            staticGOCollision.add(bridge);

            // Add enemies in the game
            enemiesInstantiated.add(new Enemy(new EnemySGFX(650, 350, Direction.RIGHT), Direction.RIGHT));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(650, 400, Direction.RIGHT), Direction.RIGHT));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(900, 50, Direction.DOWN), Direction.DOWN));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(550, 120, Direction.LEFT), Direction.LEFT));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(250, 50, Direction.DOWN), Direction.DOWN));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(150, 250, Direction.DOWN), Direction.DOWN));
            enemiesInstantiated.add(new Enemy(new EnemySGFX(370, 350, Direction.DOWN), Direction.DOWN));

            CollisionChecker collisionChecker = new CollisionChecker(grid, staticGOCollision);
            player = (Player) gameObjectFactory.createObject(100, 500, GameObjectType.PLAYER, collisionChecker);

            while (true) {
                Thread.sleep(25);
                player.reload();
                Bullet b = player.shoot();

                if (b != null)
                    bulletsInstantiated.add(b);

                enemyShootRound(bulletsInstantiated);

                moveBullets();
                player.move();

                collisionChecker.bulletsCollision(player, bulletsInstantiated, enemiesInstantiated, staticGOCollision);
                collisionChecker.scenarioCollisions(player, gameObjectInstantiated);

                myHud.hud(player.getHealth());
                myHud.getHudAmmo().setText(player.getTotalAmmo() + "");
                myHud.getHudBullets().setText(player.getNumBullets() + "");

                propsGenerator.reDraw();

                if (player.isDestroyed()) {
                    initGame = false;
                    player.getRepresentation().load("resources/player_sprites/rambo_dead.png");
                    startMusic.getBgmusic().stop();
                    break;
                }
            }
        }

        Picture gameOver = new Picture(0,0,"resources/game_sprites/gameover.png");
        gameOver.draw();
        startMusic.playSound("resources/soundfx/stalloneyells.wav");

    }

    public void enemyShootRound(LinkedList<Bullet> bulletsInstantiate) {
        Iterator enemyInterator = enemiesInstantiated.iterator();

        while (enemyInterator.hasNext()) {
            Bullet bullet = ((Enemy) enemyInterator.next()).shoot(player);

            if(bullet != null)
                bulletsInstantiate.add(bullet);
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