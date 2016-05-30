package org.academia.gta.representation;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class WeaponSGFX extends SGFXRepresentation {

    public WeaponSGFX(int x, int y) {
        super(x,y);
        this.shape = new Picture(x - Math.floor(shape.getWidth()/2), y - Math.floor(shape.getHeight()/2), /* url */);

    }
}
