package org.academia.gta;

import org.academia.gta.gameobject.GameObject;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grabbable {

    boolean isGrabbed();

    void pickedBy(GameObject go);

}
