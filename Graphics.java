package images;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
//Import all these
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


//Loading images like this needs to extend JFrame
public class Graphics extends JFrame{
	public final String TITLE = "CarQuest or not";
    public final Dimension SIZE = new Dimension(600, 950);
	//Create Image variables (If you want to add more do it again but increment num
	private BufferedImage image1;
	
	private Image imgBuffer;
	/* private ImageIcon image2;
	 * private JLabel label2;
	 */
	
	// Method which actually displays the image. 
	void imgLoader(){
		
		//This creates a window
		//setLayout(new FlowLayout());
		//download.jpg should probably be more specific lol
		
		/*IMPORTANT*
		 * the picture should be in a certain folder. idk which folder lol.
		 */
		try{
		image1 = new ImageIO.read(getClass().getResourceAsStream("Capture.png"));
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//labels are how you refer to the image
		//label1 = new JLabel(image1);
		//add(label1);
		imgBuffer = this.createImage(SIZE.width, SIZE.height);
		/* image2 = new ImageIcon(getClass().getResource("additonalName.jpg"));\
		 * label2 = new JLabel(image2);
		 * add(label2);
		 */
		
	}
	
	
	public void draw(){
		Graphics2D art = (Graphics2D) imgBuffer.getGraphics();
		art.drawImage(image1, x, y, observer)
		
		
	}
	
	
	
	
}
