package org.academia.gta.simplegfx.terrainsgfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 26/05/16.
 */

public class SimpleGfxTerrain implements Terrain {

    private static final int CELL_SIZE = 50; //Cell size in pixels

    private int width;
    private int height;
    private int x;
    private int y;
    private Picture[][] ground;

    @Override
    /**
     * Create the river in the terrain
     */
    public void init(int width, int height) {
        this.width = width;
        this.height = height;
        ground = new Picture[width / CELL_SIZE][height / CELL_SIZE];
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

