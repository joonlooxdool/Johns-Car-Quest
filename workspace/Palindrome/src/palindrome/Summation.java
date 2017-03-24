package palindrome;

public class Summation {
	
	long result = 0;
	
	public long method(int mult){
		for(int i = 0; i < 2000000; i++){
			if(isPrime(i)){
				result = result + i;
			}
		}
		return result;
	}
	
	public boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}
	
}
