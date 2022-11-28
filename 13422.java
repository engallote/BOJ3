import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		int K = sc.nextInt();
    		int[] arr = new int[N];
    		
    		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    		
    		int sum = 0, res = 0;
    		for(int i = 0; i < M; i++) sum += arr[i];
    		
    		if(sum < K) ++res;
    		if(N == M) {
    			System.out.println(res);
    			continue;
    		}
    		
    		for(int i = 1, r = M; i < N; i++, r++) {
    			if(r == N) r = 0;
    			
    			sum -= arr[i - 1];
    			sum += arr[r];
    			
    			if(sum < K) ++res;
    			
    		}
    		System.out.println(res);
    	}
	}
}