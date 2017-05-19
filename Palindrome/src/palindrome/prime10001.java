package palindrome;

public class prime10001 {
	
	public int method(int mult){
		
		int numPrimes = 0;
		int answer = 0;
		
		for(int i = 0; numPrimes < 10001; i++){
			if(isPrime(i)) numPrimes++;
			if(numPrimes == 10001) answer = i; 
		}
		
		return answer;
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
