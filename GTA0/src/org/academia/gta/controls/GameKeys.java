package org.academia.gta.controls;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

/**
 * Created by codecadet on 29/05/16.
 */
public enum GameKeys {
    UP,
    RIGHT,
    DOWN,
    LEFT,
    RELOAD;

    /**
     * Gets the code of the pressed key
     *
     * @param gameKeys The key to request the code
     * @return The code(int) of the pressed key
     */
    public static int getKeyCode(GameKeys gameKeys) {
        switch (gameKeys) {
            case UP:
                return KeyboardEvent.KEY_W;

            case RIGHT:
                return KeyboardEvent.KEY_D;

            case DOWN:
                return KeyboardEvent.KEY_S;

            case LEFT:
                return KeyboardEvent.KEY_A;

            case RELOAD:
                return KeyboardEvent.KEY_R;

            default:
                return KeyboardEvent.KEY_W;
        }
    }
}
