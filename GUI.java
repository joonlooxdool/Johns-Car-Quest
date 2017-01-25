package game;

import javax.swing.JFrame;

public class GUI {

	public static void main(String[] args) {
		Loader gui = new Loader();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("Used Car Tycoon");
		gui.imgLoader();
		gui.setSize(1920, 1080);
		//gui.pack();
		
	}

}