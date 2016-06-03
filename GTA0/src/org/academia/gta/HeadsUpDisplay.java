package org.academia.gta;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 03/06/16.
 */
public class HeadsUpDisplay {

    public void hudDisplay(int health, int ammo, int bullets){

        Picture hud = new Picture(620, 10, "resources/game_sprites/hud.png");
        hud.draw();

        Rectangle rect = new Rectangle(hud.getX() + 11, hud.getY() + 10 , Math.round(health / 1.86), 27);

        if (health <= 25) rect.setColor(Color.RED);

        else rect.setColor(Color.GREEN);

        rect.fill();

        Text playerAmmo = new Text(755, 25, ammo+"");
        playerAmmo.setColor(Color.WHITE);
        playerAmmo.draw();

        Text playerBullets = new Text(860, 25, bullets+"");
        playerBullets.setColor(Color.WHITE);
        playerBullets.draw();

    }
}
