package org.academia.gta.controls;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 03/06/16.
 *
 * Mouse controls for the game menu
 */
public class MouseControl implements MouseHandler{

    private int mouseXClicked;
    private int mouseYClicked;
    private int mouseXMove;
    private int mouseYMove;

    private Mouse mouse;

    /**
     * Construct the mouse and gives the moved and clicked event
     */
    public MouseControl() {
        mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    /**
     * Getter
     *
     * @return X position of the click
     */
    public int getMouseXClicked() {
        return mouseXClicked;
    }

    /**
     * Getter
     *
     * @return Y position of the click
     */
    public int getMouseYClicked() {
        return mouseYClicked;
    }

    /**
     * Getter
     *
     * @return X position of the mouse when moving
     */
    public int getMouseXMove() {
        return mouseXMove;
    }

    /**
     * Getter
     *
     * @return Y position of the mouse when moving
     */
    public int getMouseYMove() {
        return mouseYMove;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        mouseXClicked = (int) mouseEvent.getX();
        mouseYClicked = (int) mouseEvent.getY() - 25;

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseXMove = (int) mouseEvent.getX();
        mouseYMove = (int) mouseEvent.getY() - 25;
    }
}
