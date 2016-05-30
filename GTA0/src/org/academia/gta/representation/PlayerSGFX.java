package org.academia.gta.representation;

import org.academia.gta.people.Player;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

/**
 * Created by codecadet on 28/05/16.
 */
public class PlayerSGFX extends SGFXRepresentation {

    //TODO Esperar por posiçao na grid para implementar coordenadas

    public PlayerSGFX(int x, int y) {
        super(x,y);
        this.shape = new Picture(x - Math.floor(shape.getWidth()/2), y - Math.floor(shape.getHeight()/2), /* url */); //TODO aplicar coordenadas
    }

}
