import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int res = 0;
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    	
    	for(int i = 0; i < N; i++) pq.offer(sc.nextInt());
    	
    	while(!pq.isEmpty()) {
    		int a = pq.poll();
    		
    		if(pq.isEmpty()) {
    			a -= 1;
    			if(a > 0) pq.offer(a);
    			++res;
    			continue;
    		}
    		else {
    			int b = pq.poll();
    			a -= 1;
    			b -= 1;
    			if(a > 0) pq.offer(a);
    			if(b > 0) pq.offer(b);
    			++res;
    		}
    	}
    	
    	if(res > 1440) System.out.println(-1);
    	else System.out.println(res);
	}
}