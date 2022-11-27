package music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class GameMusic {
    static private Clip clip;

    public static void startGameMusic() {
        stopMusic();
        try {
            File file = new File("src/main/resources/Music/Dystopian.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void startMenuMusic() {
        stopMusic();
        try {
            File file = new File("src/main/resources/Music/EmptyStreets.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
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
