package org.academia.gta.gameobject.people;

import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.Representable;

/**
 * Sets general attributes and behaviors for all "human" objects in the game
 *
 *
 * Created by codecadet on 01/06/16.
 */
public abstract class Person extends GameObject {

    private int health = 100;

    public Person(Representable representation) {
        super(representation, GameObjectType.PLAYER);
        setRadius(10); // TODO remove hard coding radius person
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    } //

    public boolean isDead() {
        return health <= 0;
    }

}
