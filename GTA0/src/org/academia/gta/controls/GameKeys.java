package org.academia.gta.controls;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

/**
 * Created by codecadet on 29/05/16.
 */
public enum GameKeys {
    UP,
    RIGHT,
    DOWN,
    LEFT;

    /**
     * Gets the code of the pressed key
     *
     * @param gameKeys The key to request the code
     * @return The code(int) of the pressed key
     */
    public static int getKeyCode(GameKeys gameKeys) {
        switch (gameKeys) {
            case UP:
                return KeyboardEvent.KEY_UP;

            case RIGHT:
                return KeyboardEvent.KEY_RIGHT;

            case DOWN:
                return KeyboardEvent.KEY_DOWN;

            case LEFT:
                return KeyboardEvent.KEY_LEFT;

            default:
                return KeyboardEvent.KEY_RIGHT;
        }
    }
}
