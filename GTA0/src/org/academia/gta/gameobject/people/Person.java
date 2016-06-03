package org.academia.gta.gameobject.people;

import org.academia.gta.Destructable;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.GameObjectType;
import org.academia.gta.representation.Representable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 01/06/16.
 */
public abstract class Person extends GameObject implements Destructable {

    private int health;

    public Person(Representable representation) {
        super(representation, GameObjectType.PLAYER);
        setRadius(10); // TODO remove hard coding radius person
        health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void giveDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

}
