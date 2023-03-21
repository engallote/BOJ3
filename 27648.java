import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N + 1][M + 1];
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++)
				arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]) + 1;
		
		if(arr[N][M] > K) {
			System.out.println("NO");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) sb.append(arr[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}