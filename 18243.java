import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(arr[i], 1000000000);
			arr[i][i] = 0;
		}
		for(int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++)
				if(arr[i][j] > 6) {
					System.out.println("Big World!");
					return;
				}
		
		System.out.println("Small World!");
	}
}