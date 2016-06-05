package org.academia.gta.representation;

/**
 * Created by codecadet on 30/05/16.
 *
 * Interface for the movable game objects
 */
public interface MovableRepresentable extends Representable {

    void move(int dx, int dy);

}
