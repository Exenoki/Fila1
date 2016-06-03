package org.academia.gta.gameobject;

import org.academia.gta.representation.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 24/05/16.
 */
public abstract class GameObject {

    private int radius;
    private Representable representation;
    private GameObjectType got;

    public Representable getRepresentation() {
        return representation;
    }

    public GameObject(Representable representation, GameObjectType got) {
        this.representation = representation;
        this.got = got;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public GameObjectType getGot() {
        return got;
    }

    public int getX() {
        return getRepresentation().getX();
    }

    public int getY() {
        return getRepresentation().getY();
    }

    public int getWidth() {
        return getRepresentation().getWidth();
    }

    public int getHeight() {
        return getRepresentation().getHeight();
    }

}
