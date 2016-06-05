package org.academia.gta.components;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by glitch for <Bashtard$ Bootcamp @ Academia de Código - Fundão 04/06/16.
 */
public class SoundFx {

    private Clip sample;
    private Clip gameover;
    private Clip shootFx;

    public void playSound(String source) {

        File soundFile = new File(source);

        try {

            AudioInputStream stream = AudioSystem.getAudioInputStream(soundFile);
            AudioSystem.getAudioFileFormat(soundFile);
            sample = AudioSystem.getClip();
            sample.open(stream);
            sample.start();
            sample.loop(Clip.LOOP_CONTINUOUSLY);


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



    public Clip getBgmusic(){
        return sample;
    }


}
