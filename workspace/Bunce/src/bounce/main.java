package bounce;

//import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		boolean done = false;
		double numBouncy = 0;
		
		//ArrayList<String> Bouncy = new ArrayList<String>();
		for(double i = 100; done == false; i++){
			
			String numString = Double.toString(i).substring(0, Double.toString(i).indexOf('.'));
			System.out.println("Ratio is: " + (numBouncy/i)*100);
			
			if((numBouncy/i)*100 >= 99 && (numBouncy/i)*100 <= 99){
				System.out.println("THE FINAL RATIO IS: "+ (numBouncy/i)*100 + ". THE FINAL NUMBER IS: " + (i-10));
				break;
			}
			
			boolean ascend = false;
			boolean descend = false;
			
			for(int j = 1; j <= numString.length()-1; j++){
				if(numString.charAt(j-1) > numString.charAt(j)){
					descend = true;
				}
				if(numString.charAt(j) > numString.charAt(j-1)){
					ascend = true;
				}
			}
			
			if(descend && ascend){
				System.out.println(numString + " IS BOUNCY MY DUDE");
				numBouncy++;
				//Bouncy.add(numString);
			}
		}
//System.out.println(Bouncy.toString());
	}

}
