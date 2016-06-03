package org.academia.gta.simplegfx;

import org.academia.gta.gameobject.GameObjectFactory;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.representation.Representable;
import org.academia.gta.representation.RepresentableFactory;

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
                representable = new EnemySGFX(x, y);
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

            case TOWER:
                representable = new ImmovableGOSGFX(x, y, GameObjectType.TOWER);
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
