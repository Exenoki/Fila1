package org.academia.gta.simplegfx;

import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.position.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 30/05/16.
 */
public class PropsGenerator {

    private Grid grid;

    private int randomXPos(){
        return (int)Math.round(Math.random()*grid.getWidth()) ;
    }

    private int randomYPos(){
        return (int)Math.round(Math.random()*grid.getHeight()) ;
    }

    public void propGenerator(Grid grid, int qt, GameObjectType type){
        this.grid = grid;
        for (int i=0; i<=qt; i++){
            int x = randomXPos();
            int y = randomYPos();
            while (x>=520 && x<=860){
                x = randomXPos();
            }
            switch (type) {
                case TREE: //TODO insert created objects inside a container and draw them.
                Picture newTree = new Picture(x, y, "resources/game_sprites/tree.png");

                if (newTree.getX() + newTree.getWidth() >= grid.getWidth()) {
                    newTree.translate(grid.getWidth() - (newTree.getX() + newTree.getWidth()), 0);
                }
                if (newTree.getY() + newTree.getHeight() >= grid.getHeight()) {
                    newTree.translate(0, grid.getHeight() - (newTree.getY() + newTree.getHeight()));
                }
                newTree.draw();
                    break;

                case AMMO: //TODO insert created objects inside a container and draw them.
                    Picture newAmo = new Picture(x, y, "resources/game_sprites/amo.png");

                    if (newAmo.getX() + newAmo.getWidth() >= grid.getWidth()) {
                        newAmo.translate(grid.getWidth() - (newAmo.getX() + newAmo.getWidth()), 0);
                    }
                    if (newAmo.getY() + newAmo.getHeight() >= grid.getHeight()) {
                        newAmo.translate(0, grid.getHeight() - (newAmo.getY() + newAmo.getHeight()));
                    }
                    newAmo.draw();
                    break;
            }

        }
    }



}
