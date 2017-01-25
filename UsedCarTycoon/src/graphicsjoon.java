
import java.awt.Component;

import javax.swing.*; 

public class graphicsjoon {

	public static void main(String[] args){ 
		
		JFrame f = new JFrame ("JoonLooxDool"); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joonlooxdool j = new joonlooxdool(); 
		f.add(j);
		f.setSize(800, 300);
		f.setVisible(true);;

}
} 