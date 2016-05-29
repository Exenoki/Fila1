package org.academia.gta.simplegfx;

import org.academia.gta.position.Grid;
import org.academia.gta.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public class SimpleGfxGrid implements Grid {

    private int width;
    private int height;
    private int x;
    private int y;
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
        this.width = width;
        this.height = height;
        ground = new Picture[width/CELL_SIZE][height/CELL_SIZE];
        for (int i=0; i<ground.length; i++){
            for (int j=0; j<ground[i].length; j++){
                ground[i][j] = new Picture(x,y,"resources/game_sprites/dirt_ground.png");
                ground[i][j].draw();
                y+=CELL_SIZE;
            }
            x += CELL_SIZE;
            y =0;
        }
    }

    @Override
    public int getCols() {
        return this.width;
    }

    @Override
    public int getRows() {
        return this.height;

    }

    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col,row,this);
    }

}

