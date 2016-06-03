package org.academia.gta;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 03/06/16.
 */
public class HeadsUpDisplay  {


    public Text hudHealth;
    public Text hudAmmo;
    public Text hudBullets;

    private boolean isLoaded=false;

    private void playerHealth(){
        Text health = new Text(655, 30, "");
        health.setColor(Color.YELLOW);
        health.grow(health.getWidth()/3,health.getHeight()/3);
        health.draw();
        hudHealth = health;
    }

    private void playerAmmo(){
        Text ammo = new Text(760, 30, "");
        ammo.setColor(Color.YELLOW);
        ammo.grow(ammo.getWidth()/3,ammo.getHeight()/3);
        ammo.draw();
        hudAmmo = ammo;
    }

    private void playerBullets(){
        Text bullets = new Text(860, 30, "");
        bullets.setColor(Color.YELLOW);
        bullets.grow(bullets.getWidth()/3,bullets.getHeight()/3);
        bullets.draw();
        hudBullets = bullets;
    }

    public void hud(){
        if(!isLoaded) {
            Picture hud = new Picture(620, 10, "resources/game_sprites/hud.png");
            hud.draw();

            playerHealth();
            playerAmmo();
            playerBullets();
        }
        isLoaded = true;
    }

}
