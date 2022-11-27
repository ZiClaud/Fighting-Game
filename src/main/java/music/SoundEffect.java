package music;

import actions.ActionType;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {
    static private File file;
    static private Clip clip;

    public static void playPlayerSound(ActionType actionType) {
        stopMusic();
        file = null;
        if (actionType == ActionType.Attack1)
            PlayerSoundAttack1();
        else if (actionType == ActionType.Attack2)
            PlayerSoundAttack2();
        else if (actionType == ActionType.TakeHit)
            PlayerSoundTakeHit();
        else if (actionType == ActionType.Death)
            PlayerSoundDeath();

        if (file != null)
            startMusic();
    }

    private static void PlayerSoundDeath() {
        file = new File("src/main/resources/SoundEffect/Spirit/death_3_alex.wav");
    }

    private static void PlayerSoundTakeHit() {
        file = new File("src/main/resources/SoundEffect/Spirit/death_3_alex.wav");
    }

    private static void PlayerSoundAttack1() {
        file = new File("src/main/resources/SoundEffect/Spirit/death_10_sean.wav");
    }

    private static void PlayerSoundAttack2() {
    }

    private static void startMusic() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            System.out.println(clip);
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private static void stopMusic() {
        if (clip != null)
            clip.stop();
    }
}