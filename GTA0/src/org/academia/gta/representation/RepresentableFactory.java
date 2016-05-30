package org.academia.gta.representation;

import org.academia.gta.gameobject.GameObjectType;

/**
 * Created by codecadet on 30/05/16.
 */
public interface RepresentableFactory {

    Representable createRepresentation(int x, int y, GameObjectType got);

}
