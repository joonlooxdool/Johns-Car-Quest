package palindrome;

public class sumsquare {
	int result2 = 0;
	int result = 0;
	int result3 = 0;
	
	public int method(int mult){
		int[] array100 = new int[100];
		for(int i = 0; i < 100; i++){
			if(i == 0){
				array100[0] = 1;
			}else{
				array100[i] = (i+1)*(i+1);
			}
		}
		
		for(int i = 0; i < 100; i++){
			result += array100[i];
		}
		
		return result;
		
	}
	
	public int method2(int mult){
		result2 = 0;
		for(int i = 0; i <= 100; i++){
			result2 += i;
		}
		System.out.println("Sum: " + result2);
		return result2;
	}
	
	public int method3(int mult){
		method2(0);
		result3 = result2*result2;
		return result3;
	}
	
	public int method4(int mult){
		method(0);
		method2(0);
		method3(0);

		return (result3 - result);
	}
}
