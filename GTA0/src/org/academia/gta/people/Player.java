package org.academia.gta.people;

import org.academia.gta.GameObjectType;

/**
 * Created by codecadet on 24/05/16.
 */
public class Player extends Person {

    public Player(int x, int y) {
        super(x, y);
        this.setGameObjectType(GameObjectType.PLAYER);
    }
}
