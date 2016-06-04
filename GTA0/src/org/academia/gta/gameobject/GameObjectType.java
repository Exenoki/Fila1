package org.academia.gta.gameobject;

/**
 * Created by codecadet on 25/05/16.
 */
public enum GameObjectType {
    BARBEDWIRE("resources/game_sprites/barbedwire_d.png"),
    TOWER(""),
    BUNKER("resources/game_sprites/bunker_l.png"),
    TREE("resources/game_sprites/tree.png"),
    WALL(""),
    WEAPON(""),
    AMMO("resources/game_sprites/amo.png"),
    BULLET(""),
    PLAYER(""),
    BOAT("resources/game_sprites/boat.png"),
    ENEMY(""),
    BRIDGE("resources/game_sprites/bridge_complete.png"),
    WATER("");

    private String url;

    GameObjectType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
