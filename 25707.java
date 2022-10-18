import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++) pq.offer(sc.nextInt());
    	
    	int res = 0;
    	Deque<Integer> dq = new LinkedList<>();
    	while(!pq.isEmpty()) {
    		int x = pq.poll();
    		
    		if(!dq.isEmpty()) {
    			if(pq.isEmpty()) {//마지막 숫자
    				res += Math.abs(dq.peekFirst() - x);
    				res += Math.abs(dq.peekLast() - x);
    			}
    			else {
    				if(Math.abs(dq.peekFirst() - x) < Math.abs(dq.peekLast() - x)) {
        				res += Math.abs(dq.peekFirst() - x);
        				dq.offerFirst(x);
        			}
        			else {
        				res += Math.abs(dq.peekLast() - x);
        				dq.offerLast(x);
        			}
    			}
    			
    		}
    		else dq.offer(x);
    	}
    	
    	System.out.println(res);
	}
}