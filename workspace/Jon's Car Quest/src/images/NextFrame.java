package images;

import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NextFrame extends Paint{
	
	private boolean Done = false;
	
	Scanner reader = new Scanner(System.in);
	
	public void frameLoop(Graphics G){
		while(!Done){
			overWrite(G);
			loadNext(G);
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
		}
	}
	
	public void overWrite(Graphics G){
		this.setBackground(Color.BLACK);
		//G.setColor(Color.BLACK);
		//G.fillRect(1, 1, 10000, 10000);
	}
	
	public void loadNext(Graphics G){
		
	}
	
}
