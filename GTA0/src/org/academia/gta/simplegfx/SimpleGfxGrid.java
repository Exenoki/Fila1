package org.academia.gta.simplegfx;

import org.academia.gta.position.Grid;
import org.academia.gta.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public class SimpleGfxGrid implements Grid {

    private int col;
    private int row;
    private Picture[][] ground;


    public static final int CELL_SIZE = 50; //Cell size in pixels


    public static int convertToPixel(int gridPos){
        return gridPos * CELL_SIZE;
    }

    public static Rectangle createRectangle(int col, int row){
        return new Rectangle(convertToPixel(col), convertToPixel(row), CELL_SIZE , CELL_SIZE);
    }


    @Override
    public void init(int width, int height) {

        ground = new Picture[width/CELL_SIZE][height/CELL_SIZE];
        for (int i=0; i<ground.length; i++){
            for (int j=0; j<ground[i].length; j++){
                ground[i][j] = new Picture("http://img.stockfresh.com/files/t/tashatuvango/x/27/4810138_39548961.jpg");
                ground[i][j].translate(col,row);
                ground[i][j].draw();
                row+=CELL_SIZE;
            }

            col += CELL_SIZE;
            row =0;
        }
    }

    @Override
    public int getCols() {
        return this.col;
        //throw new UnsupportedOperationException();
    }

    @Override
    public int getRows() {
        return this.row;
        //throw new UnsupportedOperationException();
    }

    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
        //throw new UnsupportedOperationException();
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col,row,this);
        //throw new UnsupportedOperationException();
    }

}

