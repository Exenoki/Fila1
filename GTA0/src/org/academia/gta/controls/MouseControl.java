package org.academia.gta.controls;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by codecadet on 03/06/16.
 */
public class MouseControl implements MouseHandler{

    private int mouseXclicked;
    private int mouseYclicked;
    private int mouseXmove;
    private int mouseYmove;

    private Mouse mouse;

    public MouseControl() {
        mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    public int getMouseXclicked() {
        return mouseXclicked;
    }

    public int getMouseYclicked() {
        return mouseYclicked;
    }

    public int getMouseXmove() {
        return mouseXmove;
    }

    public int getMouseYmove() {
        return mouseYmove;
    }

    @Override
    /**
     * When the mouse is clicked, send the x and y position to mouseClickedEvent
     */
    public void mouseClicked(MouseEvent mouseEvent) {

        mouseXclicked = (int) mouseEvent.getX();
        mouseYclicked = (int) mouseEvent.getY() - 25;

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseXmove = (int) mouseEvent.getX();
        mouseYmove = (int) mouseEvent.getY() - 25;
    }
}
