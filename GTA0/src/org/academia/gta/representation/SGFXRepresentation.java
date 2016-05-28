package org.academia.gta.representation;

import org.academia.gta.GameObjectType;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.awt.*;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SGFXRepresentation implements Shape, Representable {

    public GameObjectType gameObjectType;
    public Shape shape;

    @Override
    public int getX() {
        return this.shape.getX();
    }

    @Override
    public int getY() {
        return this.shape.getY();
    }

    @Override
    public int getWidth() {
        return this.shape.getWidth();
    }

    @Override
    public int getHeight() {
        return this.shape.getHeight();
    }

    @Override
    public void draw() {
        this.shape.draw();
    }

    @Override
    public void delete() {
        this.shape.delete();
    }

    @Override
    public void grow(double v, double v1) {
        this.shape.grow(v,v1);
    }

    @Override
    public void paintShape(Graphics2D graphics2D) {
        this.shape.paintShape(graphics2D);
    }

    public GameObjectType getGameObjectType() {
        return gameObjectType;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
