package org.academia.gta.simplegfx;

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
                representable = new AmmoSGFX(x, y);
                break;

            case BARBEDWIRE:
                representable = new BarbedWireSGFX(x, y);
                break;

            case BULLET:
                representable = new BulletSGFX(x, y);
                break;

            case TREE:
                representable = new TreeSGFX(x, y);
                break;

            case TOWER:
                representable = new TowerSGFX(x, y);
                break;

            case WALL:
                representable = new WallSGFX(x, y);
                break;

            case WEAPON:
                representable = new WeaponSGFX(x, y);

        }

        return representable;

    }
}
