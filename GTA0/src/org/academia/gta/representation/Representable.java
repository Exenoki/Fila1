package org.academia.gta.representation;

import org.academia.gta.GameObject;
import org.academia.gta.GameObjectType;

/**
 * Created by codecadet on 24/05/16.
 */
public interface Representable {

    int getX();
    int getY();
    void draw();
    void delete();
    void merge(GameObject obj);


}
