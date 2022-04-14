import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int N = sc.nextInt();
    	int T = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	int l = 0, r = N, mid, res = 1000000000;
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	while(l <= r) {
    		mid = (l + r) / 2;
    		pq.clear();
    		int t = 0, idx = mid;
    		
    		for(int i = 0; i < mid; i++) pq.offer(arr[i]);
    		
    		while (!pq.isEmpty()) {
				t = pq.poll();
				
				if(idx < N) {
					pq.offer(arr[idx] + t);
					idx += 1;
				}
			}
    		
    		if(t <= T) {
    			res = Math.min(res, mid);
    			r = mid - 1;
    		}
    		else l = mid + 1;
    	}
    	
    	System.out.println(res);
	}
}