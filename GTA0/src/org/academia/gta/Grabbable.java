package org.academia.gta;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grabbable {

    boolean isGrabbed();

    void pickedBy(GameObject go);

    void erase();

}
