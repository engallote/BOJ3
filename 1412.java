import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		int[] indgree = new int[N];
		ArrayList<Integer>[] aly = new ArrayList[N];
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			aly[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'N') continue;
				if(i == j) {
					System.out.println("NO");
					return;
				}
				if(map[i][j] != map[j][i]) {
					aly[i].add(j);
					indgree[j] += 1;
				}
			}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++)
			if(indgree[i] == 0) q.offer(i);
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(int next : aly[x]) {
					indgree[next] -= 1;
					
					if(indgree[next] == 0) q.offer(next);
				}
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < N; i++)
			if(indgree[i] != 0) {
				flag = false;
				break;
			}
		
		System.out.println(flag ? "YES" : "NO");
	}
}