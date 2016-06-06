package org.academia.gta.components;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by codecadet on 26/05/16.
 * <p>
 * Class responsible for the sound of the game
 */
public class SoundFx {

    private Clip sample;
    private Clip shootFx;

    public void playSound(String source) {

        String pathStr = "/resources/" + source;
        URL soundURL = SoundFx.class.getResource(pathStr);


        if (soundURL == null) {
            // load sound from source code
            File file = new File("resources/" + source);


            try {
                soundURL = file.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }


        try {

            AudioInputStream stream = AudioSystem.getAudioInputStream(soundURL);
            AudioSystem.getAudioFileFormat(soundURL);
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

        String pathStr = "/resources/soundfx/gunshot.wav";
        URL soundURL = SoundFx.class.getResource(pathStr);


        if (soundURL == null) {
            // load sound from source code
            File file = new File("resources/soundfx/gunshot.wav");


            try {
                soundURL = file.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }


        try {

            AudioInputStream bulletShot = AudioSystem.getAudioInputStream(soundURL);
            AudioSystem.getAudioFileFormat(soundURL);
            shootFx = AudioSystem.getClip();
            shootFx.open(bulletShot);
            shootFx.start();


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {

            System.out.println("Audio playback error!");
            e.printStackTrace();

        }
    }

    public Clip getBgmusic() {
        return sample;
    }


}
