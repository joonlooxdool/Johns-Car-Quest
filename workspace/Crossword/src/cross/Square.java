package cross;

public class Square {

	int[] blacksquares = {0, 3, 4, 5, 14, 26, 27, 28, 32, 36, 40, 41, 42, 54, 55, 56, 59};
	
	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares){
	    return !blackSquares[r][c] &&
	        (r == 0 || blackSquares[r-1][c] || c == 0 || blackSquares[r][c-1]);
	  }
	
	public boolean Square(boolean isBlack, int num){
		for(int i = 0; i < 63; i++){
			if(isBlack) return true;
		}
		return false;
	}
	
	public boolean isBlack(int sqr){
		for(int i = 0; i <= blacksquares.length; i++){
			if(blacksquares[sqr] == i){
				return true;
			}
		}
		return false;
	}

}
