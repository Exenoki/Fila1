package org.academia.gta.gameobject;

/**
 * Created by codecadet on 25/05/16.
 */
public enum GameObjectType {
    BARBEDWIRE(""),
    TOWER(""),
    TREE("resources/game_sprites/tree.png"),
    WALL(""),
    WEAPON(""),
    AMMO("resources/game_sprites/amo.png"),
    BULLET(""),
    PLAYER(""),
    ENEMY("");

    private String url;

    GameObjectType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
