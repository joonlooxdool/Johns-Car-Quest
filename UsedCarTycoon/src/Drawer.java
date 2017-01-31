	//CODE TO DRAW IMAGES
	import java.awt.*; 
	import java.awt.event.*; 
	import javax.swing.*; 


	public class joonlooxdool extends JPanel {

			public void paintComponent(Graphics j) { 
				super.paintComponent(j); 
				this.setBackground(Color.BLACK); //SETS BACKGROUND COLOR 

				j.setColor(Color.YELLOW); //RECTANGLE COLOR
				j.fillRect(25,25,100,30); 

				// CAN SET NEW COLORS THIS WAY
				j.setColor(new Color(200,81,215));
				j.fillRect(25,65,100,30); 

				// CREATE TEXT 
				j.setColor(Color.WHITE); 
				j.drawString("JoonLooxDool", 25, 120); 





			}

	}
