package org.academia.gta.position;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16>.
 */

import org.academia.gta.simplegfx.SimpleGfxGrid;

/**
 * A factory of different types of grids
 */
public class GridFactory {

    /**
     * Creates a new grid
     *
     * @param gridType the type of grid to create
     * @param width     the width the grid
     * @param height     the height of the grid
     * @return the new grid
     */
    public static Grid makeGrid(GridType gridType, int width, int height) {

        switch (gridType) {
            default:
                return new SimpleGfxGrid();
        }

    }

}
