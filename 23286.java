import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int T = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) Arrays.fill(arr[i], 100000000);
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(Math.max(arr[i][k], arr[k][j]) < arr[i][j])
						arr[i][j] = Math.max(arr[i][k], arr[k][j]);
		
		for(int i = 0; i < T; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println(arr[s][e] == 100000000 ? -1: arr[s][e]);
		}
	}
}