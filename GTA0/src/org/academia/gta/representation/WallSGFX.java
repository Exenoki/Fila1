package org.academia.gta.representation;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 29/05/16.
 */
public class WallSGFX extends SGFXRepresentation {

    public WallSGFX(int x, int y) {
        super(x, y);
        this.shape = new Picture(x, y, /* url */);
    }
}
