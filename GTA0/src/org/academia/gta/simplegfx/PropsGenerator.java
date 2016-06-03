package org.academia.gta.simplegfx;

import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 30/05/16.
 */
public class PropsGenerator {

    private boolean isLoaded = false;
    private Grid grid;

    ImmovableGameObject[] treeArray;
    ImmovableGameObject[] ammoArray;

    private int randomXPos(){
        return (int)Math.round(Math.random()*grid.getWidth()) ;
    }

    private int randomYPos(){
        return (int)Math.round(Math.random()*grid.getHeight()) ;
    }

    public void treeGenerator(Grid grid, int qt){
        this.grid = grid;
        treeArray = new ImmovableGameObject[qt];

        for (int i=0; i<qt; i++){
            int x = randomXPos();
            int y = randomYPos();
            while (x>=520 && x<=860){
                x = randomXPos();
            }
            ImmovableGameObject newTree = new ImmovableGameObject(new ImmovableGOSGFX(x, y, GameObjectType.TREE), GameObjectType.TREE);
            treeArray[i] = newTree;

            if (newTree.getX() + newTree.getWidth() >= grid.getWidth()) {
                newTree.getRepresentation().translate(grid.getWidth() - (newTree.getX() + newTree.getWidth()), 0);
            }
            if (newTree.getY() + newTree.getHeight() >= grid.getHeight()) {
                newTree.getRepresentation().translate(0, grid.getHeight() - (newTree.getY() + newTree.getHeight()));
            }

        }
    }

    public void ammoGenerator(Grid grid, int qt){
        this.grid = grid;
        ammoArray = new ImmovableGameObject[qt];

        for (int i=0; i<qt; i++){
            int x = randomXPos();
            int y = randomYPos();
            while (x>=520 && x<=860){
                x = randomXPos();
            }

            ImmovableGameObject newAmo = new ImmovableGameObject(new ImmovableGOSGFX(x, y, GameObjectType.AMMO), GameObjectType.AMMO);

            ammoArray[i] = newAmo;

            if (newAmo.getX() + newAmo.getWidth() >= grid.getWidth()) {
                newAmo.getRepresentation().translate(grid.getWidth() - (newAmo.getX() + newAmo.getWidth()), 0);
            }
            if (newAmo.getY() + newAmo.getHeight() >= grid.getHeight()) {
                newAmo.getRepresentation().translate(0, grid.getHeight() - (newAmo.getY() + newAmo.getHeight()));
            }

        }
    }

    public LinkedList getAmmoArray(LinkedList<GameObject> objectsList) {

        for (ImmovableGameObject igo : ammoArray) {
            objectsList.add(igo);
        }

        return objectsList;
    }

    public void reDraw() {
        if(!isLoaded) {
            for (ImmovableGameObject tree : treeArray) {
                tree.getRepresentation().delete();
                tree.getRepresentation().draw();
            }
        }
        isLoaded = true;
    }

}
