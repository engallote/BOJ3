import java.util.*;

public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.nextInt();
    	
    	int l = 1, r = 1000000000, mid, res = 0;
    	while(l <= r) {
    		mid = (l + r) / 2;
    		
    		int cnt = 0, min = Integer.MAX_VALUE, sum = 0;
    		for(int i = 0; i < N; i++) {
    			sum += arr[i];
    			
    			if(sum >= mid) {
    				++cnt;
    				min = Math.min(min, sum);
    				sum = 0;
    			}
    		}
    		
    		if(cnt >= M) {
    			res = Math.max(res, mid);
    			l = mid + 1;
    		}
    		else r = mid - 1;
    	}
    	
    	System.out.println(res);
    }
}