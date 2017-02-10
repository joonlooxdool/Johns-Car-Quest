package images;

import java.awt.Image;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Display {

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		
		Graphics gui = new Graphics();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("biggiebheese");
		gui.imgLoader();
		gui.pack();
		gui.setSize(1920, 1080);
		
		//Paint G = new Paint();
		//gui.add(G);
		//G.paintComponent(null);
		
		//Music M = new Music();
		//M.playMusic();
		
		//ImagePanel panel = new ImagePanel();
		//new ImageIcon("jon sprite.png").getImage();

		//JFrame frame = new JFrame("jon tron");
		//gui.getContentPane().add(panel);
		//frame.pack();
		//frame.setVisible(true);

		
		gui.setVisible(true);
		//gui.ImagePanel("jon sprite.png");
				
				
		new Sprites();
		
		
		
		
		
		
		
	}

}
