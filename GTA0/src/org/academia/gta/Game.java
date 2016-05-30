package org.academia.gta;

import org.academia.gta.position.Grid;
import org.academia.gta.position.GridFactory;
import org.academia.gta.position.GridType;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 29/05/16.
 */
public class Game {

    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Animation delay
     */
    private int delay;

    private int width;
    private int height;

    Game(GridType gridType, int width, int height, int delay) {

        grid = GridFactory.makeGrid(gridType, width, height);
        this.delay = delay;
        this.width = width;
        this.height = height;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {
        grid.init(width,height);
    }
}
