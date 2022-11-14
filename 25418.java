import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	int K = sc.nextInt();
    	boolean[] chk = new boolean[1000001];
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(A);
    	int time = 0;
    	
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			int x = q.poll();
    			
    			if(x == K) {
    				System.out.println(time);
    				return;
    			}
    			
    			if(x + 1 <= K && !chk[x + 1]) {
    				chk[x + 1] = true;
    				q.offer(x + 1);
    			}
    			if(x * 2 <= K && !chk[x * 2]) {
    				chk[x * 2] = true;
    				q.offer(x * 2);
    			}
    		}
    		++time;
    	}
	}
}