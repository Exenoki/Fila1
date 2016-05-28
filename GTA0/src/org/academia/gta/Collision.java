package org.academia.gta;

import org.academia.gta.people.Person;

/**
 * Created by codecadet on 24/05/16.
 */

public class Collision {

    public boolean merge(GameObject objA, GameObject objB) {

        GameObjectType obj;

        switch (objA.getGameObjectType()) {

            case PERSON:

                if (objB instanceof Person) {

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {

                        // TODO Person collision with other Person they move one step back

                    }

                    return true;

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

                    return true;

                }

                if (objB instanceof Grabbable) {

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {

                        ((Grabbable)objB).pickedBy(objA);
                        //((Grabbable)objB).erase(); // metodo foi apagado da interface Grabbable

                    }

                    return true;

                }

                break;

            case BULLET:

                if (objB instanceof Building){

                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {

                        ((Bullet)objA).setDestroyed();

                    }

                    return true;

                }

                break;
        }

        return false;

    }

}
