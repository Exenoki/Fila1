package org.academia.gta;

import org.academia.gta.people.Player;
import org.academia.gta.position.GridType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public class tester {
    public static void main(String[] args) {

        Game mygame = new Game(GridType.SIMPLEGFX,950,600,200);
        mygame.init();

        Player player = new Player(100, 100);

        Picture picture = new Picture(player.getX(), player.getY(), "resources/game_sprites/dirt_ground.png");
        picture.draw();

    }
}
