package org.academia.gta.representation;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 24/05/16.
 */
public interface Representable {

    int getX();

    int getY();

    int getWidth();

    int getHeight();

    void draw();

    void delete();

    void translate(int dx, int dy);

    void setShape(Picture picture);

    void load (String s);

}
