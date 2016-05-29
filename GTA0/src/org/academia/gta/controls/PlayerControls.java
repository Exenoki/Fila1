package org.academia.gta.controls;

import org.academia.gta.people.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 27/05/16.
 */
public class PlayerControls implements KeyboardHandler, MouseHandler {

    /** Array that will keep track of the keys that are pressed
     * index 0 -> Up
     * index 1 -> Right
     * index 2 -> Down
     * index 3 -> Left
     */
    private boolean[] keyPressed = new boolean[4];

    /** Keyboard instance */
    private Keyboard keyboard;

    /** Mouse instance */
    private Mouse mouse;

    /** Position of the mouse click */
    private int x;
    private int y;

    /** Player instance */
    private Player player;

    /**
     * Constructor a new player controls
     *
     * @param player Player that will receive the controls
     */
    public PlayerControls(Player player) {
        this.player = player;

        // Create and define the keyboard configuration
        keyboard = new Keyboard(this);
        setKeyboardEventRelease();
        setKeyboardEventPressed();

        // Create and define the mouse listener
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    /**
     * Receive the clicked coordinates
     * and Delegates the shoot event to the instance player
     *
     * @param x The x position of the click
     * @param y The y position of the click
     */
    public void mouseClickedEvent(int x, int y) {
        // player.shoot(x, y); TODO uncomment player shoot method
    }

    /**
     * Set the keyboard event for the key press
     */
    public void setKeyboardEventPressed() {
        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(GameKeys.getKeyCode(GameKeys.UP));
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(GameKeys.getKeyCode(GameKeys.RIGHT));
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(GameKeys.getKeyCode(GameKeys.DOWN));
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(GameKeys.getKeyCode(GameKeys.LEFT));
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);
    }

    /**
     * Set the keyboard event for the key release
     */
    public void setKeyboardEventRelease() {
        KeyboardEvent eventUpRelease = new KeyboardEvent();
        eventUpRelease.setKey(GameKeys.getKeyCode(GameKeys.UP));
        eventUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventUpRelease);

        KeyboardEvent eventRightRelease = new KeyboardEvent();
        eventRightRelease.setKey(GameKeys.getKeyCode(GameKeys.RIGHT));
        eventRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventRightRelease);

        KeyboardEvent eventDownRelease = new KeyboardEvent();
        eventDownRelease.setKey(GameKeys.getKeyCode(GameKeys.DOWN));
        eventDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventDownRelease);

        KeyboardEvent eventLeftRelease = new KeyboardEvent();
        eventLeftRelease.setKey(GameKeys.getKeyCode(GameKeys.LEFT));
        eventLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventLeftRelease);
    }

    /**
     * Give movement to the player with a speed taken from the player
     */
    public void move() {
        /*if(keyPressed[0]) TODO uncomment move method body and change the enum direction
            player.getPos().moveInDirection(GridDirection.UP, player.getSPEED());

        if(keyPressed[1])
            player.getPos().moveInDirection(GridDirection.RIGHT, player.getSPEED());

        if(keyPressed[2])
            player.getPos().moveInDirection(GridDirection.DOWN, player.getSPEED());

        if(keyPressed[3])
            player.getPos().moveInDirection(GridDirection.LEFT, player.getSPEED());*/
    }

    @Override
    /**
     * Sets to true the index in the keyPressed array to do the respective movement
     */
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.UP))
            keyPressed[0] = true;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.RIGHT))
            keyPressed[1] = true;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.DOWN))
            keyPressed[2] = true;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.LEFT))
            keyPressed[3] = true;

        // If a key is pressed call the move method
        move();
    }

    @Override
    /**
     * When key is released the keyPressed array will change the index to false
     */
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.UP))
            keyPressed[0] = false;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.RIGHT))
            keyPressed[1] = false;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.DOWN))
            keyPressed[2] = false;

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.LEFT))
            keyPressed[3] = false;
    }

    @Override
    /**
     * When the mouse is clicked, send the x and y position to mouseClickedEvent
     */
    public void mouseClicked(MouseEvent mouseEvent) {

        x = (int) mouseEvent.getX();
        y = (int) mouseEvent.getY();

        mouseClickedEvent(x, y);
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}

}
