package org.academia.gta.representation;

import org.academia.gta.GameObject;
import org.academia.gta.GameObjectType;

/**
 * Created by codecadet on 26/05/16.
 */
public class SGFXRepresentationFactory {

    public SGFXRepresentation createRepresentation(SGFXRepresentation representation) {

        switch(representation.getGameObjectType()) {

            case PLAYER:
                representation.setShape(new PlayerSGFX());
                break;

            case ENEMY:
                representation.setShape(new EnemySGFX());
                break;

            case BULLET:
                representation.setShape(new BulletSGFX());
                break;

            case WEAPON:
                representation.setShape(new WeaponSGFX());
                break;

            case AMMO:
                representation.setShape(new AmmoSGFX());
                break;
            
        }


    }

}
