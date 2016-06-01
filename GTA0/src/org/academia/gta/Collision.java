package org.academia.gta;

import org.academia.gta.gameobject.Bullet;
import org.academia.gta.gameobject.GameObject;
import org.academia.gta.gameobject.people.Person;

/**
 * Created by codecadet on 24/05/16.
 */
public class Collision {
    /*public boolean merge(GameObject objA, GameObject objB) {

        switch (objA.getGameObjectType()) {
            case PERSON:

                if (objB instanceof Person) {

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {


                    }

                }

                if (objB instanceof Bullet) {

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {

                        ((Bullet)objB).setDestroyed();
                        ((Person)objA).takeDamage(((Bullet)objB).hit());

                        if (((Person)objA).getHealth() <= 0) {
                            ((Person)objA).setHealth(0);
                            ((Person)objA).setDestroyed();
                            //drop dead on the floor animation

                        }

                    }

                }

                if (objB instanceof Grabbable) {

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {

                        ((Grabbable)objB).pickedBy(objA);

                    }

                }

                break;

        }
        return true;

    }*/

}
