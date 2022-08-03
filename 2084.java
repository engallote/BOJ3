import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int[] chk = new int[N];
		
		int sum = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>(), tmp = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			pq.offer(new Pair(i, num));
			chk[i] = num;
			sum += num;
		}
		
		if(sum % 2 != 0) {
			System.out.println(-1);
			return;
		}
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(chk[p.v] == 0) continue;
			int cnt = chk[p.v];
			chk[p.v] = 0;
			
			while(!pq.isEmpty()) {
				Pair p2 = pq.poll();
				
				if(arr[p.v][p2.v] == 1) {
					tmp.offer(p2);
					continue;
				}
				if(chk[p2.v] == 0) continue;
				
				arr[p.v][p2.v] = arr[p2.v][p.v] = 1;
				chk[p2.v] -= 1;
				cnt -= 1;
				tmp.offer(new Pair(p2.v, p2.num - 1));
				if(cnt == 0) break;
			}
			
			pq.addAll(tmp);
			tmp.clear();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
class Pair implements Comparable<Pair> {
	int v, num;
	Pair(int v, int num) {
		this.v = v;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(o.num, this.num);
	}
}