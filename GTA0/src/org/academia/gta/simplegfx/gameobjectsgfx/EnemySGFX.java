package org.academia.gta.simplegfx.gameobjectsgfx;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.people.EnemyType;
import org.academia.gta.simplegfx.SGFXRepresentation;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 28/05/16.
 */
public class EnemySGFX extends SGFXRepresentation {

    public EnemySGFX(int x, int y, Direction dir, EnemyType type) {
        super(new Picture(x, y, "resources/enemy_sprites/captain_u.png"));

        this.delete();

        switch (type) {
            case CAPTAIN:
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
                break;

            case SOLDIER:
                switch (dir) {
                    case UP:
                        this.setShape(new Picture(x, y, "resources/enemy_sprites/soldier_u.png"));
                        break;

                    case DOWN:
                        this.setShape(new Picture(x, y, "resources/enemy_sprites/soldier_d.png"));
                        break;

                    case LEFT:
                        this.setShape(new Picture(x, y, "resources/enemy_sprites/soldier_l.png"));
                        break;

                    case RIGHT:
                        this.setShape(new Picture(x, y, "resources/enemy_sprites/soldier_r.png"));
                        break;
                }
                break;
        }

        this.draw();
    }

}
