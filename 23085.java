import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	int h = 0;
    	
    	char[] ch = sc.next().toCharArray();
    	for(char c : ch) if(c == 'H') ++h;
    	
    	boolean[] chk = new boolean[3001];
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(h);
    	
    	int time = 0;
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			int H = q.poll();
    			int T = N - H;
    			
    			if(H == 0) {
    				System.out.println(time);
    				return;
    			}
    			
    			for(int i = 0; i <= K; i++) {
    				if(i > H || K - i > T) continue;
    				if(chk[H - i + (K - i)]) continue;
    				q.offer(H - i + (K - i));
    				chk[H - i + (K - i)] = true;
    			}
    		}
    		++time;
    	}
    	
    	System.out.println(-1);
	}
}