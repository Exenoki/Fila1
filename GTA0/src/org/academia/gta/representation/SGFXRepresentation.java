package org.academia.gta.representation;

import org.academia.gta.GameObject;
import org.academia.gta.GameObjectType;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.awt.*;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SGFXRepresentation implements Representable {

    public Shape shape;
    private int x;
    private int y;

    public SGFXRepresentation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void draw() {
        this.shape.draw();
    }

    @Override
    public void delete() {
        this.shape.delete();
    }
    
}