package org.academia.gta.representation;

import org.academia.gta.people.Player;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;

import java.awt.*;

/**
 * Created by codecadet on 28/05/16.
 */
public class PlayerSGFX extends SGFXRepresentation {

    //TODO Esperar por posiçao na grid para implementar coordenadas

    public PlayerSGFX() {

        this.shape = new Picture(0, 0, /* url */); //TODO aplicar coordenadas

    }

}
