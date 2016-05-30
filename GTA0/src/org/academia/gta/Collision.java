package org.academia.gta;

import org.academia.gta.people.Person;

/**
 * Created by codecadet on 24/05/16.
 */
public class Collision {

<<<<<<< HEAD
    public boolean merge(GameObject objA, GameObject objB) {

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

                        if (((Person)objA).)
                        ((Grabbable)objB).pickedBy(objA);
                        ((Grabbable)objB).erase();

                    }

                }

                break;

        }

    }
=======
//    public boolean merge(GameObject objA, GameObject objB) {
//        GameObjectType obj;
//        switch (objA.getGameObjectType()) {
//            case PERSON:
//
//                if (objB instanceof Person) {
//
//                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {
//
//                        obj
//
//                    }
//
//                }
//
//                if (objB instanceof Bullet) {
//
//                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {
//
//                        ((Bullet)objB).setDestroyed();
//                        ((Person)objA).takeDamage(((Bullet)objB).hit());
//
//                        if (((Person)objA).getHealth() <= 0) {
//                            ((Person)objA).setHealth(0);
//                            ((Person)objA).setDestroyed();
//                            //drop dead on the floor animation
//
//                        }
//
//                    }
//
//                }
//
//                if (objB instanceof Grabbable) {
//
//                    if (Math.sqrt(Math.abs(objA.getX() - objB.getX())^2 + Math.abs(objA.getY() - objB.getY())^2) < objA.getRadius() + objB.getRadius()) {
//
//                        ((Grabbable)objB).pickedBy(objA);
//                        ((Grabbable)objB).erase();
//
//                    }
//
//                }
//
//                break;
//
//        }
//
//    }
>>>>>>> 229bb9b30c73d7b64275f6a120c2a3b490556b4f

}
