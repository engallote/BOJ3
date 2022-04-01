import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 10000000);
			arr[i][i] = 0;
		}
		
		for(int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		int res = 0;
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(arr[i][j] != 10000000) ++cnt;
				if(arr[j][i] != 10000000) ++cnt;
			}
			if(cnt == N - 1) ++res;
		}
		
		System.out.println(res);
	}
}