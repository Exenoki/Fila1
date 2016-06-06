package org.academia.gta.simplegfx.terrainsgfx;

/**
 * Created by codecadet on 26/05/16.
 */
public interface Terrain {

    /**
     * Initializes the Terrain
     */
    public void init(int width, int height);

    /**
     * Gets the width of the terrain
     *
     * @return the width of the terrain
     */
    public int getWidth();

    /**
     * Gets the height of the terrain
     *
     * @return the height of the terrain
     */
    public int getHeight();

}
