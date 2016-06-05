package org.academia.gta.simplegfx.terrainsgfx;

import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academia.gta.simplegfx.gameobjectsgfx.ImmovableGOSGFX;
import org.academia.gta.simplegfx.terrainsgfx.Terrain;

import java.util.LinkedList;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 30/05/16.
 */
public class PropsGenerator {

    private boolean isLoaded = false;
    private Terrain terrain;

    ImmovableGameObject[] treeArray;
    ImmovableGameObject[] ammoArray;

    private int randomXPos(){
        return (int)Math.round(Math.random()* terrain.getWidth()) ;
    }

    private int randomYPos(){
        return (int)Math.round(Math.random()* terrain.getHeight()) ;
    }

    public void treeGenerator(Terrain terrain, int qt){
        this.terrain = terrain;
        treeArray = new ImmovableGameObject[qt];

        for (int i=0; i<qt; i++){
            int x = randomXPos();
            int y = randomYPos();
            while (x>=520 && x<=860){
                x = randomXPos();
            }

            if(x + 164 > terrain.getWidth())
                x = terrain.getWidth() - 164;

            if(y + 164 > terrain.getHeight())
                y = terrain.getHeight() - 164;

            ImmovableGameObject newTree = new ImmovableGameObject(new ImmovableGOSGFX(x, y, GameObjectType.TREE), GameObjectType.TREE);
            treeArray[i] = newTree;

        }
    }

    public void ammoGenerator(Terrain terrain, int qt){
        this.terrain = terrain;
        ammoArray = new ImmovableGameObject[qt];

        for (int i=0; i<qt; i++){
            int x = randomXPos();
            int y = randomYPos();
            while (x>=520 && x<=860){
                x = randomXPos();
            }

            ImmovableGameObject newAmo = new ImmovableGameObject(new ImmovableGOSGFX(x, y, GameObjectType.AMMO), GameObjectType.AMMO);

            ammoArray[i] = newAmo;

            if (newAmo.getX() + newAmo.getWidth() >= terrain.getWidth()) {
                newAmo.getRepresentation().translate(terrain.getWidth() - (newAmo.getX() + newAmo.getWidth()), 0);
            }
            if (newAmo.getY() + newAmo.getHeight() >= terrain.getHeight()) {
                newAmo.getRepresentation().translate(0, terrain.getHeight() - (newAmo.getY() + newAmo.getHeight()));
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
