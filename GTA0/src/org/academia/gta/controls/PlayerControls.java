package org.academia.gta.controls;

import org.academia.gta.gameobject.people.Player;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 31/05/16.
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
    private int mouseX;
    private int mouseY;

    /** Spedd of the player movement */
    private final int SPEED = 4;

    private int dx;
    private int dy;

    private boolean toReload;

    private boolean shooted = false;

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public PlayerControls() {
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
        //player.shoot(x, y);
        shooted = true;
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

        KeyboardEvent eventReload = new KeyboardEvent();
        eventReload.setKey(GameKeys.getKeyCode(GameKeys.RELOAD));
        eventReload.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventReload);
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
     * Give movement to the object
     */
    public void move() {
        if(keyPressed[0])
            dy = -SPEED;

        if(keyPressed[1])
            dx = SPEED;

        if(keyPressed[2])
            dy = SPEED;

        if(keyPressed[3])
            dx = -SPEED;
    }

    @Override
    /**
     * Give a movement to the player when a key or keys are pressed
     * by changing a delta x and y values
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

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.RELOAD))
            toReload = true;

        // If a key is pressed call the move method
        move();
    }

    @Override
    /**
     * When key is released the keyPressed array will change the index to false
     */
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.UP)) {
            keyPressed[0] = false;
            dy = 0;
        }


        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.RIGHT)) {
            keyPressed[1] = false;
            dx = 0;
        }


        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.DOWN)) {
            keyPressed[2] = false;
            dy = 0;
        }


        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.LEFT)) {
            keyPressed[3] = false;
            dx = 0;
        }

    }

    public boolean isReload() {
        return toReload;
    }

    public void setToReload(boolean toReload) {
        this.toReload = toReload;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public boolean isShooted() {
        return shooted;
    }

    public void setShooted(boolean shooted) {
        this.shooted = shooted;
    }

    @Override
    /**
     * When the mouse is clicked, send the x and y position to mouseClickedEvent
     */
    public void mouseClicked(MouseEvent mouseEvent) {

        mouseX = (int) mouseEvent.getX();
        mouseY = (int) mouseEvent.getY();

        mouseClickedEvent(mouseX, mouseY);
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}

}
