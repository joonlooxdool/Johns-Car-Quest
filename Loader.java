package game;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Loader extends JFrame{
	
	private ImageIcon image1;
	private JLabel label1;
	
	void imgLoader(){
		
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("logo.png"));

		label1 = new JLabel(image1);
		add(label1);
	}
}