import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int[] arr = new int[N];
    	int max = 0, min = Integer.MAX_VALUE, idx = 0;
    	
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextInt();
    		if(i < K && arr[i] <= min) {
    			min = arr[i];
    			idx = i + 1;
    		}
    	}
    	
    	max = min;
    	
    	while(idx + K <= N) {
    		int tmp = 0, cnt = 0;
    		min = 0;
    		
    		for(int i = idx; i < N; i++) {
    			if(max >= arr[i]) {
    				tmp = i + 1;
    				break;
    			}
    			else {
    				if(min == 0) {
    					min = arr[i];
    					tmp = i + 1;
    				}
    				else {
    					if(min >= arr[i]) {
    						min = arr[i];
    						tmp = i + 1;
    					}
    				}
    				
    				++cnt;
    				if(cnt == K) break;
    			}
    		}
    		
    		max = Math.max(max, min);
    		idx = tmp;
    	}
    	
    	System.out.println(max);
	}
}