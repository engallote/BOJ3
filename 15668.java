import java.util.*;

public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int max = 987654;
    	
    	for(int i = 1; i < Math.min(N, max); i++) {
    		int[] arr = new int[10];
    		int num = N - i, tmp = i;
    		boolean flag = true;
    		while(tmp > 0) {
    			arr[tmp % 10] += 1;
    			
    			if(arr[tmp % 10] != 1) {
    				flag = false;
    				break;
    			}
    			
    			tmp /= 10;
    		}
    		
    		while(num > 0) {
    			arr[num % 10] += 1;
    			
    			if(arr[num % 10] != 1) {
    				flag = false;
    				break;
    			}
    			
    			num /= 10;
    		}
    		
    		if(flag) {
    			System.out.println((N - i) + " + " + i);
    			return;
    		}
    	}
    	
    	System.out.println(-1);
    }
}