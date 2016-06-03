package org.academia.gta.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */

public class SimpleGfxGrid implements Grid {

    private int width;
    private int height;
    private int x;
    private int y;


    private static final int CELL_SIZE = 50; //Cell size in pixels


    @Override
    public void init(int width, int height) {
        this.width = width;
        this.height = height;
        Picture[][] ground = new Picture[width / CELL_SIZE][height / CELL_SIZE];
        for (int i = 0; i< ground.length; i++){
            for (int j = 0; j< ground[i].length; j++){
                if(i==12) {
                    ground[i][j] = new Picture(x, y, "resources/game_sprites/riveredge.png");
                    ground[i][j].draw();
                    y += CELL_SIZE;
                }else if(i==16){
                    ground[i][j] = new Picture(x, y, "resources/game_sprites/riveredge.png");
                    ground[i][j].draw();
                    ground[i][j].rotateClockWise();
                    ground[i][j].rotateClockWise();
                    y += CELL_SIZE;
                } else if(i>12 && i<16){
                    ground[i][j] = new Picture(x, y, "resources/game_sprites/water.png");
                    ground[i][j].draw();
                    y += CELL_SIZE;
                } else {
                    ground[i][j] = new Picture(x, y, "resources/game_sprites/dirt_ground.png");
                    ground[i][j].draw();
                    y += CELL_SIZE;
                }
            }
            x += CELL_SIZE;
            y =0;
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;

    }

}

