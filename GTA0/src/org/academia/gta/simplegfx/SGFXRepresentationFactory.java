package org.academia.gta.simplegfx;

import org.academia.gta.controls.Direction;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.people.EnemyType;
import org.academia.gta.representation.Representable;
import org.academia.gta.representation.RepresentableFactory;
import org.academia.gta.simplegfx.gameobjectsgfx.BulletSGFX;
import org.academia.gta.simplegfx.gameobjectsgfx.EnemySGFX;
import org.academia.gta.simplegfx.gameobjectsgfx.ImmovableGOSGFX;
import org.academia.gta.simplegfx.gameobjectsgfx.PlayerSGFX;

/**
 * Created by codecadet on 26/05/16.
 */
public class SGFXRepresentationFactory implements RepresentableFactory {

    @Override
    public Representable createRepresentation(int x, int y, GameObjectType got) {

        Representable representable = null;

        switch (got) {

            case PLAYER:
                representable = new PlayerSGFX(x, y);
                break;

            case ENEMY:
                representable = new EnemySGFX(x, y, Direction.NULL, EnemyType.CAPTAIN);
                break;

            case AMMO:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.AMMO);
                break;

            case BARBEDWIRE:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.BARBEDWIRE);
                break;

            case BULLET:
                representable = new BulletSGFX(x, y);
                break;

            case TREE:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.TREE);
                break;

            case WALL:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.WALL);
                break;

            case WEAPON:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.WEAPON);

        }

        return representable;

    }
}
