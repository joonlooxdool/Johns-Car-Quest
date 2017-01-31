
package images;

import javax.swing.JFrame;

public class Display {

	public static void main(String[] args) {
		
		Loader gui = new Loader();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setTitle("biggiebheese");
		//gui.imgLoader();
		//gui.pack();
		gui.setSize(1920, 1080);
		
		Paint G = new Paint();
		gui.add(G);
		G.paintComponent(null);
		
		
	}

}
