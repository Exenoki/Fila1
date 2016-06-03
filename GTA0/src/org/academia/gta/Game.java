package org.academia.gta;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.Bullet;
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

    }

    LinkedList<Bullet> bulletsInstantiated = new LinkedList<>();

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init(int tree, int amo) throws InterruptedException {

        GameObjectFactory gameObjectFactory = new GameObjectFactory(new SGFXRepresentationFactory());


        propsGenerator = new PropsGenerator();

        grid.init(width,height);

        Picture bridge = new Picture(595,320,"resources/game_sprites/bridge_complete.png");
        bridge.draw();

        Picture boat = new Picture(615,120,"resources/game_sprites/boat.png");
        boat.draw();

        propsGenerator.ammoGenerator(this.grid, amo);
        propsGenerator.treeGenerator(this.grid, tree);

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
