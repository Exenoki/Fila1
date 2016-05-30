package org.academia.gta.representation;

import org.academia.gta.GameObject;
import org.academia.gta.GameObjectType;

/**
 * Created by codecadet on 26/05/16.
 */
public class SGFXRepresentationFactory {

    public static SGFXRepresentation createRepresentation(GameObjectType got) {

        switch(got) {

            case PLAYER:
                return new PlayerSGFX(x,y);

            case ENEMY:
                return new EnemySGFX(x,y);

            case BULLET:
                return new BulletSGFX(x,y);

            case WEAPON:
                return new WeaponSGFX(x,y);

            case AMMO:
                return new AmmoSGFX(x,y);

        }

        return null;

    }

}
