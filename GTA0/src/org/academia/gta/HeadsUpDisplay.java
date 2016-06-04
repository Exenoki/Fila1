package org.academia.gta;

import com.sun.beans.editors.ColorEditor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 03/06/16.
 */

public class HeadsUpDisplay  {


    Rectangle rect;
    private Text hudAmmo;
    private Text hudBullets;
    private int hudHealthValue;

    private Picture hud = new Picture(620, 10, "resources/game_sprites/hud.png");

    private boolean isLoaded=false;

//    private void playerHealth(){
//        Text health = new Text(655, 30, "");
//        health.setColor(Color.YELLOW);
//        health.grow(health.getWidth()/3,health.getHeight()/3);
//        health.draw();
//        hudHealth = health;
//    }

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

    public void hud(int health){

        if(!isLoaded) {
            hud.draw();

            this.hudHealthValue = health;
            rect = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(hudHealthValue / 1.86), 27);
            rect.setColor(Color.GREEN);

            rect.fill();

           // playerHealth();
            playerAmmo();
            playerBullets();
        }

        if(hudHealthValue != health && isLoaded) {
            hudHealthValue = health;
            rect.delete();

            rect = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(hudHealthValue / 1.86), 27);

            if (health <= 25) rect.setColor(Color.RED);
            else rect.setColor(Color.GREEN);

            rect.fill();
        }

        isLoaded = true;
    }


    public Text getHudAmmo() {
        return hudAmmo;
    }

    public Text getHudBullets() {
        return hudBullets;
    }

//public class HeadsUpDisplay {
//
//    public void hudDisplay(int health, int ammo, int bullets){
//
//        Picture hud = new Picture(620, 10, "resources/game_sprites/hud.png");
//        hud.draw();
//
//        Rectangle rect = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(health / 1.86), 27);
//
//        if (health <= 25) rect.setColor(Color.RED);
//
//        else rect.setColor(Color.GREEN);
//
//        rect.fill();
//
//        Text playerAmmo = new Text(755, 25, ammo+"");
//        playerAmmo.setColor(Color.WHITE);
//        playerAmmo.draw();
//
//        Text playerBullets = new Text(860, 25, bullets+"");
//        playerBullets.setColor(Color.WHITE);
//        playerBullets.draw();
//
//    }
}
