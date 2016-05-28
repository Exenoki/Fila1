package org.academia.gta.representation;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

/**
 * Created by codecadet on 28/05/16.
 */
public class BulletSGFX extends SGFXRepresentation {

    public BulletSGFX() {

        this.shape = new Rectangle(0 - Math.floor(getWidth()/2), 0 - Math.floor(getHeight()/2), 3, 3); //Trocar 0, 0 para as posiçoes na grid

    }

}
