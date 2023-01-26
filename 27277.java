import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	Arrays.sort(arr);
    	
    	int l = 0, r = N - 1, who = 1;
    	Queue<Integer> q = new LinkedList<>();
    	
    	while(l + 1 < r) {
    		if(who == 1) {
    			q.offer(arr[r]);
    			r -= 1;
    		}
    		else {
    			q.offer(arr[l]);
    			l += 1;
    		}
    		who *= -1;
    	}
    	
    	while(l <= r) q.offer(arr[l++]);
    	
    	int res = q.poll(), pre = res;
    	while(!q.isEmpty()) {
    		res += Math.max(0, q.peek() - pre);
    		pre = q.poll();
    	}
    	
    	System.out.println(res);
	}
}