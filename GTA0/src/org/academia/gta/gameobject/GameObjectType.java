package org.academia.gta.gameobject;

/**
 * Created by codecadet on 25/05/16.
 *
 * Types of objects in the game
 */
public enum GameObjectType {
    BARBEDWIRE("resources/game_sprites/barbedwire_d.png"),
    BUNKER("resources/game_sprites/bunker_l.png"),
    TREE("resources/game_sprites/tree.png"),
    AMMO("resources/game_sprites/amo.png"),
    PLAYER("resources/player_sprites/rambo_idle_shoot_r.png"),
    BOAT("resources/game_sprites/boat.png"),
    BULLET(""),
    BRIDGE("resources/game_sprites/bridge_complete.png");

    private String url;

    GameObjectType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
