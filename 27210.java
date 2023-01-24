import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	int left = 0, right = 0, max = 0;
    	
    	for(int i = 0; i < N; i++) {
    		if(arr[i] == 1) {
    			left += 1;
    			right -= 1;
    		}
    		else {
    			left -= 1;
    			right += 1;
    		}
    		
    		if(left < 0) left = 0;
    		if(right < 0) right = 0;
    		
    		max = Math.max(max, Math.max(left, right));
    	}
    	
    	System.out.println(max);
	}
}