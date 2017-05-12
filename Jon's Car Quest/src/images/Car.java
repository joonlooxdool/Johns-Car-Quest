package images;

import java.util.Random;

public class Car {
	private static int odo, cond, price, titleStatus, year, problems, basePrice, carYear, rarity;
	private static String model;
	
	
	public static String carCall(){
		return model;
	}
	
	
	
	public Car(){
		
		Random rand = new Random();
		rarity = rand.nextInt(1000);
		if (rarity > 0 && rarity < 50){
			model = "Honda Civic type R";
			//miles = randommiles;
		}
		if (rarity > 50 && rarity < 70){
			model = "Datsun 510";
		}
		if (rarity > 70 && rarity < 140){
			model = "BMW M3";
		}
		if (rarity > 140 && rarity < 230){
			model = "Toyota FJ Cruiser";
		}
		if (rarity > 230 && rarity < 300){
			model = "Mercedes C-Class Coupe";
		}
		if (rarity > 300 && rarity < 340){
			model = "Mazda  RX-7";
		}
		if (rarity > 340 && rarity < 1000){
			model = "Toyota 2000GT";
		}
		
		
		cond = (odo/380000) +  (titleStatus/3) + (carYear/2017) + (problems/1) + (rand.nextInt(1) + 0);
		titleStatus = rand.nextInt(3) + 1;
		year += rand.nextInt(50);
	}
			
		
}
	
