package images;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;
import java.util.Scanner;

public class Graphics implements Runnable, KeyListener, WindowListener, MouseListener{
	public static enum GAMESTATE{TITLESCREEN, CRAIGSLIST, FRONTDESK, GARAGE, STATS, UTIL, LOG, BACK};
	public final String TITLE = "Used Car Tycoon";
	public final Dimension SIZE = new Dimension(1920, 1080);
	public JFrame frame;
	private boolean isRunning, isDone;
	private Image imgBuffer;
	private TexturePaint jdm, bmw, gtr, supercar;
	private int side = 50;
	int money = 1000;
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
	public static GAMESTATE SCREEN;
	int currentState = 0; //1 = titlescreen. 2 = frontdesk. 3 = craigslist. 4 = stats. 5 = util. 6 = log. 7 = util.
	int done = 0;
	String end = "";
	int cost;
	int odo;
	String condition;
	int year;
	Image[] owned = new Image[11];

private Image titleScreen, SBImg, statBar, buyButton, carsButton, partsButton, upgradesButton, statButton, utilButton, logButton, shopFront, tableComp, computer, garage, backButton, screenBorder;
//CARS
private Image civicRed, datsun, e36, fj, civicR, cClassWHITE, cClassBLACK, rx7, toyotaGt, toyotaGtRED, Datsun510, lancer, miata, s2000, crv, BMWM3, bmwx3blue, BMWX3, somegoldcar, noImage;
	
public void initGarage(){
	for(int i = 0; i < owned.length; i++){
		owned[i] = noImage;
	}
}


	private void loadImages() {
		try {
			
		titleScreen = ImageIO.read(this.getClass().getResource("titlescreen.png"));
	    SBImg = ImageIO.read(this.getClass().getResource("StartButton.png"));
	    statBar = ImageIO.read(this.getClass().getResource("statbarb.png"));
	    buyButton = ImageIO.read(this.getClass().getResource("buy.png"));
	    carsButton = ImageIO.read(this.getClass().getResource("carsbutton.png"));
	    partsButton = ImageIO.read(this.getClass().getResource("partsbutton.png"));
	    upgradesButton = ImageIO.read(this.getClass().getResource("upgradesbutton.png"));
	    statButton = ImageIO.read(this.getClass().getResource("statbutton.png"));
	    utilButton = ImageIO.read(this.getClass().getResource("utilbutton.png"));
	    logButton = ImageIO.read(this.getClass().getResource("logbutton.png"));
	    shopFront = ImageIO.read(this.getClass().getResource("shopFront.png"));
	    computer = ImageIO.read(this.getClass().getResource("computer.png"));
	    garage = ImageIO.read(this.getClass().getResource("garage.png"));
	    backButton = ImageIO.read(this.getClass().getResource("back.png"));
	    screenBorder = ImageIO.read(this.getClass().getResource("screenBorder.png"));
	    //CARS
	     civicRed = ImageIO.read(this.getClass().getResource("bonda bivic bed.png"));
	     datsun = ImageIO.read(this.getClass().getResource("Datsun 510.png"));
	     e36 = ImageIO.read(this.getClass().getResource("e36.png"));
	     fj = ImageIO.read(this.getClass().getResource("fj new.png"));
	     civicR = ImageIO.read(this.getClass().getResource("Honda Civic Type R.png"));
	     cClassWHITE = ImageIO.read(this.getClass().getResource("Mercedes C Class WHITE.png"));
	     cClassBLACK = ImageIO.read(this.getClass().getResource("Mercedes C Class BLACK.png"));
	     rx7 = ImageIO.read(this.getClass().getResource("rx7.png"));
	     toyotaGt = ImageIO.read(this.getClass().getResource("toyota 2000 gt.png"));
	     toyotaGtRED = ImageIO.read(this.getClass().getResource("toyota 2000 gt RED.png"));
	     Datsun510 = ImageIO.read(this.getClass().getResource("Datsun 510.png"));
	     lancer = ImageIO.read(this.getClass().getResource("Mitsubishi Lancer.png"));
	     miata = ImageIO.read(this.getClass().getResource("miata hardtop.png"));
	     s2000 = ImageIO.read(this.getClass().getResource("s2000.png"));
	     crv = ImageIO.read(this.getClass().getResource("crv pixell.png"));
	     BMWM3 = ImageIO.read(this.getClass().getResource("Blue M3.png"));
	     bmwx3blue = ImageIO.read(this.getClass().getResource("BMW X3 BLUE.png"));
	     BMWX3 = ImageIO.read(this.getClass().getResource("BMW X3.png"));
	     somegoldcar = ImageIO.read(this.getClass().getResource("some gold car.png"));
	     
		} catch (IOException ex) {
			ex.printStackTrace();
	        Logger.getLogger(Display.class.getName()).log(Level.SEVERE,null, ex);
	    }
	}
	public Graphics() {
		SCREEN = GAMESTATE.TITLESCREEN;
		loadImages();
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
	
	public boolean buttonBuilder (int x1, int y1, int x2, int y2, MouseEvent arg0){
		System.out.println(SCREEN + " BUTTON");
		System.out.println(x1 + " : " + x2);
		if(arg0.getX() >= x1 && arg0.getX() <= x2){
			if(arg0.getY()>= y1 && arg0.getY() <= y2){
				System.out.println("X : " + x1 + " : " + arg0.getX() + " : " + x2);
				System.out.println("Y : " + y1 + " : " + arg0.getY() + " : " + y2);
				
		return true;
			}
		}
		return false;
	}
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
		System.out.println(" CLICK "+ arg0.getX() + ", " + arg0.getY());
		// TODO Auto-generated method stub
		
		switch(SCREEN){
		
		case TITLESCREEN:
			if (buttonBuilder(widthFix-108, heightFix+32, widthFix+100, heightFix+75, arg0)){
				SCREEN = GAMESTATE.FRONTDESK;
			}
			break;
		case FRONTDESK:
			if(buttonBuilder(36, 897, 181, 1037, arg0)){
				SCREEN = GAMESTATE.STATS;
			}
			if(buttonBuilder(240, 897, 385, 1037, arg0)){
				SCREEN = GAMESTATE.UTIL;
			}
			if(buttonBuilder(428, 897, 573, 1037, arg0)){
				SCREEN = GAMESTATE.LOG;
			}
			if(buttonBuilder(1736, 397, 1855, 844, arg0)){
				SCREEN = GAMESTATE.GARAGE;
			}
			if(buttonBuilder(1237, 821, 1456, 928, arg0)){
				SCREEN = GAMESTATE.CRAIGSLIST;
			}
			break;
		case STATS:
			break;
		case UTIL:
			break;
		case CRAIGSLIST:
			break;
		case GARAGE:
			break;
		default:
			break;
		}	
		if(SCREEN != GAMESTATE.BACK || SCREEN != GAMESTATE.FRONTDESK)
		if(buttonBuilder(SIZE.width-185, 0, SIZE.width, 75, arg0)){
			SCREEN = GAMESTATE.BACK;
			
		}
		
			
			
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
	MouseEvent arg1;
	public void drawering(Graphics2D g2d, MouseEvent arg0){
		
		switch(SCREEN){
		case TITLESCREEN:
			currentState = 1;
			titleScreen(g2d);
			break;
		case FRONTDESK:
			currentState = 2;
			frontdesk(g2d, arg0);
			break;
		case CRAIGSLIST:
			currentState = 3;
			craigslistButtons(g2d);
			break;
		case STATS:
			currentState = 4;
			statsScreen(g2d);
			break;
		case UTIL:
			currentState = 5;
			utilScreen(g2d);
			break;
		case LOG:
			currentState = 6;
			logScreen(g2d);
			break;
		case GARAGE:
			currentState = 7;
			garageScreen(g2d);
			break;
		case BACK:
			back(g2d, arg0);
			break;
		default:
			break;
		}
		
	}
	
	public void back(Graphics2D g2d, MouseEvent arg0){
		
		System.out.println(SCREEN);
			switch(currentState){
			case 1:
				break;
			case 2:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
				break;
			case 3:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
				break;
			case 4:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
				break;
			case 5:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
				break;
			case 6:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
				break;
			case 7:
				SCREEN = GAMESTATE.FRONTDESK;
				currentState = 2;
			};
			System.out.println(SCREEN);
	}
	
	public void frontdesk(Graphics2D g2d, MouseEvent arg0){
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		
		g2d.drawImage(shopFront, 0, 80, 1920, 900, 0, 0, 240, 106, null);
		g2d.drawImage(computer, 1200, 780, 1500, 1050, 0, 0, 180, 150, null);
		
		g2d.drawImage(statButton, 36, 897, 181, 1037, 0, 0, 192, 192, null);
		g2d.drawImage(utilButton, 240, 897, 385, 1037, 0, 0, 192, 192, null);
		g2d.drawImage(logButton, 428, 897, 573, 1037, 0, 0, 192, 192, null);
		
		
		
		g2d.setColor(Color.WHITE);
		
		
		g2d.drawString("$" + String.valueOf(money), 30, 60);
		
	}
	
	public void titleScreen(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(titleScreen, widthFix-256, heightFix-400, widthFix+256, heightFix+112, 0, 0, titleScreen.getWidth(null), titleScreen.getHeight(null), null);
		g2d.drawImage(SBImg, widthFix-256, heightFix-200, widthFix+256, heightFix+312, 0, 0, 128, 128, null);
		
	}
	
	public String chooseCar(Graphics2D g2d){
		
		
		
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect(36, 897, 181, 1500);
		if(buttonBuilder(36, 897, 181, 1500, arg1)){
			
			Random rand = new Random();
			int a = rand.nextInt(12)+1;
		
		switch(a){
		case 1:
			end = "CIVIC";
			break;
		case 2:
			end = "E36";
			break;
		case 3:
			end = "DATSUN";
			break;
		case 4:
			end = "TOYOTAGT";
			break;
		case 5:
			end = "RX7";
			break;
		case 6:
			end = "MIATA";
			break;
		case 7:
			end = "FJ";
			break;
		case 8:
			end = "DATSUN510";
			break;
		case 9:
			end = "TOYOTAGTRED";
			break;
		case 10:
			end = "LANCER";
			break;
		case 11:
			end = "SOMEGOLDCAR";
			break;
		case 12:
			end = "S2000";
			break;
		}
		
		}
		
		return end;
	}
	
	
	public void craigslistReport(Image model){
		for(int i = 0; i < owned.length; i++){
			if((owned[i] == noImage) && (owned[i] != model)){
				owned[i] = model;
			}else if(owned[i] == model){
				System.out.println("YOU ALREADY HAVE THAT ONE YOU RETARD");
			}
		}
	}
	
	public void reset(){
		
		
		
	}
	
	public void craigslistButtons(Graphics2D g2d){
		
		Random rand = new Random();
		int a = rand.nextInt(12)+1;
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		g2d.drawImage(screenBorder, 0, 80, 1920, 900, 0, 0, 240, 106, null);		
		g2d.drawImage(backButton, 1730, -25, 1902, 132, 0, 0, 192, 192, null);
		g2d.drawImage(backButton, 1730, 900, 1902, 1092, 0, 0, 192, 192, null);
		g2d.drawString("$" + String.valueOf(money), 30, 60);
		
		String end = chooseCar(g2d);
		
		for(int i = 0; i < 4; i++){
            g2d.drawString("                                                                                       ", 10, 200);
			switch(end){
			case "CIVIC": 
				cost = 5000;
				g2d.drawImage(civicR, 104, 200, 404, 477, 0, 0, 128, 96, null);
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(civicR);
				}
				break;
			case "E36":
				g2d.drawImage(e36, 104, 200, 404, 477, 0, 0, 128, 85, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(e36);
				}
				
				break;
			case "DATSUN":
				g2d.drawImage(datsun, 104, 200, 404, 477, 0, 0, 128, 85, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(datsun);
				}
				
				break;
			case "TOYOTAGT": 
				g2d.drawImage(toyotaGt, 104, 500, 404, 777, 0, 0, 128, 72, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(toyotaGt);
				}
				
				break;
			case "RX7":
				g2d.drawImage(rx7, 104, 500, 404, 777, 0, 0, 768, 576, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(rx7);
				}
				
				break;
			case "MIATA":
				g2d.drawImage(miata, 104, 500, 404, 777, 0, 0, 768, 576, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 500, 404, 777, arg1)){
					money -= cost;
					craigslistReport(miata);
				}
				
				break; 
			case "FJ":
				g2d.drawImage(fj, 1500, 200, 404, 477, 0, 0, 500, 150, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 500, 404, 777, arg1)){
					money -= cost;
					craigslistReport(fj);
				}
				
				break;
			case "DATSUN510":
				g2d.drawImage(Datsun510, 1500, 500, 404, 777, 0, 0, 2000, 700, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(104, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(Datsun510);
				}
				
				break;
			case "TOYOTAGTRED":
				g2d.drawImage(toyotaGtRED, 1500, 200, 404, 477, 0, 0, 500, 100, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(1500, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(toyotaGtRED);
				}
				
				break;
			case "LANCER":
				g2d.drawImage(lancer, 104, 500, 404, 777, 0, 0, 768, 576, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(1500, 200, 404, 477, arg1)){
					money -= cost;
					craigslistReport(lancer);
				}
				
				break;
			case "SOMEGOLDCAR":
				g2d.drawImage(somegoldcar, 1500, 500, 404, 777, 0, 0, 500, 100, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(1500, 500, 404, 777, arg1)){
					money -= cost;
					craigslistReport(somegoldcar);
				}
				
				break;
			case "S2000":
				g2d.drawImage(s2000,  1500, 500, 304, 777, 0, 0, 3000, 700, null);
				
				cost = 5000;
				odo = rand.nextInt(200000);
				if(odo < 100000){
				int condChance = rand.nextInt(3) + 1;
				if(condChance == 1){
					condition = "really good";
				}else if(condChance == 2){
					condition = "pretty decent";
				}else{
					condition = "gahbage";
				}
				}else if(odo > 100000){
					int condChance = rand.nextInt(3) + 1;
					if(condChance > 1){
						condition = "pretty decent";
					}else{
						condition = "gahbage";
					}
				}
				
				if(condition.equals("gahbage")){
					cost -= 1000;
				}else if(condition.equals("pretty decent")){
					cost += 1000;
				}else{
					cost += 2000;
				}
				g2d.drawString("Cost: " + cost + "             " + "Odometer: " + odo + "             " + condition, 10, 200);
				if(buttonBuilder(1500, 500, 304, 777, arg1)){
					money -= cost;
					cost = 0;
					craigslistReport(s2000);
				}
				
				break;
			}
		}
		
		end = "";
		
	}
		//String currentCar;
		//Car car = new Car();
		//currentCar = Car.carCall();
		
		/*switch(currentCar){
		case "Honda Civic type R": 
			break;
		case "Datsun 510":
			break;
		case "BMW M3":
			break;
		case "Toyota FJ Cruiser":
			break;
		case "Mercedes C-Class Coupe":
			break;
		case "Mazda  RX-7":
			break;
		case "Toyota 2000GT":
			break;
		}
		   /* n = rand.nextInt(numCars) + 1;
			switch(n){
			case 1: 
				g2d.drawImage(civicR, 104, 200, 404, 477, 0, 0, 128, 96, null);
				break;
			case 2:
				g2d.drawImage(e36, 104, 200, 404, 477, 0, 0, 128, 85, null);
				break;
			case 3:
				g2d.drawImage(datsun, 104, 200, 404, 477, 0, 0, 128, 85, null);
			}
			
			n = rand.nextInt(numCars) + 1;
			switch(n){
			case 1:
				g2d.drawImage(toyotaGt, 104, 500, 404, 777, 0, 0, 128, 72, null);
				break;
			case 2:
				g2d.drawImage(rx7, 104, 500, 404, 777, 0, 0, 768, 576, null);
				break;
			case 3:
				g2d.drawImage(miata, 104, 500, 404, 777, 0, 0, 768, 576, null);
			
			}
			
			n = rand.nextInt(numCars) + 1;
			switch(n){
			case 1:
				g2d.drawImage(fj, 1500, 200, 404, 477, 0, 0, 500, 150, null);
				break;
			case 2:
				g2d.drawImage(toyotaGtRED, 1500, 200, 404, 477, 0, 0, 500, 100, null);
				break;
			case 3: 
				g2d.drawImage(lancer, 1500, 200, 404, 477, 0, 0, 2500, 400, null);
				break; 
			}
			
			n = rand.nextInt(numCars) + 1;
			switch(n){
			case 1:
				g2d.drawImage(somegoldcar, 1500, 500, 404, 777, 0, 0, 500, 100, null);
				break;
			case 2:
				g2d.drawImage(s2000, 1500, 500, 304, 777, 0, 0, 3000, 700, null);
				break;
			case 3:
				g2d.drawImage(Datsun510, 1500, 500, 404, 777, 0, 0, 2000, 700, null);
				break;
			}
			
			
}*/
	/*public void car(){
	int odo, cond, price; 
	String title;
	boolean problem = false;
	}*/
	
	public void garageScreen(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(garage, 0, 80, 1920, 900, 0, 0, 240, 106, null);
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		g2d.drawImage(backButton, 1730, -25, 1902, 132, 0, 0, 192, 192, null);
		g2d.drawString("$" + String.valueOf(money), 30, 60);
		
		
		for(int i = 0; i < owned.length; i++){
			if(owned[i] == civicR){
			g2d.drawImage(civicR, 104, 200, 404, 477, 0, 0, 128, 96, null);
			}
			else{
				g2d.drawImage(civicR, 104, 200, 404, 477, 0, 0, 128, 96, null);
			}
		}
	}
	
	public void statsScreen(Graphics2D g2d){
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		
		g2d.setColor(Color.WHITE);
		g2d.drawImage(backButton, 1730, -25, 1902, 132, 0, 0, 192, 192, null);
		g2d.drawString("$" + String.valueOf(money), 30, 60);

	}
	public void utilScreen(Graphics2D g2d){
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		
		g2d.setColor(Color.WHITE);
		
		g2d.drawImage(backButton, 1730, -25, 1902, 132, 0, 0, 192, 192, null);
		g2d.drawString("$" + String.valueOf(money), 30, 60);
		
	}
	public void logScreen(Graphics2D g2d){
		g2d.setColor(Color.ORANGE);
		g2d.fillRect(0,  0, SIZE.width, SIZE.height);
		
		g2d.drawImage(statBar, 0, 900, 1920, 1050, 0, 0, 240, 60, null);
		g2d.drawImage(statBar, 0, 30, 1920, 80, 0, 0, 240, 60, null);
		
		g2d.drawImage(backButton, 1730, -25, 1902, 132, 0, 0, 192, 192, null);
		g2d.drawString("$" + String.valueOf(money), 30, 60);
	}
	
	public void beachBoys(Graphics2D g2d){
		drawering(g2d, arg1);
	}
	
	public void draw() {

		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
		
		
		beachBoys(g2d);
		if(isRunning){
			
			g2d = (Graphics2D) frame.getGraphics();
			g2d.drawImage(imgBuffer, 0, 0, SIZE.width, SIZE.height,  null);
			g2d.dispose();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		arg1 = arg0;
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
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
	public void windowClosing(WindowEvent arg0) {
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

}
