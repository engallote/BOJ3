import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] next = new int[N];
		long[][] cost = new long[N][3];
		int[] cnt = new int[N + 1];
		
		for(int i = 0; i < M; i++) next[i] = sc.nextInt();
		for(int i = 0; i < N - 1; i++) {
			cost[i][0] = sc.nextLong();
			cost[i][1] = sc.nextLong();
			cost[i][2] = sc.nextLong();
		}
		
		for(int i = 0; i < M - 1; i++) {
			if(next[i] < next[i + 1]) {
				cnt[next[i]] += 1;
				cnt[next[i + 1]] -= 1;
			}
			else {
				cnt[next[i]] -= 1;
				cnt[next[i + 1]] += 1;
			}
		}
		
		long sum = 0, res = 0;
		for(int i = 0; i < N; i++) {
			sum += cnt[i + 1];
			res += Math.min(cost[i][0] * sum, cost[i][1] * sum + cost[i][2]);
		}
		
		System.out.println(res);
	}
}