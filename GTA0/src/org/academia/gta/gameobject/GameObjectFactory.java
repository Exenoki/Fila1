package org.academia.gta.gameobject;

import org.academia.gta.gameobject.people.Enemy;
import org.academia.gta.gameobject.people.Player;
import org.academia.gta.representation.MovableRepresentable;
import org.academia.gta.representation.Representable;
import org.academia.gta.representation.RepresentableFactory;

/**
 * Created by codecadet on 30/05/16.
 */
public class GameObjectFactory {

    private RepresentableFactory factory;

    public GameObjectFactory(RepresentableFactory factory) {
        this.factory = factory;
    }

    public GameObject createObject(int x, int y, GameObjectType got) {

        GameObject gameObject = null;

        switch (got) {

            case PLAYER:
                gameObject = new Player((MovableRepresentable) factory.createRepresentation(x, y, got));
                break;

            case ENEMY:
                gameObject = new Enemy((Representable) factory.createRepresentation(x, y, got));
                break;

            case AMMO:
                gameObject = new Ammo((Representable) factory.createRepresentation(x, y, got));
                break;

            case BARBEDWIRE:
                gameObject = new BarbedWire((Representable) factory.createRepresentation(x, y, got));
                break;

            case BULLET:
                gameObject = new Bullet((MovableRepresentable) factory.createRepresentation(x, y, got));
                break;

            case TOWER:
                gameObject = new Tower((Representable) factory.createRepresentation(x, y, got));
                break;

            case TREE:
                gameObject = new Tree((Representable) factory.createRepresentation(x, y, got));
                break;

            case WALL:
                gameObject = new Wall((Representable) factory.createRepresentation(x, y, got));
                break;

            case WEAPON:
                gameObject = new Weapon((Representable) factory.createRepresentation(x, y, got));


        }

        return gameObject;

    }

}