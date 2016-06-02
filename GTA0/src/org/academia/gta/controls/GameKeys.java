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
        int keyboardEvent;

        switch (gameKeys) {
            case UP:
                keyboardEvent =  KeyboardEvent.KEY_W;
                break;

            case RIGHT:
                keyboardEvent =  KeyboardEvent.KEY_D;
                break;

            case DOWN:
                keyboardEvent =  KeyboardEvent.KEY_S;
                break;

            case LEFT:
                keyboardEvent = KeyboardEvent.KEY_A;
                break;

            case RELOAD:
                keyboardEvent =  KeyboardEvent.KEY_R;
                break;

            default:
                keyboardEvent =  -1;
        }

        return keyboardEvent;
    }
}
