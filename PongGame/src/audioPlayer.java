import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class audioPlayer {

    File suboris = new File("background_music.wav");
    int preskocenie = 8;
    AudioInputStream hudba;

    {
        try {
            hudba = AudioSystem.getAudioInputStream(suboris);
            Clip clip = AudioSystem.getClip();
            clip.open(hudba);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }


}
