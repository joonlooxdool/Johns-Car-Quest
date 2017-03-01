package images;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Graphics implements Runnable, KeyListener, WindowListener, MouseListener{
	public final String TITLE = "Bused Bar Bycoon";
	public final Dimension SIZE = new Dimension(1920, 1080);
	public JFrame frame;
	private boolean isRunning, isDone;
	private Image imgBuffer;
	private TexturePaint jdm, bmw, gtr, supercar;
	private int side = 50;
	int widthFix = (SIZE.width/2);
	int heightFix = (SIZE.height/2);
	//private int PigI;
	//private int PigJ;
	//private boolean change, drawImpass, DrawPig;
	@SuppressWarnings("unused")
	private Color BROWN;
	private boolean showPath;
	@SuppressWarnings("unused")
	private boolean AITurn, UserTurn;
	private int TurnCount = 0;
	//private messageBox info;

private Image titleScreen;

	private void loadImages() {
		try {
		 titleScreen = ImageIO.read(this.getClass().getResource("titlescreen.png"));
	    
	     
		} catch (IOException ex) {
			ex.printStackTrace();
	        Logger.getLogger(Display.class.getName()).log(Level.SEVERE,null, ex);
	    }
	}
	public Graphics() {
		loadImages();
		//info = new messageBox();
		showPath = false;
		//setChange(true);
		//setDrawImpass(false);
		//setDrawPig(false);
		BROWN = new Color(139,69,19);
		//setGame(new square [11][5]); 
		//createTiles();
		frame = new JFrame();
		frame.addKeyListener(this);
		frame.addWindowListener(this);
		frame.addMouseListener(this);
		frame.setSize(SIZE);
		frame.setTitle(TITLE);
		isRunning = true;
		isDone = false;
		frame.setVisible(true);
		frame.setLayout(null);
		imgBuffer = frame.createImage(SIZE.width, SIZE.height);
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int Key;
		Key = arg0.getKeyCode();
		
		if(Key == KeyEvent.VK_ENTER){
			
			
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// we gonna make the game and the draw function from up there b
		while(isRunning){

			

			draw();

			

			
			try{Thread.sleep(50);}

			catch(InterruptedException ie){

				ie.printStackTrace();

			}

		}

		isDone = true;	}
	
	public void Craiglist(Graphics2D g2d){
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(titleScreen, widthFix-256, heightFix-256, widthFix+256, heightFix+256, 0, 0, titleScreen.getWidth(null), titleScreen.getHeight(null), null);
		
	}
	public void draw() {

		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
		
		
		
		Craiglist(g2d);
		if(isRunning)

			g2d = (Graphics2D) frame.getGraphics();
			g2d.drawImage(imgBuffer, 0, 0, SIZE.width, SIZE.height,  null);
		
			g2d.dispose();
		}

}
