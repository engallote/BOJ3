import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	int res = 1, sum = 0, cnt = 1;
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	for(int i = 0; i < N; i++) {
    		sum = arr[i];
    		cnt = 1;
    		for(int j = i + 1; j < N; j++) {
    			if(sum >= arr[j]) {
    				sum += arr[j];
    				++cnt;
    			}
    		}
    		
    		res = Math.max(res, cnt);
    	}
    	
    	System.out.println(res);
	}
}