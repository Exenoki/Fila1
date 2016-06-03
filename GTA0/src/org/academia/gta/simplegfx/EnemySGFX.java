package org.academia.gta.simplegfx;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class EnemySGFX extends SGFXRepresentation {

    public EnemySGFX(int x, int y, Direction dir) {
        super(new Picture(x, y, "resources/enemy_sprites/captain_u.png"));

        this.delete();

        switch (dir) {
            case UP:
                this.setShape(new Picture(x, y, "resources/enemy_sprites/captain_u.png"));
                break;

            case DOWN:
                this.setShape(new Picture(x, y, "resources/enemy_sprites/captain_d.png"));
                break;

            case LEFT:
                this.setShape(new Picture(x, y, "resources/enemy_sprites/captain_l.png"));
                break;

            case RIGHT:
                this.setShape(new Picture(x, y, "resources/enemy_sprites/captain_r.png"));
                break;

        }

        this.draw();
    }

}
