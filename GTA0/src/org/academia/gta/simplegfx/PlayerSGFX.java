package org.academia.gta.simplegfx;

import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class PlayerSGFX extends SGFXRepresentation {

    //TODO Esperar por posiçao na grid para implementar coordenadas

    public PlayerSGFX(int x, int y) {
        super(new Picture(x, y, "url"));
    }

}
