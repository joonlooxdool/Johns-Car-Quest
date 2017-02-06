package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GUI {
	
	public static void main(String[] args) {
		Loader gui = new Loader();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("Used Car Tycoon");
		gui.imgLoader();
		gui.setSize(1920, 1080);
		gui.pack();
	
		Drawing G = new Drawing();
		gui.add(G);
		G.paintComponent(null);	
	}
}