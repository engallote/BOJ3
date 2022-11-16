import java.util.*;

public class Main {
	static int N, K, res;
	static ArrayList<Integer>[] tree;
	static int[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	tree = new ArrayList[N];
    	arr = new int[N];
    	res = 0;
    	
    	for(int i = 0; i < N; i++) tree[i] = new ArrayList<>();
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		tree[a].add(b);
    	}
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	bfs();
    	System.out.println(res);
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				res += arr[x];
				
				for(int next : tree[x])
					q.offer(next);
			}
			++time;
			
			if(time > K) return;
		}
	}
}