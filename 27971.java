import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int[][] arr = new int[M][2];
		
		for(int i = 0; i < M; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			arr[i][0] = l;
			arr[i][1] = r;
		}
		
		HashSet<Integer> hs = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		hs.add(0);
		boolean flag = false;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				if(x == N) {
					System.out.println(cnt);
					return;
				}
				
				if(x + A <= N && !hs.contains(x + A)) {
					flag = true;
					for(int i = 0; i < M; i++)
						if(arr[i][0] <= x + A && x + A <= arr[i][1]) {
							flag = false;
							break;
						}
					
					if(flag) {
						q.offer(x + A);
						hs.add(x + A);
					}
				}
				if(x + B <= N && !hs.contains(x + B)) {
					flag = true;
					for(int i = 0; i < M; i++)
						if(arr[i][0] <= x + B && x + B <= arr[i][1]) {
							flag = false;
							break;
						}
					if(flag) {
						hs.add(x + B);
						q.offer(x + B);
					}
				}
			}
			++cnt;
		}
		
		System.out.println(-1);
	}
}