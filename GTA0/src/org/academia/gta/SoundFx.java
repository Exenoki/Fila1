package org.academia.gta;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 04/06/16.
 */
public class SoundFx {

    private Clip bgmusic;
    private Clip shootFx;

    public void playSound() {

        File soundFile = new File("resources/soundfx/bgmusic.wav");

        try {

            AudioInputStream stream = AudioSystem.getAudioInputStream(soundFile);
            AudioSystem.getAudioFileFormat(soundFile);
            bgmusic = AudioSystem.getClip();
            bgmusic.open(stream);
            bgmusic.start();
            bgmusic.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {

            System.out.println("Audio playback error!");
            e.printStackTrace();

        }
    }


    public void shootSound() {

        File soundFile = new File("resources/soundfx/gunshot.wav");

        try {

            AudioInputStream bulletShot = AudioSystem.getAudioInputStream(soundFile);
            AudioSystem.getAudioFileFormat(soundFile);
            shootFx = AudioSystem.getClip();
            shootFx.open(bulletShot);
            shootFx.start();


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {

            System.out.println("Audio playback error!");
            e.printStackTrace();

        }
    }



}
