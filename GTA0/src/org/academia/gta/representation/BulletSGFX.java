package org.academia.gta.representation;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

/**
 * Created by codecadet on 28/05/16.
 */
public class BulletSGFX extends SGFXRepresentation {

    public BulletSGFX(int x, int y) {
        super(x,y);
        this.shape = new Rectangle(x - Math.floor(shape.getWidth()/2), y - Math.floor(shape.getHeight()/2), 3, 3); //Trocar 0, 0 para as posiçoes na grid

    }

}
