package org.academia.gta.gameobject;

import org.academia.gta.Collision;
import org.academia.gta.Game;
import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public abstract class GameObject implements Representable {

    private Representable representation;

    public Representable getRepresentation() {
        return representation;
    }

    public GameObject(Representable representation) {
        this.representation = representation;
    }

    /*private Collision collision;
    private int radius;
    private GameObjectType gameObjectType;
    private int x;
    private int y;
    private Representable representation;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCollision(Collision collision) {
        this.collision = collision;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public GameObjectType getGameObjectType() {
        return gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = gameObjectType;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Representable getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representable representation) {
        this.representation = representation;
    }*/
}
