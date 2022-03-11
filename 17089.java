import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		ArrayList<Integer>[] aly = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;
			aly[a].add(b);
			aly[b].add(a);
		}
		
		int res = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
			for(int j = i + 1; j <= N; j++) {
				if(arr[i][j] != 1) continue;
				for(int k = j + 1; k <= N; k++)
					if(arr[i][k] == 1 && arr[j][k] == 1) {
						res = Math.min(res, aly[i].size() + aly[j].size() + aly[k].size() - 6);
					}
			}
		
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
}