package org.academia.gta.simplegfx;

import org.academia.gta.representation.Representable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 26/05/16.
 */
public abstract class SGFXRepresentation implements Representable {

    public Picture shape;
    private int x;
    private int y;

    public SGFXRepresentation(Picture shape) {
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
    public void delete() {
        shape.delete();
    }

    @Override
    public void draw() {
        shape.draw();
    }

    @Override
    public void translate(int x, int y) {
        shape.translate(x , y);
    }
}