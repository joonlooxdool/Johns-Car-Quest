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
	public final Dimension SIZE = new Dimension(600, 950);
	public JFrame frame;
	private boolean isRunning, isDone;
	private Image imgBuffer;
	private TexturePaint jdm, bmw, gtr, supercar;
	private int side = 50;
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

private BufferedImage screen1, screen2;
	private void loadImages() {
		try {
		 screen1 = ImageIO.read(this.getClass().getResource("Capture.PNG"));
	     screen2 = ImageIO.read(this.getClass().getResource("download.jpg"));
	     
		} catch (IOException ex) {

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
		// TODO Auto-generated method stub
		
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
	}
	public void draw() {
		//BufferedImage imgBuffer;
		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
		//g2d.setBackground(Color.YELLOW);
		g2d.setPaint((Paint) screen1);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
	}

}
