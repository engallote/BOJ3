import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int N = sc.nextInt();
			int d = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			
			if(d > 0) {
				while(d > 0) {
					for(int i = 0; i < N / 2; i++) {
						int tmp = arr[i][i];
						arr[i][i] = arr[N / 2][i];
						arr[N / 2][i] = arr[N - i - 1][i];
						arr[N - i - 1][i] = arr[N - i - 1][N / 2];
						arr[N - i - 1][N / 2] = arr[N - i - 1][N - i - 1];
						arr[N - i - 1][N - i - 1] = arr[N / 2][N - i - 1];
						arr[N / 2][N - i - 1] = arr[i][N - i - 1];
						arr[i][N - i - 1] = arr[i][N / 2];
						arr[i][N / 2] = tmp;
					}
					d -= 45;
				}
			}
			else {
				while(d < 0) {
					for(int i = 0; i < N / 2; i++) {
						int tmp = arr[i][i];
						arr[i][i] = arr[i][N / 2];
						arr[i][N / 2] = arr[i][N - i - 1];
						arr[i][N - i - 1] = arr[N / 2][N - i - 1];
						arr[N / 2][N - i - 1] = arr[N - i - 1][N - i - 1];
						arr[N - i - 1][N - i - 1] = arr[N - i - 1][N / 2];
						arr[N - i - 1][N / 2] = arr[N - i - 1][i];
						arr[N - i - 1][i] = arr[N / 2][i];
						arr[N / 2][i] = tmp;
					}
					d += 45;
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
	}
}