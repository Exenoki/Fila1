package org.academia.gta.simplegfx;

import org.academia.gta.position.AbstractGridPosition;
import org.academia.gta.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition{

    //private Rectangle myPosition;
    private Ellipse myPosition;


    public SimpleGfxGridPosition (SimpleGfxGrid grid){
        this((int)(Math.random()*grid.getCols()), (int)(Math.random()*grid.getRows()), grid);

    }

    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);

    }


    public void show(){
        myPosition.setColor(Color.CYAN);
        myPosition.fill();

    }

    public void hide(){
        myPosition.delete();

    }


}
