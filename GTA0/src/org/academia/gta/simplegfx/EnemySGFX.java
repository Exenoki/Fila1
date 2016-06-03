package org.academia.gta.simplegfx;

import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class EnemySGFX extends SGFXRepresentation {

    public EnemySGFX(int x, int y) {
        super(new Picture(x, y, "resources/enemy_sprites/captain_u.png"));
    }
}
