package org.academia.gta.people;

import org.academia.gta.GameObjectType;

/**
 * Created by codecadet on 24/05/16.
 */
public class Enemy extends Person {

    public Enemy(int x, int y) {
        super(x, y);
        this.setGameObjectType(GameObjectType.ENEMY);

    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return 0;
    }
}
