package org.academia.gta.gameobject;

import org.academia.gta.CollisionChecker;
import org.academia.gta.controls.Direction;
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

    public GameObject createObject(int x, int y, GameObjectType got, CollisionChecker collisionChecker) {

        GameObject gameObject = null;

        switch (got) {

            case PLAYER:
                gameObject = new Player((MovableRepresentable) factory.createRepresentation(x, y, got), collisionChecker);
                break;

            case ENEMY:
                gameObject = new Enemy((Representable) factory.createRepresentation(x, y, got), Direction.DOWN);
                break;

            case AMMO:
                gameObject = new ImmovableGameObject((Representable) factory.createRepresentation(x, y, got), got);
                break;

            case BARBEDWIRE:
                gameObject = new ImmovableGameObject((Representable) factory.createRepresentation(x, y, got), got);
                break;

            case BULLET:
                gameObject = new Bullet((MovableRepresentable) factory.createRepresentation(x, y, got));
                break;

            case TREE:
                gameObject = new ImmovableGameObject((Representable) factory.createRepresentation(x, y, got), got);
                break;

            case WALL:
                gameObject = new ImmovableGameObject((Representable) factory.createRepresentation(x, y, got), got);
                break;

            case WEAPON:
                gameObject = new ImmovableGameObject((Representable) factory.createRepresentation(x, y, got), got);


        }

        return gameObject;

    }

}
