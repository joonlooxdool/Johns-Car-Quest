package images;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Music {
	
	public void playMusic()  throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
				new File("play.wav.wav"));
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl =
				(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f);
		clip.start();
		
	}
	
}
