package org.academia.gta.simplegfx;

import org.academia.gta.representation.Representable;
import org.academiadecodigo.simplegraphics.graphics.Shape;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SGFXRepresentation implements Representable {

    public Shape shape;
    private int x;
    private int y;

    public SGFXRepresentation(Shape shape) {
        this.shape = shape;
        shape.draw();
    }

    public Shape getShape() {
        return shape;
    }

    @Override
    public int getWidth() {
        return getShape().getWidth();
    }

    @Override
    public int getHeight() {
        return getShape().getHeight();
    }

    @Override
    public int getX() {
        return shape.getX();
    }

    @Override
    public int getY() {
        return shape.getY();
    }

    @Override
    public void merge() {

    }
}