package org.academia.gta.simplegfx.terrainsgfx;

import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.ImmovableGameObject;
import org.academia.gta.simplegfx.gameobjectsgfx.ImmovableGOSGFX;
import org.academia.gta.simplegfx.terrainsgfx.Terrain;

import java.util.LinkedList;

/**
 * Created by codecadet on 26/05/16.
 * This class is responsible for producing and placing the props (scenario objects).
 */
public class PropsGenerator {

    private boolean isLoaded = false; //Checks if the objects are loaded and
    private Terrain terrain;

    ImmovableGameObject[] treeArray;
    ImmovableGameObject[] ammoArray;

    /**
     * Generates a random X position
     * @return
     */
    private int randomXPos(){
        return (int)Math.round(Math.random()* terrain.getWidth()) ;
    }

    /**
     * Generates a random Y position
     * @return
     */
    private int randomYPos(){
        return (int)Math.round(Math.random()* terrain.getHeight()) ;
    }

    /**
     * This method is responsible for generating and inserting the trees in an array, with random positions.
     * @param terrain The place (Terrain = Grid) where the trees will be placed.
     * @param qt The quantity of trees that will be created
     */
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

    /**
     * This method is responsible for generating and inserting the Ammo boxes in an array, with random positions.
     * @param terrain The place (Terrain = Grid) where the trees will be placed.
     * @param qt The quantity of Ammo that will be created
     */
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

    /**
     * This method adds each ammo box from the array to a linked list
     * @param objectsList The linked list where the ammo boxes will be added
     * @return Returns the final linked list with objects.
     */
    public LinkedList getAmmoArray(LinkedList<GameObject> objectsList) {

        for (ImmovableGameObject igo : ammoArray) {
            objectsList.add(igo);
        }

        return objectsList;
    }

    /**
     * Draws the trees and ammos to the Terrain (Field or Grid)
     */
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
