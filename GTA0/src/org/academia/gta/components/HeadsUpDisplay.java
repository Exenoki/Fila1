package org.academia.gta.components;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 03/06/16.
 *
 * Hud of the player information
 */

public class HeadsUpDisplay  {

    private Rectangle healthBar;
    private Text hudAmmo;
    private Text hudBullets;
    private int hudHealthValue;
    private Picture hud = new Picture(620, 10, "resources/game_sprites/hud.png");
    private boolean isLoaded=false;

    /**
     * Information of the ammo available in the HUD
     */
    private void playerAmmo(){
        Text ammo = new Text(755, 25, "");
        ammo.setColor(Color.YELLOW);
        ammo.grow(ammo.getWidth()/3,ammo.getHeight()/3);
        ammo.draw();
        hudAmmo = ammo;
    }

    /**
     * Information of the bullets available in the HUD
     */
    private void playerBullets(){
        Text bullets = new Text(858, 25, "");
        bullets.setColor(Color.YELLOW);
        bullets.grow(bullets.getWidth()/3,bullets.getHeight()/3);
        bullets.draw();
        hudBullets = bullets;
    }

    /**
     * Draw the HUD with the health, ammo and bullets information
     *
     * @param health Health of the player
     */
    public void hud(int health){

        if(!isLoaded) {
            hud.draw();

            this.hudHealthValue = health;

            // Creates a rectangle to reproduce the health of the player
            healthBar = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(hudHealthValue / 1.86), 27);
            healthBar.setColor(Color.GREEN);

            healthBar.fill();

            playerAmmo();
            playerBullets();
        }

        // Every time the health is reduced the healthBar redraw with the new values
        if(hudHealthValue != health && isLoaded) {
            hudHealthValue = health;
            healthBar.delete();

            healthBar = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(hudHealthValue / 1.86), 27);

            if (health <= 25) healthBar.setColor(Color.RED);
            else healthBar.setColor(Color.GREEN);

            healthBar.fill();
        }

        isLoaded = true;
    }

    public Text getHudAmmo() {
        return hudAmmo;
    }

    public Text getHudBullets() {
        return hudBullets;
    }

}
