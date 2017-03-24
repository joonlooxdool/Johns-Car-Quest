package cross;

import java.util.*;

public class RandomStringChooser {
	private ArrayList <String> words;
	public RandomStringChooser (String[]ar){
		words = new ArrayList <String>();
		for (String str:ar){
			words.add(str);
		}
	}
	public String getNext(){
		  if (words.size() == 0)
		    return "NONE"; 
		  int i = (int)(Math.random() * words.size());
		  return words.remove(i); 
	}
}
