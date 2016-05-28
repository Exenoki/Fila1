package org.academia.gta;

import org.academia.gta.representation.Representable;

/**
 * Created by codecadet on 24/05/16.
 */
public abstract class GameObject {

    private Collision collision;
    private int radius;
    private GameObjectType gameObjectType;
    private int x;
    private int y;
    private Representable representable;

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

}
