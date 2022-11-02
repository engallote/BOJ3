import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int num = N / 2;
    	boolean[] chk = new boolean[N + 1];
    	Deque<Integer> dq = new LinkedList<>();
    	dq.offer(1);
    	
    	int cnt = 1;
    	while(cnt < N) {
    		for(int i = 2; i <= N; i++) {
    			if(chk[i]) continue;
    			if(Math.abs(dq.peekFirst() - i) >= num) {
    				chk[i] = true;
    				dq.offerFirst(i);
    				break;
    			}
    			else if(Math.abs(dq.peekLast() - i) >= num) {
    				chk[i] = true;
    				dq.offerLast(i);
    				break;
    			}
    		}
    		++cnt;
    	}
    	
    	while(!dq.isEmpty()) System.out.print(dq.pollFirst() + " ");
	}
}