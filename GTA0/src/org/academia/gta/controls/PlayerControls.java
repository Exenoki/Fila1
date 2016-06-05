package org.academia.gta.controls;

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
 *
 * Controls for the player in the game
 */
public class PlayerControls implements KeyboardHandler, MouseHandler {

    /** Array that will keep track of the keys that are pressed
     * index 0 -> Up
     * index 1 -> Right
     * index 2 -> Down
     * index 3 -> Left
     * index 4 -> Reload
     */
    private boolean[] keyPressed = new boolean[5];

    /** Keyboard instance */
    private Keyboard keyboard;

    /** Mouse instance */
    private Mouse mouse;

    /** Position of the mouse click */
    private int mouseX;
    private int mouseY;

    /** Speed of the player movement */
    private final int SPEED = 2;

    private int dx;
    private int dy;

    private boolean toReload;
    private boolean isEntry; // When the player click the space button to enter the boat

    private boolean shooted = false; // Shoot trigger event

    /**
     * Construct a control player and initialize the event listeners
     */
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

        KeyboardEvent eventEntry = new KeyboardEvent();
        eventEntry.setKey(GameKeys.getKeyCode(GameKeys.ENTRY));
        eventEntry.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventEntry);
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

        KeyboardEvent eventEntryRelease = new KeyboardEvent();
        eventEntryRelease.setKey(GameKeys.getKeyCode(GameKeys.ENTRY));
        eventEntryRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(eventEntryRelease);
    }

    /**
     * Give movement to the game object
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

    /**
     * Reload the weapon
     */
    public void reload() {
        if(keyPressed[4]){
            toReload = true;
            keyPressed[4] = false;
        }
    }

    /**
     * Getter
     * @return If the player pressed space to enter the boat
     */
    public boolean isEntry() {
        return isEntry;
    }

    /**
     * Reset the isEntry variable
     */
    public void entred() {
        isEntry = false;
    }

    @Override
    /**
     * Give movement to the player and check if is to reload the weapon
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
            keyPressed[4] = true;

        // If a key is pressed call the move method
        move();

        // Check if the player pressed the reload button
        reload();

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

        if(keyboardEvent.getKey() == GameKeys.getKeyCode(GameKeys.ENTRY)) {
            isEntry = true;
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

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean isShooted() {
        return shooted;
    }

    public void setShooted(boolean shooted) {
        this.shooted = shooted;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        mouseX = (int) mouseEvent.getX();
        mouseY = (int) mouseEvent.getY() - 25;

        shooted = true;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {}

    public Direction getCurrentDirection() {
         if(keyPressed[0] && keyPressed[1]) {
             return Direction.UP_RIGHT;
         } else if(keyPressed[1] && keyPressed[2]) {
             return Direction.RIGHT_DOWN;
         } else if(keyPressed[2] && keyPressed[3]) {
             return Direction.DOWN_LEFT;
         } else if(keyPressed[3] && keyPressed[0]) {
            return Direction.LEFT_UP;
         } else if (keyPressed[0] ) {
            return Direction.UP;
         } else if (keyPressed[1]) {
            return Direction.RIGHT;
         } else if (keyPressed[2]) {
             return Direction.DOWN;
         } else if (keyPressed[3]) {
             return Direction.LEFT;
         }

        return Direction.NULL;
    }
}
