package org.academia.gta.components;

import org.academia.gta.gameobject.people.Player;

/**
 * Created by codecadet on 05/06/16.
 *
 * Class responsible for the animation of the player
 */
public class Animator {

    // Frame rate loop counter
    private int counter = 0;

    public void animationMoveRight(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_r.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_r.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_r.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_r.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_r.png");
            counter = 0;
        }
    }

    public void animationMoveLeft(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_l.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_l.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_l.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_l.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_l.png");
            counter = 0;
        }
    }

    public void animationMoveUp(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_u.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_u.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_u.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_u.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_u.png");
            counter = 0;
        }
    }

    public void animationMoveDown(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_d.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_d.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_d.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_d.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_d.png");
            counter = 0;
        }
    }

    public void animationMoveUpRight(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_ur.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_ur.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_ur.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_ur.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ur.png");
            counter = 0;
        }
    }

    public void animationMoveUpLeft(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_ul.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_ul.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_ul.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_ul.png");
        } else if (counter >= 30){
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_ul.png");
            counter = 0;
        }
    }

    public void animationMoveDownLeft(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_dl.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_dl.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_dl.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_dl.png");
        } else if (counter >= 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dl.png");
            counter = 0;
        }

    }

    public void animationMoveDownRight(Player player) {
        counter++;
        if (counter >= 0 && counter < 5) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
        } else if (counter >= 5 && counter < 10) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot1_dr.png");
        } else if (counter >= 10 && counter < 15) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot2_dr.png");
        } else if (counter >= 15 && counter < 20) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
        } else if (counter >= 20 && counter < 25) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot3_dr.png");
        } else if (counter >= 25 && counter < 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_walk_shoot4_dr.png");
        } else if (counter >= 30) {
            player.getRepresentation().load("resources/player_sprites/rambo_idle_shoot_dr.png");
            counter = 0;
        }

    }
}
