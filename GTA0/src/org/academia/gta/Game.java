package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObjectFactory;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.simplegfx.PropsGenerator;
import org.academia.gta.position.Grid;
import org.academia.gta.position.GridFactory;
import org.academia.gta.position.GridType;
import org.academia.gta.simplegfx.SGFXRepresentationFactory;
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

    Game(GridType gridType, int width, int height, int delay) {

        grid = GridFactory.makeGrid(gridType, width, height);
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

        propsGenerator.propGenerator(this.grid, amo, GameObjectType.AMMO);
        propsGenerator.propGenerator(this.grid, tree, GameObjectType.TREE);

        Player player = (Player) gameObjectFactory.createObject(100, 100, GameObjectType.PLAYER);

        while (true) {
            Thread.sleep(25);

            player.reload();
            Bullet b = player.shoot();

            if(b != null)
                bulletsInstantiated.add(b);

            moveBullets();
            player.move();
        }


    }

    public void moveBullets() {
        Iterator it = bulletsInstantiated.iterator();

        while (it.hasNext()) {
            Bullet b = ((Bullet) it.next());

            b.move();

            if(b.getX() > grid.getWidth() || b.getY() > grid.getHeight() ||
                    b.getX() < 0 || b.getY() < 0) {
                it.remove();
            }
        }

    }

}
