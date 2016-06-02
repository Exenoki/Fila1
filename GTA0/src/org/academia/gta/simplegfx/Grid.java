package org.academia.gta.simplegfx;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 28/05/16.
 */
public interface Grid {

    /**
     * Initializes the grid
     */
    public void init(int width, int height);

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getWidth();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getHeight();

    /**
     * Create a random grid position
     *
     * @return the new grid position
     */

}
